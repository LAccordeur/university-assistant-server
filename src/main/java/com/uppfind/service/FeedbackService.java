package com.uppfind.service;

import com.uppfind.dto.Response;
import com.uppfind.entity.Feedback;

/**
 * Created by LAccordeur on 2017/6/10.
 */
public interface FeedbackService {

    /**
     * 将用户反馈信息添加到数据库中
     * @param contact
     * @param problemType
     * @param detail
     */
    Response addFeedbackInfo(String contact, String problemType, String detail);

}
