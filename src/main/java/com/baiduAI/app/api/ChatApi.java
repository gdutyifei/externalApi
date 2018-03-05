package com.baiduAI.app.api;

import com.baiduAI.app.service.ChatService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by luoyifei on 2018/2/25.
 */
@RestController
@RequestMapping(value = "/api/chat/", method = {RequestMethod.GET, RequestMethod.POST})
public class ChatApi {

    @Autowired
    private ChatService chatService;

    @RequestMapping("/saveChatInfo")
    public Map<String, Object> saveChatInfo(@Param("from") String from, @Param("to") String to, @Param("data") String data, @Param("mid") String mid) {
        return chatService.saveChatInfo(from, to, data, mid);
    }

    @RequestMapping("/getChatListByOpenid")
    public Map<String, Object> getChatListByOpenid(@Param("from") String from, @Param("to") String to, @Param("page") Integer page, @Param("type") String type, @Param("salesId") Long salesId) {
        return chatService.getChatListByOpenid(from, to, page, type, salesId);
    }
}
