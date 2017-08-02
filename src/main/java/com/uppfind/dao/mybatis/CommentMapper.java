package com.uppfind.dao.mybatis;

import com.uppfind.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by LAccordeur on 2017/7/17.
 *
 */
public interface CommentMapper {
    /**
     * 根据对象id查询该对象下的评论
     * @param comment
     */
    List<Comment> queryCommentByTargetId(Comment comment);

    /**
     * 添加评论
     * @param comment
     */
    int addComment(Comment comment);

    /**
     * 获取指定对象下的评论数
     * @param comment
     * @return
     */
    int queryCommentCountByTargetId(Comment comment);
}
