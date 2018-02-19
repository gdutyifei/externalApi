package com.baiduAI.app.dao;

import com.baiduAI.app.dto.AccessToken;
import org.apache.ibatis.annotations.*;

/**
 * Created by luoyifei on 2018/2/19.
 */
@Mapper
public interface AccessTokenDAO {

    @Insert("INSERT INTO access_token(access_token, created_date, created_by, updated_date, updated_by) VALUES(#{accessToken}, NOW(), 'system', NOW(), 'system')")
    void saveAccessToken(@Param("accessToken") String accessToken);

    @Update("UPDATE access_token SET access_token=#{accessToken}, updated_date=NOW() WHERE id = 1")
    void updateAccessToken(@Param("accessToken") String accessToken);


    @Select("SELECT * FROM access_token LIMIT 1")
    AccessToken getAccessTokenFromDb();
}
