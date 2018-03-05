package com.baiduAI.app.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baiduAI.app.bean.TemplateBean;
import com.baiduAI.app.bean.WxCodeBean;
import com.baiduAI.app.dao.CardListDAO;
import com.baiduAI.app.dao.FormIdInfoDAO;
import com.baiduAI.app.dao.WechatInfoDAO;
import com.baiduAI.app.dto.FormIdDTO;
import com.baiduAI.app.dto.WechatDTO;
import com.baiduAI.app.dto.WechatDTOToB;
import com.baiduAI.app.sao.WxSao;
import com.baiduAI.app.util.EmojiUtil;
import com.baiduAI.app.util.FileUtil;
import com.baiduAI.app.util.WeChatSystemContext;
import com.baiduAI.app.util.WeixinTemplateNotice;
import io.swagger.client.model.RegisterUsers;
import io.swagger.client.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luoyifei on 2018/2/10.
 */
@Slf4j
@Service
//@Transactional
public class WechatService {

    public static final Logger logger = LoggerFactory.getLogger(WechatService.class);

    @Autowired
    private WxSao wxSao;

    @Autowired
    private FormIdInfoDAO formIdInfoDAO;

    @Autowired
    private WeChatSystemContext weChatSystemContext;

    @Autowired
    private WechatInfoDAO wechatInfoDAO;

    @Autowired
    private EasemobService easemobService;

    @Autowired
    private CardListDAO cardListDAO;

    @Value("${wx.appid.c}")
    private String appid_c;

    @Value("${wx.appsecret.c}")
    private String appSecret_c;

    @Value("${wx.appid.b}")
    private String appid_b;

    @Value("${wx.appsecret.b}")
    private String appSecret_b;

    @Value("${img.local.path}")
    private String imgLocalPath;

    @Value("${img.host}")
    private String imgHost;

    /**
     * 用户咨询模版消息
     */
    @Value("${wx.micropro.consult.tempid}")
    private String consult_notice_tempid;

    /**
     * 根据openid获取C端用户微信信息
     * @param openid
     * @return
     */
    public WechatDTO getWechatDTOInfoByOpenid(@RequestParam("openid") String openid) {
        return wechatInfoDAO.getWechatInfoByOpenid(openid);
    }

    /**
     * 根据code获取openid
     *
     * @param code
     * @return
     */
    public String getOpenidByCode(@RequestParam("code") String code, @RequestParam("type") String type) {
        try {
            String userStr = "";
            if (StringUtils.equals(type, "B")) {
                userStr = wxSao.getJscode2session(appid_c, appSecret_c, code, "authorization_code");
            } else {
                userStr = wxSao.getJscode2session(appid_c, appSecret_c, code, "authorization_code");
            }
            JSONObject userInfo = JSONObject.parseObject(userStr);
            // String openid = userInfo.getString("openid");
            // String session_key = userInfo.getString("session_key");
            return userStr;
        } catch (Exception e) {
            return e.toString();
        }
    }

    /**
     * 保存用户微信信息
     * @param userInfo
     * @param code
     * @return
     */
    public Map<String, Object> saveUserInfo(@RequestParam("userInfo") String userInfo, @RequestParam("code") String code, @RequestParam("type") String type) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        logger.info(userInfo);
        String loginInfo = this.getOpenidByCode(code, type);
        if ("".equals(loginInfo) || null == loginInfo) {
            returnMap.put("msg", "非法code");
            return returnMap;
        }
        String unionId = "";
        if (JSON.parseObject(loginInfo).get("unionid") != null) {
            unionId = JSON.parseObject(loginInfo).get("unionid").toString();
        }
        // String unionId = WxDecrypt.wxDecrypt(encryptedData, session_key, iv);
        logger.info("unionId: " + unionId);

        JSONObject jsonObject = JSON.parseObject(userInfo);
        String openid = jsonObject.get("openid").toString();
        String nickName = jsonObject.get("nickName").toString();
        String avatarUrl = jsonObject.get("avatarUrl").toString();
        String gender = StringUtils.equals(jsonObject.get("gender").toString(), "1") ? "male" : "female";
        String city = jsonObject.get("city").toString();
        String province = jsonObject.get("province").toString();
        String country = jsonObject.get("country").toString();

