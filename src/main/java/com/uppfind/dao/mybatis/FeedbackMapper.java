package com.uppfind.dao.mybatis;

import com.uppfind.entity.Feedback;

/**
 * Created by LAccordeur on 2017/6/10.
 */
public interface FeedbackMapper {

    /**
     * 保存用户的反馈信息至数据库
     * @param feedback
     */
    int addFeedbackInfo(Feedback feedback);


}
