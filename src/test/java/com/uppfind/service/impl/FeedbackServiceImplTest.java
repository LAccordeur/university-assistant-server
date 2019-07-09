package com.uppfind.service.impl;

import com.uppfind.service.FeedbackService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by LAccordeur on 2017/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class FeedbackServiceImplTest {

    @Resource
    FeedbackService feedbackService;

    @Test
    public void addFeedbackInfo() throws Exception {
        feedbackService.addFeedbackInfo("18925721780", "其他", "服务层测试");
    }

}