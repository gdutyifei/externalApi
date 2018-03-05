package com.baiduAI.app.dao;

import com.baiduAI.app.dto.CardListDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by luoyifei on 2018/2/20.
 */
@Mapper
public interface CardListDAO {

    @Insert("INSERT INTO card_list(follow_date, openid, sales_id, way, relay_name, created_date, created_by, updated_date, updated_by) VALUES(NOW(), #{openid}, #{sales_id}, #{way}, #{relay_name}, NOW(), 'system', NOW(), 'system')")
    void saveCardToList(@Param("openid") String openid, @Param("sales_id") Long sales_id, @Param("way") int way, @Param("relay_name") String relay_name);

    @Select("SELECT * FROM card_list WHERE openid=#{openid} AND sales_id=#{sales_id}")
    CardListDTO getCardByOpenidAndSalesId(@Param("openid") String openid, @Param("sales_id") Long sales_id);

    @Select("SELECT * FROM card_list WHERE openid=#{openid} ORDER BY follow_date DESC")
    List<CardListDTO> getCardListByOpenid(@Param("openid") String openid);
}
