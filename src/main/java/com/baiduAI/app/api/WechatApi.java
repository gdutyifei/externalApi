package com.baiduAI.app.api;

import com.baiduAI.app.service.WechatService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by luoyifei on 2018/2/10.
 */
@RestController
@RequestMapping(value = "/api/wechat", method = {RequestMethod.GET, RequestMethod.POST})
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WechatApi {

    @Autowired
    private WechatService wechatService;

    @RequestMapping("/getOpenidByCode")
    public String getOpenidByCode(@RequestParam(value = "code", required = true) String code, @RequestParam(value = "type", required = true) String type) throws Exception {
        return wechatService.getOpenidByCode(code, type);
    }

    @RequestMapping("/uploadImage")
    public String uploadImage(@RequestParam(required = false, value = "file") MultipartFile file) throws Exception {
        return wechatService.uploadImage(file);
    }

    @RequestMapping("/sendTemplateMsg")
    public Map<String, Object> sendTemplateMsg(@RequestParam(value = "openid", required = false) String openid,
                    @RequestParam(value = "contentArr", required = false) String[] contentArr,
                    @RequestParam(value = "templateMsgType", required = false) String templateMsgType,
                    @RequestParam(value = "url", required = false) String url, @RequestParam(value = "token_type", required = false) String token_type) {
        return wechatService.sendTemplateMsg(openid, contentArr, templateMsgType, url, token_type);
    }

    @RequestMapping("/saveUserInfo")
    public Map<String, Object> saveUserInfo(@RequestParam("userInfo") String userInfo, @RequestParam("code") String code, @RequestParam("type") String type) {
        return wechatService.saveUserInfo(userInfo, code, type);
    }

    @RequestMapping("/getwxacode")
    public String getwxacode(@Param("scene") String scene, @Param("page") String page) {
        return wechatService.getwxacode(scene, page);
    }
}
