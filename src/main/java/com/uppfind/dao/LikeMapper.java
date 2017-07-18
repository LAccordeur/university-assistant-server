package com.uppfind.dao;


import com.uppfind.entity.Like;
import org.apache.ibatis.annotations.Param;

/**
 * Created by LAccordeur on 2017/7/18.
 */
public interface LikeMapper {

    /**
     * 根据老师id查询该老师的点赞数
     * @param teacherId
     * @return
     */
    Like queryLikeByTeacherId(@Param("teacherId") String teacherId);

    /**
     *
     * @param likeId
     * @return
     */
    Like queryLikeById(@Param("likeId") String likeId);

    /**
     * 为喜欢的对象点赞
     * @param like
     * @return
     */
    int addLike(Like like);
}
