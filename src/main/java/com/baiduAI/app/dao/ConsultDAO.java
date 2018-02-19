package com.baiduAI.app.dao;

import com.baiduAI.app.dto.FormIdDTO;
import org.apache.ibatis.annotations.*;

/**
 * Created by luoyifei on 2018/2/19.
 */

@Mapper
public interface ConsultDAO {

    @Insert("INSERT INTO form_id_info(openid, form_id, created_date, created_by, updated_date, updated_by) VALUES(#{openid}, #{formId}, NOW(), 'system', NOW(), 'system')")
    void saveConsultInfo(@Param("openid") String openid, @Param("formId") String formId);

}
