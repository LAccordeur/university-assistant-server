package com.uppfind.controller;

import com.uppfind.dto.Response;
import com.uppfind.entity.Comment;
import com.uppfind.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by LAccordeur on 2017/7/17.
 */
@Controller
@RequestMapping
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comment/teacher",
            method = RequestMethod.GET,
            produces = {"application/json;charset=utf8"})
    @ResponseBody
    public Response<List<Comment>> queryCommentByTeacherId(String id) {
        return commentService.queryCommentByTeacherId(id);
    }

    @RequestMapping(value = "/comment/teacher",
            method = RequestMethod.POST)
    @ResponseBody
    public void addComment(String content, @RequestParam(required = false) String userName, String id, String type) {
        commentService.addComment(content, userName, id, type);
    }
}
