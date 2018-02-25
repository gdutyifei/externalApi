package com.baiduAI.app.dao;

import com.baiduAI.app.dto.ChatDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by luoyifei on 2018/2/25.
 */
@Mapper
public interface ChatDAO {

    @Insert("INSERT INTO chat_log(`from`, `to`, `data`, `time`, `mid`, `created_date`, `created_by`, `updated_date`, `updated_by`) VALUES(#{from}, #{to}, #{data}, NOW(), #{mid}, NOW(), 'system', NOW(), 'system')")
    void saveChatInfo(@Param("from") String from, @Param("to") String to, @Param("data") String data, @Param("mid") String mid);

    @Select("SELECT * FROM chat_log WHERE (`from` = LOWER(#{from}) AND `to` = LOWER(#{to}))  OR (`to` = LOWER(#{from}) AND `from` = LOWER(#{to})) ORDER BY `time` DESC")
    List<ChatDTO> getChatListByOpenid(@Param("from") String from, @Param("to") String to);
}
