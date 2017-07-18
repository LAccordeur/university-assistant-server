package com.uppfind.dao;

import com.uppfind.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by LAccordeur on 2017/7/17.
 *
 */
public interface CommentMapper {
    /**
     * 根据导师id查询某位导师下的评论
     * @param teacherId
     */
    List<Comment> queryCommentByTeacherId(@Param("teacherId") String teacherId);

    /**
     * 添加评论
     * @param comment
     */
    int addComment(Comment comment);
}
