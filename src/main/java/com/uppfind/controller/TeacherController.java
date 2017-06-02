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
            return teacherService.queryTeacherSet(l, u, s);
        } else if ("2".equals(mode) && n != null) {
            return teacherService.queryTeacherList(n);
        } else if ("3".equals(mode) && nc != null) {
            return teacherService.queryTeacherInfo(nc);
        }

        return null;
    }

}
