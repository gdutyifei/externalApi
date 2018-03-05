package com.baiduAI.app.service;

import com.baiduAI.app.dao.RankCallDetailDAO;
import com.baiduAI.app.dao.RankClickPraiseDetailDAO;
import com.baiduAI.app.dao.WechatInfoDAO;
import com.baiduAI.app.dto.WechatDTO;
import com.baiduAI.app.util.RedisKey;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by luoyifei on 2018/2/28.
 */
@Slf4j
@Service
public class RankClickPraiseDetailService {

    public static final Logger logger = LoggerFactory.getLogger(RankClickPraiseDetailService.class);

    @Autowired
    private RankClickPraiseDetailDAO rankClickPraiseDetailDAO;

    @Autowired
    private WechatInfoDAO wechatInfoDAO;

    @Autowired
    private RedisService redisService;

    /**
     * 保存用户点赞记录
     * @param openid
     * @param sales_id
     */
    public void saveRankClickPraiseDetail(@Param("openid") String openid,  @Param("sales_id") Long sales_id) throws Exception {
        // 点赞量
        redisService.saveLongToRedis(RedisKey.RANDPRAISESTRING + sales_id);
        WechatDTO wechatDTO = wechatInfoDAO.getWechatInfoByOpenid(openid);
        if (wechatDTO == null) {
            throw new Exception("获取不到C端用户微信信息");
        }
        Long cuser_id = wechatDTO.getId();
        rankClickPraiseDetailDAO.saveRankClickPraiseDetail(openid, cuser_id, sales_id);
    }
}
