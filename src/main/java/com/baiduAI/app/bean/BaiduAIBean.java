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

}
