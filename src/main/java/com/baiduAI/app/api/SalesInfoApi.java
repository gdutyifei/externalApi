package com.baiduAI.app.api;

import com.baiduAI.app.service.SalesInfoService;
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

    @RequestMapping("/getSalesInfoBySalesId")
    public Map<String, Object> getSalesInfoBySalesId(@RequestParam("salesId") Long salesId, @RequestParam("openid") String openid) throws Exception {
        return salesInfoService.getSalesInfoBySalesId(salesId, openid);
    }
}
