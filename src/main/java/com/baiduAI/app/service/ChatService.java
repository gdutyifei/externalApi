package com.baiduAI.app.service;

import com.baiduAI.app.dao.ChatDAO;
import com.baiduAI.app.dao.SalesInfoDAO;
import com.baiduAI.app.dto.ChatDTO;
import com.baiduAI.app.dto.SalesInfoDTO;
import com.baiduAI.app.dto.WechatDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
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

    @Autowired
    private WechatService wechatService;

    @Autowired
    private SalesInfoDAO salesInfoDAO;

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
    public Map<String, Object> getChatListByOpenid(@Param("from") String from, @Param("to") String to, @Param("page") Integer page, @Param("type") String type, @Param("salesId") Long salesId) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        logger.info("第" + ((page - 1) * 10 + 1) + "开始");
        List<ChatDTO> chatList = chatDAO.getChatListByOpenid(from, to, (page - 1) * 10);
        logger.info(chatList.toString());
        if (StringUtils.equals("C", type)) {
            WechatDTO wechatDTO = wechatService.getWechatDTOInfoByOpenid(from);
            if (wechatDTO == null) {
                returnMap.put("code", 9998);
                returnMap.put("msg", "找不到C端用户信息");
            } else {
                String cUrl = wechatDTO.getAvatarUrl();
                SalesInfoDTO salesInfoDTO = salesInfoDAO.getSalesInfoBySalesId(salesId);
                if (salesInfoDTO == null) {
                    returnMap.put("code", 9997);
                    returnMap.put("msg", "找不到B端用户信息");
                }
                String bUrl = salesInfoDTO.getCover_url();
                returnMap.put("code", 200);
                returnMap.put("msg", "获取聊天记录成功");
                returnMap.put("data", chatList);
                returnMap.put("cUrl", cUrl);
                returnMap.put("bUrl", bUrl);
            }
            return returnMap;
        } else {
            WechatDTO wechatDTO = wechatService.getWechatDTOInfoByOpenid(to);
            if (wechatDTO == null) {
                returnMap.put("code", 9998);
                returnMap.put("msg", "找不到C端用户信息");
            } else {
                String cUrl = wechatDTO.getAvatarUrl();
                SalesInfoDTO salesInfoDTO = salesInfoDAO.getSalesInfoBySalesId(salesId);
                if (salesInfoDTO == null) {
                    returnMap.put("code", 9997);
                    returnMap.put("msg", "找不到B端用户信息");
                }
                String bUrl = salesInfoDTO.getCover_url();
                returnMap.put("code", 200);
                returnMap.put("msg", "获取聊天记录成功");
                returnMap.put("data", chatList);
                returnMap.put("cUrl", cUrl);
                returnMap.put("bUrl", bUrl);
            }
            return returnMap;
        }

    }
}
