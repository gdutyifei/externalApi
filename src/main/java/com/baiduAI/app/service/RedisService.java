package com.baiduAI.app.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public static final Logger logger = LoggerFactory.getLogger(RedisService.class);

    @Resource
    private RedisTemplate<String, Object> longRedisTemplate;

    /**
     * 保存到redis中
     * @param key
     * @throws Exception
     */
    public void saveLongToRedis(@Param("key") String key) throws Exception {
        ValueOperations<String, Object> valueOperations = longRedisTemplate.opsForValue();
        valueOperations.set(key, valueOperations.get(key) == null? "1": (Integer.parseInt(valueOperations.get(key).toString()) + 1) + "");
        logger.info(valueOperations.get(key).toString());
    }

    public Integer getFromRedis(String key) throws Exception {
        ValueOperations<String, Object> valueOperations = longRedisTemplate.opsForValue();
        Integer value = valueOperations.get(key) == null ? 0: Integer.parseInt(valueOperations.get(key).toString());
        return value;
    }
}
