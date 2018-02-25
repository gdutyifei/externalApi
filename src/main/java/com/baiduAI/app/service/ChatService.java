package com.baiduAI.app.service;

import com.baiduAI.app.dao.ChatDAO;
import com.baiduAI.app.dto.ChatDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by luoyifei on 2018/2/25.
 */
@Slf4j
@Service
public class ChatService {

    public static final Logger logger = LoggerFactory.getLogger(ChatService.class);

    @Autowired
    private ChatDAO chatDAO;

    /**
     * 保存聊天记录
     * @param from
     * @param to
     * @param data
     * @param mid
     * @return
     */
    public Map<String, Object> saveChatInfo(@Param("from") String from, @Param("to") String to, @Param("data") String data, @Param("mid") String mid) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        chatDAO.saveChatInfo(from, to, data, mid);
        returnMap.put("code", 200);
        returnMap.put("msg", "保存成功");
        return returnMap;
    }

    /**
     * 获取聊天记录
     * @param from
     * @param to
     * @return
     */
    public Map<String, Object> getChatListByOpenid(@Param("from") String from, @Param("to") String to) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        List<ChatDTO> chatList = chatDAO.getChatListByOpenid(from, to);
        returnMap.put("code", 200);
        returnMap.put("msg", "获取聊天记录成功");
        returnMap.put("data", chatList);
        return returnMap;
    }
}
