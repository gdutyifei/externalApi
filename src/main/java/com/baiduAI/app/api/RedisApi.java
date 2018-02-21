package com.baiduAI.app.api;

import com.baiduAI.app.service.RedisService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by luoyifei on 2018/2/20.
 */
@RestController
@RequestMapping(value = "/api/redis/", method = {RequestMethod.GET, RequestMethod.POST})
public class RedisApi {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/saveToRedis")
    public void saveToRedis(@Param("key") String key, @Param("value") String value) throws Exception {
        redisService.saveToRedis(key, value);
    }

    @RequestMapping("/getFromRedis")
    public Set<String> getFromRedis(@Param("key") String key) throws Exception {
       return (Set<String>) redisService.getFromRedis(key);
    }

}
