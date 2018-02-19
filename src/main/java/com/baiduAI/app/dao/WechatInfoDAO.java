package com.baiduAI.app.dao;

import com.baiduAI.app.dto.FormIdDTO;
import com.baiduAI.app.dto.WechatDTO;
import org.apache.ibatis.annotations.*;

/**
 * Created by luoyifei on 2018/2/19.
 */

@Mapper
public interface WechatInfoDAO {

    @Insert("INSERT INTO wechat_user_to_c(openid, nickName, avatarUrl, gender, city, province, country, unionId, created_date, created_by, updated_date, updated_by) VALUES(#{openid}, #{nickName}, #{avatarUrl}, #{gender}, #{city}, #{province}, #{country}, #{unionId}, NOW(), 'system', NOW(), 'system')")
    void saveWechatInfo(@Param("openid") String openid, @Param("nickName") String nickName, @Param("avatarUrl") String avatarUrl, @Param("gender") String gender, @Param("city") String city, @Param("province") String province, @Param("country") String country, @Param("unionId") String unionId);

    @Select("SELECT * FROM wechat_user_to_c WHERE openid=#{openid}")
    WechatDTO getWechatInfoByOpenid(@Param("openid") String openid);

}
