package com.baiduAI.app.api;

import com.baiduAI.app.service.WechatService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by luoyifei on 2018/2/10.
 */
@RestController
@RequestMapping(value = "/api/wechat/", method = {RequestMethod.GET, RequestMethod.POST})
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WechatApi {

    @NonNull
    private WechatService wechatService;

    @RequestMapping("/getOpenidByCode")
    public String getOpenidByCode(@RequestParam(value = "code", required = true) String code) throws Exception {
        return wechatService.getOpenidByCode(code);
    }

    @RequestMapping("/uploadImage")
    public String uploadImage(@RequestParam(required = false, value = "file") MultipartFile file) throws Exception {
        return wechatService.uploadImage(file);
    }
}
