package com.uppfind.service.impl;

import com.uppfind.dao.CommentMapper;
import com.uppfind.dto.Response;
import com.uppfind.entity.Comment;
import com.uppfind.service.CommentService;
import com.uppfind.util.comment.AnonymousUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LAccordeur on 2017/7/17.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public Response queryCommentByTeacherId(String teacherId) {
        Response<List<Comment>> response = new Response<List<Comment>>();


        //组装
        List<Comment> commentList = commentMapper.queryCommentByTeacherId(teacherId);
        response.setResult(commentList);
        response.setCount(commentList.size());
        response.setTotal(commentList.size());
        response.setStart(0);
        response.setType("comment");

        return response;
    }

    public int addComment(String content, String userName, String id, String type) {

        if (userName == null) {
            userName = AnonymousUtil.getAnonymousName();
        }

        Comment comment = null;
        if ("teacher".equals(type) || "1".equals(type)) {
            comment = new Comment(id, 1, content, userName);
        }

        if (commentMapper.addComment(comment) > 0) {
            return 1;
        }
        return 0;
    }
}
