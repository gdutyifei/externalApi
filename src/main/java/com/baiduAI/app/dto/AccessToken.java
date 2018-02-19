package com.baiduAI.app.dto;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by luoyifei on 2018/2/19.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "access_token")
public class AccessToken extends BaseDTO {

    @NonNull
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "access_token")
    private String accessToken;

    @NonNull
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @NonNull
    @Column(name = "created_by")
    private String createdBy;

    @NonNull
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @NonNull
    @Column(name = "updated_by")
    private String updatedBy;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }


// private int expires_in;
}
