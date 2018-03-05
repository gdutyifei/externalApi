package com.baiduAI.app.service;

import com.baiduAI.app.dao.RankCallDetailDAO;
import com.baiduAI.app.dao.RankStroeReadDetailDAO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by luoyifei on 2018/2/28.
 */
@Slf4j
@Service
public class RankStroeReadService {

    @Autowired
    private RankStroeReadDetailDAO rankStroeReadDetailDAO;

    /**
     * 保存门店查看次数详情记录
     * @param openid
     * @param cuser_id
     * @param sales_id
     */
    public void saveRankStroeReadDetail(@Param("openid") String openid, @Param("cuser_id") Long cuser_id, @Param("sales_id") Long sales_id) {
        rankStroeReadDetailDAO.saveRankStroeReadDetail(openid, cuser_id, sales_id);
    }
}
