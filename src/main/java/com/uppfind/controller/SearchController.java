package com.uppfind.controller;

import com.uppfind.dto.Response;
import com.uppfind.service.SearchService;
import com.uppfind.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by LAccordeur on 2017/7/12.
 */
@Controller
@RequestMapping
public class SearchController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/searchall.php",
            method = RequestMethod.GET,
            produces = {"application/json;charset=utf8"})
    @ResponseBody
    Response<List<Response<Object>>> queryAll(String keyword) {

        return searchService.queryAllList(keyword);
    }
}
