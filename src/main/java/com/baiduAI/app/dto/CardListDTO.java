package com.baiduAI.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by luoyifei on 2018/2/20.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "card_list")
public class CardListDTO extends BaseDTO {

    @NonNull
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "follow_date")
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date follow_date;

    @NonNull
    @Column(name = "openid")
    private String openid;

    @NonNull
    @Column(name = "sales_id")
    private Long sales_id;

    @NonNull
    @Column(name = "way")
    private int way;

    @NonNull
    @Column(name = "relay_name")
    private String relay_name;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFollow_date() {
        return follow_date;
    }

    public void setFollow_date(Date follow_date) {
        this.follow_date = follow_date;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Long getSales_id() {
        return sales_id;
    }

    public void setSales_id(Long sales_id) {
        this.sales_id = sales_id;
    }

    public int getWay() {
        return way;
    }

    public void setWay(int way) {
        this.way = way;
    }

    public String getRelay_name() {
        return relay_name;
    }

    public void setRelay_name(String relay_name) {
        this.relay_name = relay_name;
    }
}
