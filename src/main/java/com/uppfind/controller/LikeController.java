package com.uppfind.controller;

import com.uppfind.controller.base.BaseController;
import com.uppfind.dto.Response;
import com.uppfind.entity.Like;
import com.uppfind.service.LikeService;
import com.uppfind.util.log.ConstCommonString;
import com.uppfind.util.log.LogUtil;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LAccordeur on 2017/7/19.
 */
@Controller
@RequestMapping
public class LikeController extends BaseController {

    @Autowired
    private LikeService likeService;

    @RequestMapping(value = "/like/teacher",
            method = RequestMethod.GET,
            produces = {"application/json;charset=utf8"})
    @ResponseBody
    public Response queryLikeByTeacherId(String id) {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_TEACHER_LIKE"));
        logger.info("Request--" + id);

        return likeService.queryLikeByTeacherId(id);
    }

    @RequestMapping(value = "/like/teacher",
            method = RequestMethod.POST,
            produces = {"application/json;charset=utf8"})
    @ResponseBody
    public Response addTeacherLike(String id, @RequestParam(required = false) String token) {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("ADD_TEACHER_LIKE"));
        logger.info("Request--" + id + "_" + token);

        Like like = new Like(id, 1);
        return likeService.addLike(like, token);
    }

    @RequestMapping(value = "/like/comment",
            method = RequestMethod.POST,
            produces = {"application/json;charset=utf8"})
    @ResponseBody
    public Response addCommentLike(String id, @RequestParam(required = false) String token) {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("ADD_TEACHER_LIKE"));
        logger.info("Request--" + id + "_" + token);

        Like like = new Like(id, 7);
        return likeService.addLike(like, token);
    }

    @RequestMapping(value = "/like/token",
            method = RequestMethod.GET,
            produces = {"application/json;charset=utf8"})
    @ResponseBody
    public Response getToken() {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("GET_TOKEN"));
        logger.info("Request--");

        return likeService.getTokenResponse();
    }

}
