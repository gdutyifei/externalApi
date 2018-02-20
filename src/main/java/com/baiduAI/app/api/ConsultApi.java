package com.baiduAI.app.api;

import com.baiduAI.app.service.ConsultService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by luoyifei on 2018/2/20.
 */
@RestController
@RequestMapping(value = "/api/consult/", method = {RequestMethod.GET, RequestMethod.POST})
public class ConsultApi {

    @Autowired
    private ConsultService consultService;

    @RequestMapping("/saveConsultInfo")
    public Map<String, Object> saveConsultInfo(@Param("openid") String openid, @Param("salesOpenid") String salesOpenid, @Param("id") Long productId, @Param("name") String name, @Param("tel") String tel, @Param("title") String title, @Param("content") String content) {
        return consultService.saveConsultInfo(openid, salesOpenid, productId, name, tel, title, content);
    }
}
