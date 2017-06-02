package com.uppfind.dao;

import com.uppfind.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by LAccordeur on 2017/5/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TeacherMapperTest {

    @Resource
    private TeacherMapper teacherMapper;

    @Test
    public void queryTeacherSet() throws Exception {
        List<Teacher> teachers = teacherMapper.queryTeacherSet("四川","电子科技大学","信息与软件工程学院");
        System.out.println(teachers);
    }

    @Test
    public void queryTeacherList() throws Exception {
        List<Teacher> teachers = teacherMapper.queryTeacherList("郭");
        System.out.println(teachers);
    }

    @Test
    public void queryTeacherInfo() throws Exception {
        Teacher teacher = teacherMapper.queryTeacherInfo(1061402211243L);
        System.out.println(teacher);
    }

}