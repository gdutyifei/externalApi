package com.baiduAI.app.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by luoyifei on 2018/2/10.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "wechat_user_to_c")
public class WechatDTO extends BaseDTO {

    @NonNull
    @Column(name = "id")
    private Long id;

    /**
     * 用户openid
     */
    @NonNull
    @Column(name = "openid")
    private String openid;

    /**
     * 用户昵称
     */
    @NonNull
    @Column(name = "nickName")
    private String nickName;

    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     */
    @NonNull
    @Column(name = "avatarUrl")
    private String avatarUrl;

    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    @NonNull
    @Column(name = "gender")
    private String gender;

    /**
     * 用户所在城市
     */
    @NonNull
    @Column(name = "city")
    private String city;

    /**
     * 用户所在省份
     */
    @NonNull
    @Column(name = "province")
    private String province;

    /**
     * 用户所在国家
     */
    @NonNull
    @Column(name = "country")
    private String country;

    @NonNull
    @Column(name = "id")
    private String unionId;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}
