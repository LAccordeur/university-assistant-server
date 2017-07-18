package com.uppfind.controller;

import com.uppfind.dto.Response;
import com.uppfind.service.LikeService;
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
public class LikeController {

    @Autowired
    private LikeService likeService;

    @RequestMapping(value = "/like/teacher/query",
            method = RequestMethod.GET,
            produces = {"application/json;charset=utf8"})
    @ResponseBody
    public Response queryLikeByTeacherId(String id) {
        return likeService.queryLikeByTeacherId(id);
    }

    @RequestMapping(value = "/like/teacher/add",
            method = RequestMethod.POST,
            produces = {"application/json;charset=utf8"})
    @ResponseBody
    public Response addLike(String id, @RequestParam(required = false) String token) {
        return likeService.addLike(id, token);
    }
}
