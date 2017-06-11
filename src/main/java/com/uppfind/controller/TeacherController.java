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
@RequestMapping
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/queryTeacher.do",
            method = RequestMethod.GET,
            produces = {"application/json;charset=utf8"})
    @ResponseBody
    public Response<List<School>> queryTeacher(String mode,
                                               @RequestParam(required = false) String l,
                                               @RequestParam(required = false) String u,
                                               @RequestParam(required = false) String s,
                                               @RequestParam(required = false) String n,
                                               @RequestParam(required = false) String nc) {

        if ("1".equals(mode) && l != null && u != null && s!= null) {
            //根据省份、学校名、学院名查询该学院下的老师集合
            return teacherService.queryTeacherSet(l, u, s);

        } else if ("2".equals(mode) && n != null) {
            //根据关键词查询老师列表
            return teacherService.queryTeacherList(n);

        } else if ("3".equals(mode) && nc != null) {
            //根据老师代码查询详细信息
            return teacherService.queryTeacherInfo(nc);
        }

        return null;
    }

}
