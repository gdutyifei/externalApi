package com.baiduAI.app.dao;

import com.baiduAI.app.dto.CompanyInfoDTO;
import com.baiduAI.app.dto.CompanyUserInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by luoyifei on 2018/3/2.
 */
@Mapper
public interface CompanyUserInfoDAO {

    @Select("SELECT * FROM company_user_info WHERE sales_id=#{sales_id} ORDER BY add_time DESC")
    List<CompanyUserInfoDTO> findCompanyUserInfoBySalesId(@Param("sales_id") Long sales_id);

}
