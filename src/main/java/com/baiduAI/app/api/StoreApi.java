package com.baiduAI.app.api;

import com.baiduAI.app.service.StoreService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by luoyifei on 2018/3/2.
 */
@RestController
@RequestMapping(value = "/api/store/", method = {RequestMethod.GET, RequestMethod.POST})

public class StoreApi {

    @Autowired
    private StoreService storeService;

    @RequestMapping("/getStoreInfoBySalesId")
    public Map<String, Object> getStoreInfoBySalesId(@Param("salesId") Long salesId, @Param("openid") String openid) {
        return storeService.getStoreInfoBySalesId(salesId, openid);
    }
}
