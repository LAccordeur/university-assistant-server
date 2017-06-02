package com.uppfind.service.impl;

import com.uppfind.dto.Response;
import com.uppfind.service.UniversityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by LAccordeur on 2017/6/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class UniversityServiceImplTest {

    @Resource
    private UniversityService universityService;

    @Test
    public void queryProvinceSet() throws Exception {
        Response response = universityService.queryProvinceSet();
        System.out.println(response);
    }

    @Test
    public void queryUniversityList() throws Exception {
        Response response = universityService.queryUniversityList("电子");
        System.out.println(response);
    }

    @Test
    public void queryUniversitySet() throws Exception {
        Response response = universityService.queryUniversitySet("四川");
        System.out.println(response);
    }

    @Test
    public void queryUniversityInfo() throws Exception {
        Response response = universityService.queryUniversityInfo("10614");
        System.out.println(response);
    }

}