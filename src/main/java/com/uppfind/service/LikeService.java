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
     * @param like
     * @return
     */
    Response addLike(Like like, String token);

    /**
     * 返回token
     * @return
     */
    Response getTokenResponse();


    /**
     * 取消对某个对象的点赞
     * @return
     */
    Response minusLike(Like like);
}
