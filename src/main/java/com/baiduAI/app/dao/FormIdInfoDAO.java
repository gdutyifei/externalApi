package com.baiduAI.app.dao;

import com.baiduAI.app.dto.FormIdDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by luoyifei on 2018/2/19.
 */

@Mapper
public interface FormIdInfoDAO {

    //  extends JpaSpecificationExecutor<FormIdDTO>

    @Insert("INSERT INTO form_id_info(openid, form_id, created_date, created_by, updated_date, updated_by) VALUES(#{openid}, #{formId}, NOW(), 'system', NOW(), 'system')")
    void saveFormInfo(@Param("openid") String openid, @Param("formId") String formId);

    @Update("UPDATE form_id_info SET isused='Y' WHERE openid=#{openid} AND form_id=#{formId}")
    void updateFormInfo(@Param("openid") String openid, @Param("formId") String formId);

    @Select("SELECT * FROM form_id_info WHERE openid = #{openid} AND isused = #{isused} ORDER BY created_date DESC LIMIT 1")
    FormIdDTO findByOpenidAndIsusedOrderByCreatedDateDesc(@Param("openid") String openid, @Param("isused") String isused);

}
