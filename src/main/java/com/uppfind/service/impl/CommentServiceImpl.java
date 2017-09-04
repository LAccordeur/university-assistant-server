package com.uppfind.service.impl;

import com.uppfind.dao.mybatis.CommentMapper;
import com.uppfind.dto.CommentDTO;
import com.uppfind.dto.Response;
import com.uppfind.entity.Comment;
import com.uppfind.service.CommentService;
import com.uppfind.util.assembler.CommentAssembler;
import com.uppfind.util.comment.AnonymousUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LAccordeur on 2017/7/17.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public Response queryCommentByTargetId(Comment comment) {
        Response<List<Comment>> response = new Response<List<Comment>>();

        //组装
        List<Comment> commentList = commentMapper.queryCommentByTargetId(comment);
        response.setData(commentList);
        response.setCount(commentList.size());
        response.setType("comment");

        return response;
    }

    public Response addComment(CommentDTO commentDTO) {

        Comment comment = CommentAssembler.toEntity(commentDTO);
        comment.setUserName(AnonymousUtil.getAnonymousName() + AnonymousUtil.getAnonymousId() + "号");
        comment.setIcon("/img/icon/" + AnonymousUtil.getAnonymousId() + ".jpg");


        if (commentMapper.addComment(comment) > 0) {
            Comment newComment = commentMapper.queryCommentById(comment);
            newComment.setIsLike(0);
            Response response = new Response();
            response.setData(newComment);
            response.setCount(1);
            response.setType("comment");
            return response;
        }
        return null;
    }
}
