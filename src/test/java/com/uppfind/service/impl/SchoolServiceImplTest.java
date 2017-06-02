package com.uppfind.service.impl;

import com.uppfind.dto.Response;
import com.uppfind.service.SchoolService;
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
public class SchoolServiceImplTest {

    @Resource
    private SchoolService schoolService;

    @Test
    public void querySchoolSet() throws Exception {
        Response response = schoolService.querySchoolSet("四川", "电子科技大学");
        System.out.println(response);
    }

    @Test
    public void querySchoolList() throws Exception {
        Response response = schoolService.querySchoolList("信息");
        System.out.println(response);
    }

    @Test
    public void querySchoolInfo() throws Exception {
        Response response = schoolService.querySchoolInfo("10614022");
        System.out.println(response);
    }

}