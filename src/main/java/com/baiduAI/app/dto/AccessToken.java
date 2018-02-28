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
    private String access_token;

    @NonNull
    @Column(name = "token_type")
    private String token_type;

    @NonNull
    @Column(name = "created_date")
    private LocalDateTime created_date;

    @NonNull
    @Column(name = "created_by")
    private String created_by;

    @NonNull
    @Column(name = "updated_date")
    private LocalDateTime updated_date;

    @NonNull
    @Column(name = "updated_by")
    private String updated_by;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public LocalDateTime getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(LocalDateTime updated_date) {
        this.updated_date = updated_date;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }
}
