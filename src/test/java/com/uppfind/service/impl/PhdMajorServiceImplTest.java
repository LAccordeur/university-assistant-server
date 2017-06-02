package com.uppfind.service.impl;

import com.uppfind.dto.Response;
import com.uppfind.service.PhdMajorService;
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
public class PhdMajorServiceImplTest {

    @Resource
    private PhdMajorService phdMajorService;

    @Test
    public void queryPhdMajorSet() throws Exception {
        Response response = phdMajorService.queryPhdMajorSet("四川","电子科技大学","信息与软件工程学院");
        System.out.println(response);
    }

    @Test
    public void queryPhdMajorList() throws Exception {
        Response response = phdMajorService.queryPhdMajorList("信息");
        System.out.println(response);
    }

    @Test
    public void queryPhdMajorInfo() throws Exception {
        Response response = phdMajorService.queryPhdMajorInfo("10614022","83500");
        System.out.println(response);
    }

}