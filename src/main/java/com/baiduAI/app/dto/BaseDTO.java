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
}
