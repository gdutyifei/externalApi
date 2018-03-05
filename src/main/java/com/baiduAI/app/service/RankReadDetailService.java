package com.baiduAI.app.service;

import com.baiduAI.app.dao.RankReadDetailDAO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by luoyifei on 2018/2/28.
 */
@Slf4j
@Service
public class RankReadDetailService {

    @Autowired
    private RankReadDetailDAO rankReadDetailDAO;

    /**
     * 保存浏览客户详细记录
     * @param openid
     * @param cuser_id
     * @param sales_id
     */
    public void saveRankReadDetail(@Param("openid") String openid, @Param("cuser_id") Long cuser_id, @Param("sales_id") Long sales_id) {
        rankReadDetailDAO.saveRankReadDetail(openid, cuser_id, sales_id);
    }
}
