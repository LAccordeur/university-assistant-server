package com.uppfind.controller;

import com.uppfind.controller.base.BaseController;
import com.uppfind.dto.CommentDTO;
import com.uppfind.dto.Response;
import com.uppfind.entity.Comment;
import com.uppfind.service.CommentService;
import com.uppfind.util.log.ConstCommonString;
import com.uppfind.util.log.LogUtil;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by LAccordeur on 2017/7/17.
 */
@Controller
@RequestMapping
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comment/teacher",
            method = RequestMethod.GET,
            produces = {"application/json;charset=utf8"})
    @ResponseBody
    public Response<List<Comment>> queryCommentByTeacherId(String id, String userId) {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_TEACHER_COMMENT"));
        logger.info("Request--" + id);

        Comment comment = new Comment(id, 1, userId);
        return commentService.queryCommentByTargetId(comment);
    }

    @RequestMapping(value = "/comment/teacher",
            method = RequestMethod.POST)
    @ResponseBody
    public Response addComment(@RequestBody CommentDTO commentDTO) {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("ADD_TEACHER_COMMENT"));
        logger.info("Request--" + commentDTO.toString());

        return commentService.addComment(commentDTO);
    }
}
