package com.uppfind.dao;

import com.sun.codemodel.internal.util.MS1252Encoder;
import com.uppfind.entity.MasterMajor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

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
    public void queryMajorFieldList() throws Exception {
        List<MasterMajor> masterMajors = masterMajorMapper.queryMajorFieldList("人工");
        System.out.println(masterMajors);
    }

    @Test
    public void queryMajorMajorInfo() throws Exception {
        MasterMajor masterMajor = masterMajorMapper.queryMajorMajorInfo(10614022L,83500);
        System.out.println(masterMajor);
    }

}