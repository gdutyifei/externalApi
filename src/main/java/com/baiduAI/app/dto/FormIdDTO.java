package com.baiduAI.app.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by luoyifei on 2018/2/19.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name = "form_id_manage")
public class FormIdDTO extends BaseDTO {

    @Column(name = "id")
    private Long id;

    @Column(name = "form_id")
    private String form_id;

    @Column(name = "openid")
    private String openid;

    @Column(name = "isused")
    private String isused;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getIsused() {
        return isused;
    }

    public void setIsused(String isused) {
        this.isused = isused;
    }
}
