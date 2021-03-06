package com.uppfind.dao;

import com.uppfind.dao.mybatis.MasterMajorMapper;
import com.uppfind.entity.MasterMajor;
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
public class MasterMajorMapperTest {

    @Resource
    private MasterMajorMapper masterMajorMapper;

    @Test
    public void queryMasterMajorSet() throws Exception {
        List<MasterMajor> masterMajors = masterMajorMapper.queryMasterMajorSet("四川","电子科技大学","信息与软件工程学院");
        System.out.println(masterMajors);
    }

    @Test
    public void queryMasterMajorList() throws Exception {
        List<MasterMajor> masterMajors = masterMajorMapper.queryMasterMajorList("信息");
        System.out.println(masterMajors);
    }



    @Test
    public void queryMajorMajorInfo() throws Exception {
        List<MasterMajor> masterMajor = masterMajorMapper.queryMasterMajorInfo(10614022L,83500);
        System.out.println(masterMajor);
    }

}