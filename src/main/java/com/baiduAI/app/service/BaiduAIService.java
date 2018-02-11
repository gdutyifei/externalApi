package com.baiduAI.app.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baiduAI.app.bean.BaiduAIBean;
import com.baiduAI.app.sao.BaiduAISao;
import com.baiduAI.app.util.Base64Util;
import com.baiduAI.app.util.HttpUtil;
import com.baiduAI.app.util.ImageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luoyifei on 2018/2/9.
 */
@Slf4j
@Service
public class BaiduAIService {

    @Autowired
    private BaiduAISao baiduAISao;

    @Value("${baidu.api.clientId}")
    private String baiduAIClientId;

    @Value("${baidu.api.clientSecret}")
    private String baiduAIClientSecret;

    @Value("${baidu.api.groupId}")
    private String groupId;

    @Value("${https://aip.baidubce.com/rest/2.0/face/v1/detect}")
    private String detectUrl;

    @Value("${https://aip.baidubce.com/rest/2.0/face/v2/identify}")
    private String identifyUrl;

    @Value("${https://aip.baidubce.com/rest/2.0/face/v2/faceset/user/add}")
    private String addUrl;

    @Value("${https://aip.baidubce.com/rest/2.0/face/v2/faceset/user/update}")
    private String updateUrl;

    /**
     * 人脸库注册
     * @return
     * @throws Exception
     */
    public String facesetAdd(@RequestParam(value = "imgUrl", required = true) String imgUrl, @RequestParam(value = "userInfo") String userInfo, @RequestParam(value = "openid", required = true) String openid)  {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            // 调用百度AI接口获取accessToken
            String accessData = baiduAISao.getAccessToken("client_credentials", baiduAIClientId, baiduAIClientSecret);
            JSONObject accessJson = JSONObject.parseObject(accessData);
            // 获取access_token
            String accessToken = accessJson.get("access_token").toString();
            log.info(accessToken);
            // 对前端返回的图片url进行处理
            log.info("图片地址： " + imgUrl);
            byte[] imgData = ImageUtils.getImgeHexString(imgUrl, "jpg");
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String detectParam = "max_face_num=" + 1 + "&image=" + imgParam;
            // 调用人脸识别接口
            String detectData = HttpUtil.post(detectUrl, accessToken, detectParam);
            log.info("检测人脸数据 + " + detectData);
            JSONObject detectJson = JSONObject.parseObject(detectData);
            // 获取人脸数
            int faceNum = Integer.parseInt(detectJson.get("result_num").toString());
            if (faceNum == 0) {
                // 如果人脸数为0， 说明检测到人脸， 返回给前端结果， 继续循环调用。
                result.put("code", "000");
                result.put("data", null);
                result.put("msg", "没有检测到人脸");
                String resultJSON = JSON.toJSONString(result);
                return resultJSON;
            } else {
                // 调用人脸库注册接口
                // uid 使用openid
                String addParam = "uid=" + openid + "&user_info=" + userInfo + "&group_id=" + groupId + "&image=" + imgParam;
                String addData = HttpUtil.post(addUrl, accessToken, addParam);
                log.info("添加人脸库返回数据： " + addData);
                // JSONObject addJson = JSONObject.parseObject(addData);
                result.put("code", "200");
                result.put("data", addData);
                result.put("msg", "添加人脸库成功");
                String resultJSON = JSON.toJSONString(result);
                return resultJSON;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", "999");
            result.put("data", null);
            result.put("msg", "系统出错");
            String resultJSON = JSON.toJSONString(result);
            return resultJSON;
        }
    }

