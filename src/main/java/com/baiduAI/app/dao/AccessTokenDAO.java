package com.baiduAI.app.dao;

import com.baiduAI.app.dto.AccessToken;
import org.apache.ibatis.annotations.*;

/**
 * Created by luoyifei on 2018/2/19.
 */
@Mapper
public interface AccessTokenDAO {

    @Insert("INSERT INTO access_token(access_token, token_type, created_date, created_by, updated_date, updated_by) VALUES(#{accessToken}, #{token_type}, NOW(), 'system', NOW(), 'system')")
    void saveAccessToken(@Param("accessToken") String accessToken, @Param("token_type") String token_type);

    @Update("UPDATE access_token SET access_token=#{accessToken}, updated_date=NOW() WHERE token_type = #{token_type}")
    void updateAccessToken(@Param("accessToken") String accessToken, @Param("token_type") String token_type);


    @Select("SELECT * FROM access_token WHERE token_type = #{token_type} LIMIT 1")
    AccessToken getAccessTokenFromDb(@Param("token_type") String token_type);
}
