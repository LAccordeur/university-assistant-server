package com.uppfind.service.impl;

import com.uppfind.dto.Response;
import com.uppfind.service.TeacherService;
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
public class TeacherServiceImplTest {

    @Resource
    private TeacherService teacherService;

    @Test
    public void queryTeacherSet() throws Exception {
        Response response = teacherService.queryTeacherSet("四川","电子科技大学","信息与软件工程学院");
        System.out.println(response);
    }

    @Test
    public void queryTeacherList() throws Exception {
        Response response = teacherService.queryTeacherList("郭");
        System.out.println(response);
    }

    @Test
    public void queryTeacherInfo() throws Exception {
        //Response response = teacherService.queryTeacherInfo("1061402210729");
        //System.out.println(response);
    }

    @Test
    public void queryTeacherPageList() throws Exception {
        //Response response = teacherService.queryTeacherPageList("赵",8,1);
        //System.out.println(response);
    }

}