package com.uppfind.dao.mybatis;


import com.uppfind.entity.Like;
import org.apache.ibatis.annotations.Param;

/**
 * Created by LAccordeur on 2017/7/18.
 */
public interface LikeMapper {

    /**
     * 根据对象id查询该对象的点赞数
     * @param like
     * @return
     */
    Like queryLikeByTargetId(Like like);

    /**
     *
     * @param likeId
     * @return
     */
    Like queryLikeById(@Param("likeId") String likeId);

    /**
     * 为喜欢的对象点赞（该对象已有赞更新即可）
     * @param like
     * @return
     */
    int updateLike(Like like);

    /**
     * 初次点赞
     * @param like
     * @return
     */
    int addLike(Like like);


    /**
     * 获取指定对象的点赞数
     * @param like
     * @return
     */
    int queryLikeCountByTargetId(Like like);

    /**
     * 取消对某个对象的点赞
     * @param like
     * @return
     */
    int minusLike(Like like);
}
