package com.baiduAI.app.sao;

/**
 * Created by luoyifei on 2018/2/10.
 */

import com.alibaba.fastjson.JSONObject;
import com.baiduAI.app.bean.BaiduAIBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by luoyifei on 2018/2/10.
 */
@FeignClient(value = "baiduAI", url="${baidu.api.url}")
public interface BaiduAISao {

    /**
     * 获取Access Token
     * @param grant_type
     * @param client_id
     * @param client_secret
     * @return
     */
    @RequestMapping(value="/oauth/2.0/token", method = RequestMethod.POST,  consumes="application/x-www-form-urlencoded")
    String getAccessToken(@RequestParam("grant_type") String grant_type, @RequestParam("client_id") String client_id, @RequestParam("client_secret") String client_secret);

    /**
     * 人脸检测接口
     * @param access_token
     * @param image
     * @return
     */
    @RequestMapping(value="/rest/2.0/face/v2/detect", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded")
    String detectFace(@RequestParam("access_token") String access_token, @RequestParam("image") String image);

    /**
     * 人脸库注册
     * @param access_token
     * @param uid
     * @param group_id
     * @param image
     * @param user_info
     * @param action_type
     * @return
     */
    @RequestMapping(value="/rest/2.0/face/v2/faceset/user/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded")
    String facesetAdd(@RequestParam("access_token") String access_token, @RequestParam("uid") String uid, @RequestParam("group_id") String group_id, @RequestParam("image") String image, @RequestParam("user_info") String user_info, @RequestParam("action_type") String action_type);

    /**
     * 人脸库更新
     * @param param
     * @return
     */
    @RequestMapping(value="/rest/2.0/face/v2/faceset/user/update", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded")
    String facesetUpdate(@RequestBody BaiduAIBean param);

    /**
     * 人脸查找
     * @param param
     * @return
     */
    @RequestMapping(value="/rest/2.0/face/v2/identify", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded")
    String facesetIdentify(@RequestBody BaiduAIBean param);
}
