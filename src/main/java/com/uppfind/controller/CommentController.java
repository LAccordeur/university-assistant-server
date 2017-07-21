package com.uppfind.controller;

import com.uppfind.dto.CommentDTO;
import com.uppfind.dto.Response;
import com.uppfind.entity.Comment;
import com.uppfind.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public Response addComment(@RequestBody CommentDTO commentDTO) {
        return commentService.addComment(commentDTO);
    }
}
