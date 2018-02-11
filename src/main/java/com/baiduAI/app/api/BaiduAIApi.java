package com.baiduAI.app.api;

import com.alibaba.fastjson.JSONObject;
import com.baiduAI.app.bean.BaiduAIBean;
import com.baiduAI.app.sao.BaiduAISao;
import com.baiduAI.app.service.BaiduAIService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by luoyifei on 2018/2/9.
 */
@RestController
@RequestMapping(value = "/api/baiduAI/", method = {RequestMethod.GET, RequestMethod.POST})
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BaiduAIApi {

    @NonNull
    private BaiduAIService baiduAIService;

    @RequestMapping("/facesetAdd")
    public String facesetAdd(@RequestParam(value = "imgUrl", required = true) String imgUrl, @RequestParam(value = "userInfo") String userInfo, @RequestParam(value = "openid", required = true) String openid) throws Exception {
        return baiduAIService.facesetAdd(imgUrl, userInfo, openid);
    }

    @RequestMapping("/facesetUpdate")
    public String facesetUpdate(@RequestParam(value = "imgUrl", required = true) String imgUrl, @RequestParam(value = "userInfo") String userInfo, @RequestParam(value = "openid", required = true) String openid) throws Exception {
        return baiduAIService.facesetUpdate(imgUrl, userInfo, openid);
    }

    @RequestMapping("/facesetIdentify")
    public String facesetIdentify(@RequestParam(value = "imgUrl", required = true) String imgUrl) throws Exception {
        return baiduAIService.facesetIdentify(imgUrl);
    }

}
