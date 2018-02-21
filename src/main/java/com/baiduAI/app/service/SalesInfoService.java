package com.baiduAI.app.service;

import com.alibaba.fastjson.JSONObject;
import com.baiduAI.app.dao.SalesInfoDAO;
import com.baiduAI.app.dto.SalesInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by luoyifei on 2018/2/20.
 */
@Slf4j
@Service
public class SalesInfoService {

    public static final Logger logger = LoggerFactory.getLogger(SalesInfoService.class);

    @Autowired
    private SalesInfoDAO salesInfoDAO;

    @Autowired
    private RedisService redisService;

    /**
     * 根据店员id获取店员信息
     * @param salesId
     * @return
     */
    public Map<String, Object> getSalesInfoBySalesId(@RequestParam("salesId") Long salesId, @RequestParam("openid") String openid) throws Exception {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        SalesInfoDTO salesInfoDTO = salesInfoDAO.getSalesInfoBySalesId(salesId);
        if (salesInfoDTO == null) {
            returnMap.put("code", 9999);
            returnMap.put("msg", "找不到该店员信息");
            return returnMap;
        }
        // 阅读数
        Set<String> readSet = (Set<String>) redisService.getFromRedis(salesId + "_read");
        int readCount = 0;
        if (readSet != null) {
            readCount = readSet.size();
        }

        // 转发数
        int relayCount = 0;
        Set<String> relaySet = (Set<String>) redisService.getFromRedis(salesId + "_relay");
        if (relaySet != null) {
            relayCount = readSet.size();
        }
        // 点赞数
        int thumbCount = 0;
        String thumbed = "N";
        Set<String> thumbSet = (Set<String>) redisService.getFromRedis(salesId + "_thumb");
        if (thumbSet != null) {
            thumbCount = readSet.size();
        }
        if (thumbCount != 0) {
            for (String s : thumbSet) {
                if (StringUtils.equals(s, openid)) {
                    // 如果已经点赞过，显示不可点击
                    thumbed  = "Y";
                }
            }
        }
        JSONObject jo = (JSONObject) JSONObject.toJSON(salesInfoDTO);
        jo.put("read", readCount);
        jo.put("relay", relayCount);
        jo.put("thumb", thumbCount);
        jo.put("thumbed", thumbed);

        returnMap.put("code", 200);
        returnMap.put("data", jo);
        returnMap.put("msg", "获取该店员信息成功");
        return returnMap;
    }
}
