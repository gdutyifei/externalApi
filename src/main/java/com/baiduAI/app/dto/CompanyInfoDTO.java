package com.baiduAI.app.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by luoyifei on 2018/3/1.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "company_info")
public class CompanyInfoDTO {

    @NonNull
    @Column(name = "id")
    private Long id;

    /**
     * 门店主页图
     */
    @NonNull
    @Column(name = "main_pic")
    private String main_pic;

    /**
     * 门店视频地址
     */
    @NonNull
    @Column(name = "video")
    private String video;

    /**
     * 联系电话
     */
    @NonNull
    @Column(name = "tel")
    private String tel;

    /**
     * 关联的b端的用户id
     */
    @NonNull
    @Column(name = "sales_id")
    private Long sales_id;

    /**
     * 关联的b端的openid
     */
    @NonNull
    @Column(name = "sales_openid")
    private String sales_openid;

    private String province;

    private String city;

    private String area;

    private String lng;

    private String lat;

    private Date add_time;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMain_pic() {
        return main_pic;
    }

    public void setMain_pic(String main_pic) {
        this.main_pic = main_pic;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Long getSales_id() {
        return sales_id;
    }

    public void setSales_id(Long sales_id) {
        this.sales_id = sales_id;
    }

    public String getSales_openid() {
        return sales_openid;
    }

    public void setSales_openid(String sales_openid) {
        this.sales_openid = sales_openid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }
}
