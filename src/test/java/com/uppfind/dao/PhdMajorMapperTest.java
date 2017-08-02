package com.uppfind.dao;

import com.uppfind.dao.mybatis.PhdMajorMapper;
import com.uppfind.entity.PhdMajor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LAccordeur on 2017/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class PhdMajorMapperTest {

    @Resource
    private PhdMajorMapper phdMajorMapper;

    @Test
    public void queryPhdMajorSet() throws Exception {
        List<PhdMajor> phdMajors = phdMajorMapper.queryPhdMajorSet("四川","电子科技大学","信息与软件工程学院");
        System.out.println(phdMajors);
    }

    @Test
    public void queryPhdMajorList() throws Exception {
        List<PhdMajor> phdMajors = phdMajorMapper.queryPhdMajorList("软件");
        System.out.println(phdMajors);
    }

    @Test
    public void queryPhdMajorInfo() throws Exception {
        List<PhdMajor> phdMajor = phdMajorMapper.queryPhdMajorInfo(10614022L,83500);
        System.out.println(phdMajor);
    }

}