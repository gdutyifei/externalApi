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
@Table(name = "product_info")
public class ProductInfoDTO extends BaseDTO {

    @NonNull
    @Column(name = "id")
    private Long id;

    /**
     * B端小程序openid
     */
    @NonNull
    @Column(name = "openid")
    private String openid;

    @NonNull
    @Column(name = "supp_id")
    private Integer supp_id;

    @NonNull
    @Column(name = "product_name")
    private String product_name;

    @NonNull
    @Column(name = "product_price")
    private String product_price;

    @NonNull
    @Column(name = "product_detail")
    private String product_detail;

    @NonNull
    @Column(name = "cover_url")
    private String cover_url;

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

    public Integer getSupp_id() {
        return supp_id;
    }

    public void setSupp_id(Integer supp_id) {
        this.supp_id = supp_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_detail() {
        return product_detail;
    }

    public void setProduct_detail(String product_detail) {
        this.product_detail = product_detail;
    }

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }
}
