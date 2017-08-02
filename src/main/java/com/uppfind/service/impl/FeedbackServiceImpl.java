package com.uppfind.service.impl;

import com.uppfind.dao.mybatis.FeedbackMapper;
import com.uppfind.dto.Response;
import com.uppfind.entity.Feedback;
import com.uppfind.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Created by LAccordeur on 2017/6/10.
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    public Response addFeedbackInfo(String contact, String problemType, String detail) {
        Feedback feedback = new Feedback(contact, problemType, detail);
        int flag = feedbackMapper.addFeedbackInfo(feedback);

        Response response = new Response();
        if (flag > 0) {
            response.setData(null);
            response.setType("feedback");
            response.setMsg("添加反馈成功");
            response.setCode(HttpStatus.OK.value());
        }
        return response;
    }
}
