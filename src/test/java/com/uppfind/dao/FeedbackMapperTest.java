package com.uppfind.dao;

import com.uppfind.dao.mybatis.FeedbackMapper;
import com.uppfind.entity.Feedback;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by LAccordeur on 2017/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class FeedbackMapperTest {

    @Resource
    private FeedbackMapper feedbackMapper;

    @Test
    public void addFeedbackInfo() throws Exception {
        Feedback feedback = new Feedback();
        feedback.setContact("18923126723");
        feedback.setProblem("其他");
        feedback.setDetail("我的测试");
        feedbackMapper.addFeedbackInfo(feedback);
    }

}