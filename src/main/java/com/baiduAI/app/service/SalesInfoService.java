package com.baiduAI.app.service;

import com.alibaba.fastjson.JSONObject;
import com.baiduAI.app.dao.RankCallDetailDAO;
import com.baiduAI.app.dao.RankReadDetailDAO;
import com.baiduAI.app.dao.SalesInfoDAO;
import com.baiduAI.app.dao.WechatInfoDAO;
import com.baiduAI.app.dto.SalesInfoDTO;
import com.baiduAI.app.dto.WechatDTO;
import com.baiduAI.app.util.RedisKey;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
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

    @Autowired
    private WechatInfoDAO wechatInfoDAO;

    @Autowired
    private RankReadDetailService rankReadDetailService;

    @Autowired
    private RankCallDetailDAO rankCallDetailDAO;

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
        // 阅读量
        redisService.saveLongToRedis(RedisKey.RANDREADSTRING + salesId);
        // 保存阅读详细信息到表中
        WechatDTO wechatDTO = wechatInfoDAO.getWechatInfoByOpenid(openid);
        if (wechatDTO != null) {
            Long cuserId = wechatDTO.getId();
            rankReadDetailService.saveRankReadDetail(openid, cuserId, salesId);
        } else {
            returnMap.put("code", 9998);
            returnMap.put("msg", "获取C端用户微信信息出错");
            return returnMap;
        }
        // 阅读数
        int readCount = redisService.getFromRedis(RedisKey.RANDREADSTRING + salesId);

        // 转发数
        int relayCount = redisService.getFromRedis(RedisKey.RANDTRANSPONDSTRING + salesId);

        // 点赞数
        int thumbCount = redisService.getFromRedis(RedisKey.RANDPRAISESTRING + salesId);

        JSONObject jo = (JSONObject) JSONObject.toJSON(salesInfoDTO);
        jo.put("read", readCount);
        jo.put("relay", relayCount);
        jo.put("thumb", thumbCount);

        returnMap.put("data", jo);
        returnMap.put("code", 200);
        returnMap.put("msg", "获取该店员信息成功");
        return returnMap;
    }

    /**
     * 保存拨打电话记录
     * @param openid
     * @param sales_id
     */
    public void saveRankCallDetail(@Param("openid") String openid, @Param("sales_id") Long sales_id, @Param("phone") String phone) throws Exception {
        WechatDTO wechatDTO = wechatInfoDAO.getWechatInfoByOpenid(openid);
        if (wechatDTO == null) {
            throw new Exception("获取不到微信用户信息");
        }
        Long cuser_id = wechatDTO.getId();
        rankCallDetailDAO.saveRankCallDetail(openid, cuser_id, sales_id, phone);
    }

}
