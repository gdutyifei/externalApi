package com.baiduAI.app.api;

import com.baiduAI.app.service.FormIdInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luoyifei on 2018/2/20.
 */
@RestController
@RequestMapping(value = "/api/formIdInfo/", method = {RequestMethod.GET, RequestMethod.POST})
public class FormIdInfoApi {

    @Autowired
    private FormIdInfoService formIdInfoService;

    @RequestMapping("/saveFormInfo")
    public void saveFormInfo(@Param("openid") String openid, @Param("formId") String formId) {
        formIdInfoService.saveFormInfo(openid, formId);
    }
}
