package com.uppfind.controller;

import com.uppfind.controller.base.BaseController;
import com.uppfind.dto.Response;
import com.uppfind.entity.Feedback;
import com.uppfind.service.impl.FeedbackServiceImpl;
import com.uppfind.util.log.ConstCommonString;
import com.uppfind.util.log.LogUtil;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LAccordeur on 2017/6/11.
 */
@Controller
@RequestMapping
public class FeedbackController extends BaseController {

    @Autowired
    private FeedbackServiceImpl feedbackService;

    @RequestMapping(value = "/feedback", method = RequestMethod.POST, produces = {"application/json;charset=utf8"})
    @ResponseBody
    public Response addFeedbackInfo(@RequestBody Feedback feedback) {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("ADD_FEEDBACK"));
        logger.info("Request--" + feedback.toString());

        return feedbackService.addFeedbackInfo(feedback.getContact(), feedback.getProblem(), feedback.getDetail());
    }
}
