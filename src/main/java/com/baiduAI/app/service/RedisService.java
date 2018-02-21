package com.baiduAI.app.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by luoyifei on 2018/2/20.
 */
@Slf4j
@Service
public class RedisService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 保存到redis中，value值为Set类型
     * @param key
     * @param value
     * @throws Exception
     */
    public void saveToRedis(@Param("key") String key, @Param("value") String value) throws Exception {
        Set<String> values = (Set<String>) this.getFromRedis(key);
        if (values != null) {
            values.add(value);
        } else {
            values = new HashSet<String>();
            values.add(value);
        }

        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, values);
    }

    public Object getFromRedis(String key) throws Exception {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        Object value = valueOperations.get(key);
        return value;
    }
}
