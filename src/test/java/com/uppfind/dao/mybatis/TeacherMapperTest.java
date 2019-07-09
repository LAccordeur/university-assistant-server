package com.uppfind.dao.mybatis;

import com.uppfind.entity.TeacherBasic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TeacherMapperTest {

    @Resource
    private TeacherMapper teacherMapper;

    @Test
    public void selectAllTeachers() throws Exception {

        List<TeacherBasic> teacherBasicList = teacherMapper.selectAllTeachers();
        for (TeacherBasic teacherBasic : teacherBasicList) {
            System.out.println(teacherBasic);
        }
    }

}