package com.baiduAI.app.service;

import com.alibaba.fastjson.JSONObject;
import com.baiduAI.app.dao.CompanyInfoDAO;
import com.baiduAI.app.dao.CompanyUserInfoDAO;
import com.baiduAI.app.dao.RankStroeReadDetailDAO;
import com.baiduAI.app.dto.CompanyInfoDTO;
import com.baiduAI.app.dto.CompanyUserInfoDTO;
import com.baiduAI.app.dto.WechatDTO;
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
 * Created by luoyifei on 2018/3/2.
 */
@Slf4j
@Service
public class StoreService {

    public static final Logger logger = LoggerFactory.getLogger(StoreService.class);

    @Autowired
    private CompanyInfoDAO companyInfoDAO;

    @Autowired
    private CompanyUserInfoDAO companyUserInfoDAO;

    @Autowired
    private RankStroeReadDetailDAO rankStroeReadDetailDAO;

    @Autowired
    private WechatService wechatService;
    /**
     * 根据salesId获取门店信息
     * @param salesId
     * @return
     */
    public Map<String, Object> getStoreInfoBySalesId(@Param("salesId") Long salesId, @Param("openid") String openid) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        CompanyInfoDTO companyInfoDTO = companyInfoDAO.findCompanyInfoBySalesId(salesId);
        if (companyInfoDTO == null) {
            returnMap.put("msg", "获取不到门店信息");
            returnMap.put("code", 3000);
            return returnMap;
        }
        // 根据salesId获取店员信息
        List<CompanyUserInfoDTO> companyUsers = companyUserInfoDAO.findCompanyUserInfoBySalesId(salesId);
        JSONObject jo = (JSONObject) JSONObject.toJSON(companyInfoDTO);
        jo.put("companyUsers", companyUsers);
        returnMap.put("msg", "获取信息成功");
        returnMap.put("code", 200);
        returnMap.put("data", jo);
        // 门店查看记录
        WechatDTO wechatDTO = wechatService.getWechatDTOInfoByOpenid(openid);
        if (wechatDTO == null) {
            logger.info("找不到C端用户信息");
            return returnMap;
        }
        Long cursr_id = wechatDTO.getId();
        rankStroeReadDetailDAO.saveRankStroeReadDetail(openid, cursr_id, salesId);
        return returnMap;
    }
}
