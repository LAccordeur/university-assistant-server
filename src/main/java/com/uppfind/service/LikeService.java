package com.uppfind.service;

import com.uppfind.dto.Response;
import com.uppfind.entity.Like;

/**
 * Created by LAccordeur on 2017/7/18.
 */
public interface LikeService {

    /**
     * 根据老师id查询该老师的点赞数
     * @param teacherId
     * @return
     */
    Response queryLikeByTeacherId(String teacherId);

    /**
     * 为喜欢的对象点赞
     * @param likeId
     * @return
     */
    Response addLike(String likeId, String token);

    /**
     * 返回token
     * @return
     */
    Response getTokenResponse();
}
