package com.uppfind.dao.redis;

import com.uppfind.dao.mybatis.TeacherMapper;
import com.uppfind.dto.Response;
import com.uppfind.entity.Teacher;
import com.uppfind.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by LAccordeur on 2017/8/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-dao.xml")
public class CacheRedisDaoTest {

    @Resource
    private CacheRedisDao cacheRedisDao;

    @Resource
    private StringRedisTemplate redisTemplate;

    @Resource
    private TeacherMapper teacherMapper;

    @Test
    public void updateHeatSearch() throws Exception {
        cacheRedisDao.updateHeatSearch("詹瑾瑜");
    }

    @Test
    public void getHeatSearch() throws Exception {
        System.out.println(cacheRedisDao.getHeatSearch());
        System.out.println(redisTemplate.getExpire("heat_search"));
        System.out.println(redisTemplate.opsForValue().get("hah"));
    }

    @Test
    public void saveToCache() {

        //List<Teacher> teachers = teacherMapper.queryTeacherInfo(1061400011157L);

        Response<List<Teacher>> response = new Response<List<Teacher>>();
        //response.setData(teachers);
        //response.setCount(teachers.size());
        response.setType("teacher");
        cacheRedisDao.saveToCache(response, response.getType()+response.getData().get(0).getId());

        System.out.println(cacheRedisDao.getFromCache(response.getType()+response.getData().get(0).getId()));
    }

}