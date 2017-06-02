package com.uppfind.dao;

import com.uppfind.entity.University;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by LAccordeur on 2017/5/31.
 */
/**
 * Created by codingBoy on 16/11/27.
 * 配置spring和junit整合，这样junit在启动时就会加载spring容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UniversityMapperTest {
    @Test
    public void queryUniversityInfo() throws Exception {
        List<University> university = universityMapper.queryUniversityInfo(10614);
        System.out.println(university);
    }

    @Test
    public void queryUniversitySet() throws Exception {
        List<University> universities = universityMapper.queryUniversitySet("四川");
        for (int i = 0; i < universities.size(); i++) {
            System.out.println(universities.get(i));
        }
    }

    @Test
    public void queryUniversityList() throws Exception {
        List<University> universities = universityMapper.queryUniversityList("电子");
        System.out.println(universities);
    }

    @Resource
    private UniversityMapper universityMapper;

    @Test
    public void queryProvinceSet() throws Exception {

        List<University> provinces = universityMapper.queryProvinceSet();
        System.out.println(provinces);
    }

}