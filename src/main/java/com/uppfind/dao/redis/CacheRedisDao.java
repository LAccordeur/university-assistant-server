package com.uppfind.dao.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uppfind.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by LAccordeur on 2017/8/1.
 */
public class CacheRedisDao {

    private final static String key = "HEAT_SEARCH";

    @Autowired
    private StringRedisTemplate redisTemplate;


    /**
     * 采用sorted map存储热度搜索关键词，有效时间为24小时,其存储在名为heat_search的map结构中
     * @param keyword
     */
    public void updateHeatSearch(String keyword) {
        ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
        operations.incrementScore(key.toLowerCase(), keyword, 1);

        if (redisTemplate.getExpire(key.toLowerCase()) == -1) {
            redisTemplate.expire(key, 24*60*60, TimeUnit.SECONDS);
        }

        if (operations.zCard(key.toLowerCase()) > 100) {
            operations.removeRange(key.toLowerCase(), 100, -1);
        }

    }

    /**
     * 获取搜索热度最高的6个关键词
     * @return
     */
    public Set<String> getHeatSearch() {

        ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
        Set<String> resultSet = operations.reverseRange(key.toLowerCase(),0,5);
        return resultSet;
    }


    /**
     * 将返回内容在内存中保留一小时
     * @param response
     * @param key
     */
    public void saveToCache(Response response, String key) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            operations.set(key, objectMapper.writeValueAsString(response), 60*60, TimeUnit.SECONDS);
        }catch (JsonProcessingException e) {
            e.printStackTrace();
            return;
        }
    }


    /**
     * 若缓存中存在则根据key从缓存中取出返回数据
     * @param key
     * @return
     */
    public String getFromCache(String key) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String result = operations.get(key);
        if (result == null) {
            //缓存中不存在
            return null;
        }
        return result;
    }
}
