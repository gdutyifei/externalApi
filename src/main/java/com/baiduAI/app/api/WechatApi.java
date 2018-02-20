package com.baiduAI.app.api;

import com.baiduAI.app.config.RedisClient;
import com.baiduAI.app.service.WechatService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
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

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/getOpenidByCode")
    public String getOpenidByCode(@RequestParam(value = "code", required = true) String code) throws Exception {
        return wechatService.getOpenidByCode(code);
    }

    @RequestMapping("/uploadImage")
    public String uploadImage(@RequestParam(required = false, value = "file") MultipartFile file) throws Exception {
        return wechatService.uploadImage(file);
    }

    @RequestMapping("/sendTemplateMsg")
    public Map<String, Object> sendTemplateMsg(@RequestParam(value = "openid", required = false) String openid,
                    @RequestParam(value = "contentArr", required = false) String[] contentArr,
                    @RequestParam(value = "templateMsgType", required = false) String templateMsgType,
                    @RequestParam(value = "url", required = false) String url) {
        return wechatService.sendTemplateMsg(openid, contentArr, templateMsgType, url);
    }

    @RequestMapping("/saveUserInfo")
    public Map<String, Object> saveUserInfo(@RequestParam("userInfo") String userInfo, @RequestParam("code") String code) {
        return wechatService.saveUserInfo(userInfo, code);
    }

    @RequestMapping("/getwxacode")
    public String getwxacode(@Param("scene") String scene, @Param("page") String page) {
        return wechatService.getwxacode(scene, page);
    }

    @RequestMapping("/set")
    public String set(String key, String value) throws Exception{
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("test", "1");
        return "success";
    }

    @RequestMapping("/get")
    public String get(String key) throws Exception {
        // return redisClinet.get(key);
        return null;
    }
}
