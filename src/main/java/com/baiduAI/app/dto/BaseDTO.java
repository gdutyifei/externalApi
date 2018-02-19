package com.baiduAI.app.dto;

import lombok.NonNull;

import javax.persistence.Column;
import java.time.LocalDateTime;

/**
 * Created by luoyifei on 2018/2/19.
 */
public class BaseDTO {

    @NonNull
    @Column(name = "id")
    private Long id;

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
}
