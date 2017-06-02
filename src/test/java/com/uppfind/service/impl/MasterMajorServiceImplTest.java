package com.uppfind.service.impl;

import com.uppfind.dto.Response;
import com.uppfind.service.MasterMajorService;
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
public class MasterMajorServiceImplTest {

    @Resource
    private MasterMajorService masterMajorService;

    @Test
    public void queryMasterMajorSet() throws Exception {
        Response response = masterMajorService.queryMasterMajorSet("四川","电子科技大学","信息与软件工程学院");
        System.out.println(response);
    }

    @Test
    public void queryMasterMajorList() throws Exception {
        Response response = masterMajorService.queryMasterMajorList("信息");
        System.out.println(response);
    }

    @Test
    public void queryMajorFieldList() throws Exception {
        Response response = masterMajorService.queryMajorFieldList("人工智能");
        System.out.println(response);
    }

    @Test
    public void queryMasterMajorInfo() throws Exception {
        Response response = masterMajorService.queryMasterMajorInfo("10614022", "83500");
        System.out.println(response);
    }

}