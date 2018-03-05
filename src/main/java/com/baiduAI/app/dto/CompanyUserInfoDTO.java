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
@Table(name = "company_user_info")
public class CompanyUserInfoDTO {

    @NonNull
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "sales_id")
    private Long sales_id;

    @NonNull
    @Column(name = "sales_openid")
    private String sales_openid;

    /**
     * 关联的company表的id
     */
    @NonNull
    @Column(name = "c_id")
    private Long c_id;

    /**
     * 店员头像地址
     */
    @NonNull
    @Column(name = "pic")
    private String pic;

    /**
     * 店员姓名
     */
    @NonNull
    @Column(name = "u_name")
    private String u_name;

    /**
     * 店员职位
     */
    @NonNull
    @Column(name = "u_post")
    private String u_post;

    @NonNull
    @Column(name = "add_time")
    private Date add_time;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getC_id() {
        return c_id;
    }

    public void setC_id(Long c_id) {
        this.c_id = c_id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_post() {
        return u_post;
    }

    public void setU_post(String u_post) {
        this.u_post = u_post;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }
}
