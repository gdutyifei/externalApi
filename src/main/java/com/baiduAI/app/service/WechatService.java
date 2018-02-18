package com.baiduAI.app.service;

import com.alibaba.fastjson.JSONObject;
import com.baiduAI.app.api.EasemobApi;
import com.baiduAI.app.sao.WxSao;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by luoyifei on 2018/2/10.
 */
@Slf4j
@Service
public class WechatService {

    @Autowired
    private WxSao wxSao;

    @Value("${wx.appid.c}")
    private String appid;

    @Value("${wx.appsecret.c}")
    private String appSecret;

    @Value("${img.local.path}")
    private String imgLocalPath;

    @Value("${img.host}")
    private String imgHost;

    public static final Logger logger = LoggerFactory.getLogger(WechatService.class);

    /**
     * 根据code获取openid
     * @param code
     * @return
     */
    public String getOpenidByCode(@RequestParam("code") String code) {
        try {
            String userStr = wxSao.getJscode2session(appid, appSecret, code, "authorization_code");
            JSONObject userInfo = JSONObject.parseObject(userStr);
            String openid = userInfo.getString("openid");
            // String session_key = userInfo.getString("session_key");
            return openid;
        } catch (Exception e) {
            return e.toString();
        }
    }

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

}
