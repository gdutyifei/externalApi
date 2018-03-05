package com.baiduAI.app.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by luoyifei on 2018/2/24.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "chat_log")
public class ChatDTO extends BaseDTO {
    @NonNull
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "from")
    private String from;

    @NonNull
    @Column(name = "to")
    private String to;

    @NonNull
    @Column(name = "data")
    private String data;

    @NonNull
    @Column(name = "time")
    private Date time;

    @NonNull
    @Column(name = "mid")
    private String mid;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}
