package com.uppfind.service.impl;

import com.uppfind.dao.FeedbackMapper;
import com.uppfind.entity.Feedback;
import com.uppfind.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LAccordeur on 2017/6/10.
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    public void addFeedbackInfo(String contact, String problemType, String detail) {
        Feedback feedback = new Feedback(contact, problemType, detail);
        feedbackMapper.addFeedbackInfo(feedback);
    }
}
