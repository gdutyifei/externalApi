package com.baiduAI.app.service;

import com.baiduAI.app.dao.SalesInfoDAO;
import com.baiduAI.app.dto.SalesInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luoyifei on 2018/2/20.
 */
@Slf4j
@Service
public class SalesInfoService {

    public static final Logger logger = LoggerFactory.getLogger(SalesInfoService.class);

    @Autowired
    private SalesInfoDAO salesInfoDAO;

    /**
     * 根据店员id获取店员信息
     * @param salesId
     * @return
     */
    public Map<String, Object> getSalesInfoBySalesId(@RequestParam("salesId") Long salesId) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        SalesInfoDTO salesInfoDTO = salesInfoDAO.getSalesInfoBySalesId(salesId);
        if (salesInfoDTO == null) {
            returnMap.put("code", 9999);
            returnMap.put("msg", "找不到该店员信息");
            return returnMap;
        }

        returnMap.put("code", 200);
        returnMap.put("data", salesInfoDTO);
        returnMap.put("msg", "获取该店员信息成功");
        return returnMap;
    }
}
