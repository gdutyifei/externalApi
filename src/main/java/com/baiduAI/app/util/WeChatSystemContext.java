package com.baiduAI.app.util;

import com.alibaba.fastjson.JSONObject;
import com.baiduAI.app.dao.AccessTokenDAO;
import com.baiduAI.app.dto.AccessToken;
import com.baiduAI.app.sao.WxSao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Date;

/**
 * Created by luoyifei on 2018/2/19.
 * <p>
 * 存储access_token的单例类
 */
@Service
public class WeChatSystemContext {

    public static final Logger logger = LoggerFactory.getLogger(WeChatSystemContext.class);

    @Autowired
    private AccessTokenDAO accessTokenDAO;

    @Autowired
    private WxSao wxSao;

    @Value("${wx.appid.c}")
    private String appid;

    @Value("${wx.appsecret.c}")
    private String appSecret;

    private String accessToken; // 接口访问凭据

    private long createTime; // 接口访问凭据创建时间，理论上是2小时后过期


    static class WeChatSystemContextHolder {

        static WeChatSystemContext instance = new WeChatSystemContext();

    }


    public static WeChatSystemContext getInstance() {

        return WeChatSystemContextHolder.instance;

    }


    //是否过期
    public boolean isExpired(String tokenType) {
        AccessToken accessTokenInfo = accessTokenDAO.getAccessTokenFromDb(tokenType);
        // 说明表中无记录
        if (accessTokenInfo == null) {
            String getAccessTokenFromWxJsonStr = wxSao.getAccessToken(appid, appSecret, "client_credential");
            logger.info("poster微信返回数据：{}", getAccessTokenFromWxJsonStr);
            JSONObject jo = JSONObject.parseObject(getAccessTokenFromWxJsonStr);
            accessToken = jo.get("access_token").toString();
            accessTokenDAO.saveAccessToken(accessToken, tokenType);
        } else {
            long updatedTime = Date.from(accessTokenInfo.getUpdated_date().atZone(ZoneId.systemDefault()).toInstant()).getTime();
            long time = new Date().getTime();

            //如果当前记录时间为0
            if (updatedTime <= 0) {
                return true;
            }

            //判断记录时间是否超过7200s

            if (updatedTime / 1000 + 7200 < time / 1000) {
                return true;
            }

            accessToken = accessTokenInfo.getAccess_token();
        }

        return false;
    }


    //记录接口访问凭证

    public void saveLocalAccessonToke(String accessToken) {

        this.accessToken = accessToken;

        this.createTime = new Date().getTime();

    }


    public void setAccessToken(String accessToken) {

        this.accessToken = accessToken;

    }

    public String getAccessToken(String tokenType) {
        if (isExpired(tokenType)) {
            // 如果过期
            String getAccessTokenFromWxJsonStr = wxSao.getAccessToken(appid, appSecret, "client_credential");
            logger.info("poster微信返回数据：{}", getAccessTokenFromWxJsonStr);
            JSONObject jo = JSONObject.parseObject(getAccessTokenFromWxJsonStr);
            accessToken = jo.get("access_token").toString();
            accessTokenDAO.updateAccessToken(accessToken, tokenType);
        }

        return accessToken;

    }

    public void setCreateTime(long createTime) {

        this.createTime = createTime;

    }

    public long getCreateTime() {

        return createTime;

    }
}
