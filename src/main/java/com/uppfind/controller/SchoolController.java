package com.uppfind.controller;

import com.uppfind.dto.Response;
import com.uppfind.entity.School;
import com.uppfind.service.SchoolService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LAccordeur on 2017/6/2.
 * 学院信息查询相关的controller
 */
@Controller
@RequestMapping
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "/searchschool.php",
            method = RequestMethod.GET,
            produces = {"application/json;charset=utf8"})
    @ResponseBody
    public Response<List<School>> querySchool(String mode,
                                              @RequestParam(required = false) String l,
                                              @RequestParam(required = false) String u,
                                              @RequestParam(required = false) String s,
                                              @RequestParam(required = false) String sc,
                                              @RequestParam(required = false) String uc) {

        if ("1".equals(mode) && l != null && u != null) {
            //根据省份和学校名查询学院名集合
            return schoolService.querySchoolSet(l, u);

        } else if ("2".equals(mode) && s != null) {
            //根据关键词查询学院列表
            return schoolService.querySchoolList(s);

        } else if ("3".equals(mode) && sc != null) {
            //根据学院代码查询学院详细信息
            return schoolService.querySchoolInfo(sc);
        } else if ("2".equals(mode) && uc != null) {
            return schoolService.querySchoolListById(uc);
        }

        return null;
    }
}
