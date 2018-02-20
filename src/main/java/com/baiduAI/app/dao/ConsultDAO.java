package com.baiduAI.app.dao;

import com.baiduAI.app.dto.FormIdDTO;
import org.apache.ibatis.annotations.*;

/**
 * Created by luoyifei on 2018/2/19.
 */

@Mapper
public interface ConsultDAO {

    @Insert("INSERT INTO consult_info(openid, openid_sales, product_id, content, created_date, created_by, updated_date, updated_by) VALUES(#{openid}, #{openid_sales}, #{product_id}, #{content}, NOW(), 'system', NOW(), 'system')")
    void saveConsultInfo(@Param("openid") String openid, @Param("openid_sales") String openid_sales, @Param("product_id") Long product_id, @Param("content") String content);
}
