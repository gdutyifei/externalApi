package com.baiduAI.app.dao;

import com.baiduAI.app.dto.ProductInfoDTO;
import com.baiduAI.app.dto.SalesInfoDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by luoyifei on 2018/2/20.
 */
@Mapper
public interface ProductInfoDAO {

    @Insert("INSERT INTO product_info(openid, product_name, product_price, product_detail, cover_url, created_date, created_by, updated_date, updated_by) VALUES(#{openid}, #{product_name}, #{product_price}, #{product_detail}, #{cover_url}, NOW(), 'system', NOW(), 'system')")
    void saveProductInfo(@Param("openid") String openid, @Param("product_name") String product_name, @Param("product_price") String product_price, @Param("product_detail") String product_detail, @Param("cover_url") String cover_url);

    @Select("SELECT * FROM product_info WHERE openid=#{openid} ORDER BY created_date DESC")
    List<ProductInfoDTO> getProductListByOpenid(@Param("openid") String openid);

    @Select("SELECT * FROM product_info WHERE id=#{id}")
    ProductInfoDTO getProductInfoById(@Param("id") Long id);
}
