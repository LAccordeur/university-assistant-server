package com.uppfind.controller;

import com.uppfind.dto.Response;
import com.uppfind.entity.School;
import com.uppfind.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by LAccordeur on 2017/6/2.
 * 老师信息查询的相关controller
 */
@Controller
@RequestMapping(value = "/teacher", produces = {"application/json;charset=utf8"})
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/set",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryTeacherSet(String locationName, String universityName, String schoolName) {
        return teacherService.queryTeacherSet(locationName, universityName, schoolName);
    }

    @RequestMapping(value = "/list",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryTeacherList(@RequestParam(required = false) String keyword,
                                    @RequestParam(required = false) String currentPage,
                                    @RequestParam(required = false) String pageSize,
                                    @RequestParam(required = false) String id) {

        if (keyword != null && currentPage != null && pageSize != null) {
            return teacherService.queryTeacherPageList(keyword, currentPage, pageSize);
        } else if (keyword != null) {
            return teacherService.queryTeacherList(keyword);
        } else if (id != null) {
            return teacherService.queryTeacherListById(id);
        }
        return null;
    }

    @RequestMapping(value = "/info",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryTeacherInfo(String id) {
        return teacherService.queryTeacherInfo(id);
    }

}
