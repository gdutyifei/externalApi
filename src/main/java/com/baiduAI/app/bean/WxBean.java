package com.baiduAI.app.bean;

import lombok.Data;

/**
 * Created by luoyifei on 2018/2/10.
 */
@Data
public class WxBean {

    /**
     * 用户openid
     */
    private String openid;

    /**
     * code
     */
    private String code;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
