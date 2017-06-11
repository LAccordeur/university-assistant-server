package com.uppfind.controller;

import com.uppfind.service.impl.FeedbackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by LAccordeur on 2017/6/11.
 */
@Controller
@RequestMapping
public class FeedbackController {

    @Autowired
    private FeedbackServiceImpl feedbackService;

    @RequestMapping(value = "addFeedbackInfo.do", method = RequestMethod.POST)
    public void addFeedbackInfo() {

    }
}