        if (EmojiUtil.containsEmoji(nickName)) {
            nickName = EmojiUtil.filterEmoji(nickName);
        }
        if (StringUtils.equals(type, "C")) {
            WechatDTO wechatDTO = wechatInfoDAO.getWechatInfoByOpenid(openid);
            if (wechatDTO == null) {
                // 保存用户信息
                wechatInfoDAO.saveWechatInfo(openid, nickName, avatarUrl, gender, city, province, country, unionId);
                returnMap.put("msg", "保存用户信息成功");
                // 注册环信用户
                RegisterUsers users = new RegisterUsers();
                User user = new User().username(openid).password(openid);
                users.add(user);
                Object easemobresult = easemobService.registerEasemobUser(users);
                return returnMap;
            }
            returnMap.put("msg", "已经存在用户数据");
            return returnMap;
        } else {
            WechatDTOToB wechatDTO = wechatInfoDAO.getBWechatInfoByOpenid(openid);
            if (wechatDTO == null) {
                // 保存用户信息
                wechatInfoDAO.saveBWechatInfo(openid, nickName, avatarUrl, gender, city, province, country, unionId);
                returnMap.put("msg", "保存用户信息成功");
                // 注册环信用户
                RegisterUsers users = new RegisterUsers();
                User user = new User().username(openid).password(openid);
                users.add(user);
                Object easemobresult = easemobService.registerEasemobUser(users);
                // Assert.assertNotNull(easemobresult);
                // 在这里添加名片列表数据
                // cardListDAO.saveCardToList(openid, );
                return returnMap;
            }
            returnMap.put("msg", "已经存在用户数据");
            return returnMap;
        }

    }

    /**
     * 微信上传图片
     *
     * @param file
     * @return
     */
    public String uploadImage(@RequestParam(required = true, value = "file") MultipartFile file) {
        if (null == file) {
            return null;
        }
        String random = RandomStringUtils.randomAlphanumeric(16);
        String fileName = random + ".jpg";
        try {
            String uploadDirName = imgLocalPath.substring(imgLocalPath.lastIndexOf("/"), imgLocalPath.length());
            logger.info(uploadDirName);
            FileCopyUtils.copy(file.getBytes(), new File(imgLocalPath + "/", fileName));
            return imgHost + uploadDirName + "/" + fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 发送模板消息
     *
     * @param openid
     * @param contentArr
     * @param templateMsgType
     * @param url
     * @return
     */
    public Map<String, Object> sendTemplateMsg(String openid, String[] contentArr, String templateMsgType, String url, String tokenType) {
        Map<String, Object> returnMap = new HashMap<String, Object>();

        WeixinTemplateNotice.CommonNoticeBean bean = new WeixinTemplateNotice().new CommonNoticeBean();
        WeixinTemplateNotice.CommonNoticeFourBean beanFour = new WeixinTemplateNotice().new CommonNoticeFourBean();
        WeixinTemplateNotice.CommonNoticeFiveBean beanFive = new WeixinTemplateNotice().new CommonNoticeFiveBean();
        bean.setTouser(openid);
        bean.setPage(url);
        beanFour.setTouser(openid);
        beanFour.setPage(url);
        beanFive.setTouser(openid);
        beanFive.setPage(url);

        // 查找7天内可用的formId
        FormIdDTO formIdDTO = formIdInfoDAO.findByOpenidAndIsusedOrderByCreatedDateDesc(openid, "N");
        if (formIdDTO == null) {
            returnMap.put("code", 400);
            returnMap.put("msg", "无可用formId");
            return returnMap;
        }
        String formId = formIdDTO.getForm_id();

        if (contentArr.length == 3) {
            bean.setForm_id(formId);
            bean.setKeyword1(contentArr[0]);
            bean.setKeyword2(contentArr[1]);
            bean.setKeyword3(contentArr[2]);
        } else if (contentArr.length == 4) {
            beanFour.setForm_id(formId);
            beanFour.setKeyword1(contentArr[0]);
            beanFour.setKeyword2(contentArr[1]);
            beanFour.setKeyword3(contentArr[2]);
            beanFour.setKeyword4(contentArr[3]);
        } else if (contentArr.length == 5) {
            beanFive.setForm_id(formId);
            beanFive.setKeyword1(contentArr[0]);
            beanFive.setKeyword2(contentArr[1]);
            beanFive.setKeyword3(contentArr[2]);
            beanFive.setKeyword4(contentArr[3]);
            beanFive.setKeyword5(contentArr[4]);
        }
        TemplateBean td = new TemplateBean();
        if ("consult".equals(templateMsgType)) {
            // 咨询模板
            logger.info("模板id为： {}", consult_notice_tempid);
            beanFive.setTemplate_id(consult_notice_tempid);
            td = WeixinTemplateNotice.sendCommonFiveNotice(beanFive);
        }
        String access_token = weChatSystemContext.getAccessToken(tokenType);
        String json = send(access_token, td);
        logger.info("根据token:{}发送模板消息:{}，结果是{}", access_token, td, json);
        JSONObject jo = JSONObject.parseObject(json);
        if (jo.containsKey("errcode") && "0".equals(jo.getString("errcode"))) {
            //2、然后翻转formID的状态
            formIdInfoDAO.updateFormInfo(openid, formId);
            logger.info("向{}发送了模板消息返回：{}", openid, bean);
            returnMap.put("code", 200);
            returnMap.put("msg", "消息推送成功");
        } else {
            returnMap.put("code", 9999);
            returnMap.put("msg", json);
        }

        return returnMap;
    }

    public String send(String access_token, TemplateBean templateBean) {
        String json = wxSao.send(access_token, templateBean);
        return json;
    }

    /**
     * 获取带参数二维码
     *
     * @param scene
     * @param page
     * @return
     */
    public String getwxacode(@Param("scene") String scene, @Param("page") String page) {
        logger.info("scene: " + scene);
        String access_token = weChatSystemContext.getAccessToken("B");
        logger.info("access_token: {}", access_token);
        WxCodeBean wxCodeBean = new WxCodeBean();
        wxCodeBean.setScene(scene);
        wxCodeBean.setAuto_color(true);
        wxCodeBean.setPage(page);
        wxCodeBean.setWidth(430);
        String jsonStr = JSONObject.toJSONString(wxCodeBean);
        logger.info(jsonStr);
        byte[] json = wxSao.getwxacode(access_token, wxCodeBean);
        // logger.info(json);
        InputStream inputStream = new ByteArrayInputStream(json);
        String uploadDirName = imgLocalPath.substring(imgLocalPath.lastIndexOf("/"), imgLocalPath.length());
        String random = RandomStringUtils.randomAlphanumeric(16);
        String fileName = random + ".jpg";
        logger.info(imgLocalPath + "/", fileName);
        FileUtil.saveToImgByInputStream(inputStream, imgLocalPath + "/", fileName);

        return imgHost + uploadDirName + "/" + fileName;
    }


}
