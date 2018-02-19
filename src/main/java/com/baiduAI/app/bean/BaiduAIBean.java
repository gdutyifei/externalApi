package com.baiduAI.app.bean;

import lombok.Data;

/**
 * Created by luoyifei on 2018/2/9.
 */
@Data
public class BaiduAIBean {

    /**
     * 固定为client_credentials
     */
    private String grant_type;

    /**
     * 应用的API Key
     */
    private String client_id;

    /**
     * 应用的Secret Key
     */
    private String client_secret;

    /**
     * 通过API Key和Secret Key获取的access_token
     */
    private String access_token;

    /**
     * base64编码后的图片数据，需urlencode，编码后的图片大小不超过2M
     */
    private String image;

    /**
     * 最多处理人脸的数目，默认值为1，仅检测图片中面积最大的那个人脸
     */
    private Integer max_face_num;

    /**
     * 包括age,beauty,expression,faceshape,gender,glasses,landmark,race,qualities信息，逗号分隔，默认只返回人脸框、概率和旋转角度
     */
    private String face_fields;

    /**
     * 用户id（由数字、字母、下划线组成），长度限制128B。
     */
    private String uid;

    /**
     * 用户组id，标识一组用户（由数字、字母、下划线组成），长度限制128B。
     */
    private String group_id;

    /**
     * 用户资料，长度限制256B
     */
    private String user_info;

    /**
     * 参数包含append、replace。如果为“replace”，则每次注册时进行替换replace（新增或更新）操作，默认为append操作。
     */
    private String action_type;

    /**
     * 特殊返回信息，多个用逗号分隔，取值固定: 目前支持faceliveness(活体检测)。注：需要用于判断活体的图片，图片中的人脸像素面积需要不小于100px*100px，人脸长宽与图片长宽比例，不小于1/3
     */
    private String ext_fields;

    /**
     * 识别后返回的用户top数，默认为1，最多返回5个
     */
    private Integer user_top_num;

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getMax_face_num() {
        return max_face_num;
    }

    public void setMax_face_num(Integer max_face_num) {
        this.max_face_num = max_face_num;
    }

    public String getFace_fields() {
        return face_fields;
    }

    public void setFace_fields(String face_fields) {
        this.face_fields = face_fields;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getUser_info() {
        return user_info;
    }

    public void setUser_info(String user_info) {
        this.user_info = user_info;
    }

    public String getAction_type() {
        return action_type;
    }

    public void setAction_type(String action_type) {
        this.action_type = action_type;
    }

    public String getExt_fields() {
        return ext_fields;
    }

    public void setExt_fields(String ext_fields) {
        this.ext_fields = ext_fields;
    }

    public Integer getUser_top_num() {
        return user_top_num;
    }

    public void setUser_top_num(Integer user_top_num) {
        this.user_top_num = user_top_num;
    }
}
