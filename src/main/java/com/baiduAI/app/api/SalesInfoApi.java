package com.baiduAI.app.api;

import com.baiduAI.app.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by luoyifei on 2018/2/20.
 */
@RestController
@RequestMapping(value = "/api/salesInfo/", method = {RequestMethod.GET, RequestMethod.POST})
public class SalesInfoApi {

    @Autowired
    private SalesInfoService salesInfoService;

    @Autowired
    private RankCallDetailService rankCallDetailService;

    @Autowired
    private RankTranspondDetailService rankTranspondDetailService;

    @Autowired
    private RankClickPraiseDetailService rankClickPraiseDetailService;

    @Autowired
    private RankSaveCardDetailService rankSaveCardDetailService;

    @Autowired
    private RankFollowDetailService rankFollowDetailService;

    @RequestMapping("/getSalesInfoBySalesId")
    public Map<String, Object> getSalesInfoBySalesId(@RequestParam("salesId") Long salesId, @RequestParam("openid") String openid) throws Exception {
        return salesInfoService.getSalesInfoBySalesId(salesId, openid);
    }

    /**
     * 保存用户拨打电话详细记录
     * @param openid
     * @param sales_id
     * @throws Exception
     */
    @RequestMapping("/saveRankCallDetail")
    public void saveRankCallDetail(@Param("openid") String openid, @Param("sales_id") Long sales_id, @Param("phone") String phone) throws Exception {
        rankCallDetailService.saveRankCallDetail(openid, sales_id, phone);
    }

    /**
     * 转发记录
     * @param openid
     * @param sales_id
     * @throws Exception
     */
    @RequestMapping("/saveRankTranspondDetail")
    public void saveRankTranspondDetail(@Param("openid") String openid, @Param("sales_id") Long sales_id) throws Exception {
        rankTranspondDetailService.saveRankTranspondDetail(openid, sales_id);
    }

    /**
     * 点赞接口
     * @param openid
     * @param sales_id
     * @throws Exception
     */
    @RequestMapping("/saveRankClickPraiseDetail")
    public void saveRankClickPraiseDetail(@Param("openid") String openid, @Param("sales_id") Long sales_id) throws Exception {
        rankClickPraiseDetailService.saveRankClickPraiseDetail(openid, sales_id);
    }

    /**
     * 保存用户名片
     * @param openid
     * @param sales_id
     * @throws Exception
     */
    @RequestMapping("/saveRankSaveCardDetail")
    public void saveRankSaveCardDetail(@Param("openid") String openid, @Param("sales_id") Long sales_id) throws Exception {
        rankSaveCardDetailService.saveRankSaveCardDetail(openid, sales_id);
    }

    /**
     * 保存跟进信息（跟保存聊天记录同时调用）
     * @param openid
     * @param sales_id
     * @throws Exception
     */
    @RequestMapping("/saveRankFollowDetail")
    public void saveRankFollowDetail(@Param("openid") String openid, @Param("sales_id") Long sales_id) throws Exception {
        rankFollowDetailService.saveRankFollowDetail(openid, sales_id);
    }

}