    /**
     * 人脸库更新
     * @return
     * @throws Exception
     */
    public String facesetUpdate(@RequestParam(value = "imgUrl", required = true) String imgUrl, @RequestParam(value = "userInfo") String userInfo, @RequestParam(value = "openid", required = true) String openid)  {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            // 调用百度AI接口获取accessToken
            String accessData = baiduAISao.getAccessToken("client_credentials", baiduAIClientId, baiduAIClientSecret);
            JSONObject accessJson = JSONObject.parseObject(accessData);
            // 获取access_token
            String accessToken = accessJson.get("access_token").toString();
            log.info(accessToken);
            // 对前端返回的图片url进行处理
            byte[] imgData = ImageUtils.getImgeHexString(imgUrl, "jpg");
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String detectParam = "max_face_num=" + 1 + "&image=" + imgParam;
            // 调用人脸识别接口
            String detectData = HttpUtil.post(detectUrl, accessToken, detectParam);
            log.info("检测人脸数据 + " + detectData);
            JSONObject detectJson = JSONObject.parseObject(detectData);
            // 获取人脸数
            int faceNum = Integer.parseInt(detectJson.get("result_num").toString());
            if (faceNum == 0) {
                // 如果人脸数为0， 说明检测到人脸， 返回给前端结果， 继续循环调用。
                result.put("code", "000");
                result.put("data", null);
                result.put("msg", "没有检测到人脸");
                String resultJSON = JSON.toJSONString(result);
                return resultJSON;
            } else {
                // 调用人脸库更新接口
                // uid 使用openid
                String updateParam = "uid=" + openid + "&user_info=" + userInfo + "&group_id=" + groupId + "&image=" + imgParam + "&action_type=replace";
                String updateData = HttpUtil.post(updateUrl, accessToken, updateParam);

                log.info("更新人脸库返回数据： " + updateData);
                // JSONObject updateJson = JSONObject.parseObject(updateData);
                result.put("code", "200");
                result.put("data", updateData);
                result.put("msg", "更新人脸库成功");
                String resultJSON = JSON.toJSONString(result);
                return resultJSON;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", "999");
            result.put("data", null);
            result.put("msg", "系统出错");
            String resultJSON = JSON.toJSONString(result);
            return resultJSON;
        }
    }

    /**
     * 人脸查找
     * @return
     * @throws Exception
     */
    public String facesetIdentify(@RequestParam(value = "imgUrl", required = true) String imgUrl)  {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            // 调用百度AI接口获取accessToken
            String accessData = baiduAISao.getAccessToken("client_credentials", baiduAIClientId, baiduAIClientSecret);
            JSONObject accessJson = JSONObject.parseObject(accessData);
            // 获取access_token
            String accessToken = accessJson.get("access_token").toString();
            log.info(accessToken);
            // 对前端返回的图片url进行处理
            byte[] imgData = ImageUtils.getImgeHexString(imgUrl, "jpg");
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String detectParam = "max_face_num=" + 1 + "&image=" + imgParam;
            // 调用人脸识别接口
            String detectData = HttpUtil.post(detectUrl, accessToken, detectParam);
            log.info("检测人脸返回数据 + " + detectData);
            JSONObject detectJson = JSONObject.parseObject(detectData);
            // 获取人脸数
            int faceNum = Integer.parseInt(detectJson.get("result_num").toString());
            if (faceNum == 0) {
                // 如果人脸数为0， 说明检测到人脸， 返回给前端结果， 继续循环调用。
                result.put("code", "000");
                result.put("data", null);
                result.put("msg", "没有检测到人脸");
                String resultJSON = JSON.toJSONString(result);
                return resultJSON;
            } else {
                // 调用人脸库识别接口
                // uid 使用openid
                String identifyParam = "group_id=" + groupId + "&image=" + imgParam + "&user_top_num=" + 1;
                String identifyData = HttpUtil.post(identifyUrl, accessToken, identifyParam);

                log.info("人脸查找返回数据： " + identifyData);
                JSONObject identifyJson = JSONObject.parseObject(identifyData);
                if (Integer.parseInt(identifyJson.get("result_num").toString()) == 1) {
                    // 说明找到人脸, 获取用户信息返回到前端
                    String resultInfo = identifyJson.get("result").toString();
                    result.put("code", "200");
                    result.put("data", resultInfo);
                    result.put("msg", "人脸识别成功");
                    String resultJSON = JSON.toJSONString(result);
                    return resultJSON;
                } else {
                    result.put("code", "777");
                    result.put("data", null);
                    result.put("msg", "人脸识别失败");
                    String resultJSON = JSON.toJSONString(result);
                    return resultJSON;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", "999");
            result.put("data", null);
            result.put("msg", "系统出错");
            String resultJSON = JSON.toJSONString(result);
            return resultJSON;
        }
    }


}
