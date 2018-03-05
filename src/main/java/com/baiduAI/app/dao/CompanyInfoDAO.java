package com.baiduAI.app.dao;

import com.baiduAI.app.dto.CompanyInfoDTO;
import com.baiduAI.app.dto.FormIdDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by luoyifei on 2018/3/2.
 */
@Mapper
public interface CompanyInfoDAO {

    @Select("SELECT * FROM company_info WHERE sales_id=#{sales_id}")
    CompanyInfoDTO findCompanyInfoBySalesId(@Param("sales_id") Long sales_id);

}
