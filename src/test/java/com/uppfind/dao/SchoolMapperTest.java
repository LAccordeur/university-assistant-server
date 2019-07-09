package com.uppfind.dao;

import com.uppfind.dao.mybatis.SchoolMapper;
import com.uppfind.entity.School;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LAccordeur on 2017/5/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SchoolMapperTest {
    @Test
    public void querySchoolList() throws Exception {
        List<School> schools = schoolMapper.querySchoolList("计算机");
        System.out.println(schools);
    }

    @Test
    public void querySchoolInfo() throws Exception {
        List<School> school = schoolMapper.querySchoolInfo(10614022L);
        System.out.println(school);
    }

    @Resource
    private SchoolMapper schoolMapper;

    @Test
    public void querySchoolSet() throws Exception {
        List<School> schools = schoolMapper.querySchoolSet("四川","电子科技大学");
        System.out.println(schools);
    }

}