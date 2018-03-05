package com.baiduAI.app.service;

import com.baiduAI.app.dao.RankSaveCardDetailDAO;
import com.baiduAI.app.dao.RankTranspondDetailDAO;
import com.baiduAI.app.dao.WechatInfoDAO;
import com.baiduAI.app.dto.WechatDTO;
import com.baiduAI.app.util.RedisKey;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by luoyifei on 2018/2/28.
 */
@Slf4j
@Service
public class RankSaveCardDetailService {

    @Autowired
    private RankSaveCardDetailDAO rankSaveCardDetailDAO;

    @Autowired
    private RedisService redisService;

    @Autowired
    private WechatInfoDAO wechatInfoDAO;

    /**
     * 保存名片保存详细记录
     * @param openid
     * @param sales_id
     */
    public void saveRankSaveCardDetail(@Param("openid") String openid, @Param("sales_id") Long sales_id) throws Exception {
        // 转发量+1
        redisService.saveLongToRedis(RedisKey.RANDSAVECARDSTRING + sales_id);

        WechatDTO wechatDTO = wechatInfoDAO.getWechatInfoByOpenid(openid);
        if (wechatDTO == null) {
            throw new Exception("获取不到C端用户微信信息");
        }
        Long cuser_id = wechatDTO.getId();
        rankSaveCardDetailDAO.saveRankSaveCardDetail(openid, cuser_id, sales_id);
    }
}
