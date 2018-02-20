package com.baiduAI.app.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by luoyifei on 2018/2/20.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "sales_info")
public class SalesInfoDTO extends BaseDTO {

    @NonNull
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "supp_id")
    private String supp_id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "job")
    private String job;

    @NonNull
    @Column(name = "store")
    private String store;

    @NonNull
    @Column(name = "tel")
    private String tel;

    @NonNull
    @Column(name = "wechat")
    private String wechat;

    @NonNull
    @Column(name = "location")
    private String location;

    @NonNull
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "cover_url")
    private String cover_url;

    @NonNull
    @Column(name = "photos")
    private String photos;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupp_id() {
        return supp_id;
    }

    public void setSupp_id(String supp_id) {
        this.supp_id = supp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }
}
