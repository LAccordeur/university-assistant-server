package com.uppfind.controller;

import com.uppfind.dto.Response;
import com.uppfind.entity.University;
import com.uppfind.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by LAccordeur on 2017/5/31.
 * 学校信息查询相关的controller
 */
@Controller
@RequestMapping
public class UniversityController {

    @Autowired
    private UniversityService universityService;



    @RequestMapping(value = "/searchlocation.php",
                    method = RequestMethod.GET,
                    produces = {"application/json;charset=utf8"})
    @ResponseBody
    public Response<List<University>> queryProvinceSet() {
        return universityService.queryProvinceSet();
    }



    @RequestMapping(value = "/searchuniversity.php",
                    method = RequestMethod.GET,
                    produces = {"application/json;charset=utf8"})
    @ResponseBody
    public Response<List<University>> queryUniversityList(String mode,
                                                          @RequestParam(required = false) String u,
                                                          @RequestParam(required = false) String uc,
                                                          @RequestParam(required = false) String l,
                                                          @RequestParam(required = false) String ps,
                                                          @RequestParam(required = false) String cp) {

        if ("2".equals(mode) && u != null && ps != null && cp != null) {
            //返回分页信息
            return universityService.queryUniversityPageList(u, cp, ps);
        } else if ("2".equals(mode) && u != null) {
            //根据关键词查询学校列表
            return universityService.queryUniversityList(u);

        } else if ("3".equals(mode) && uc != null) {
            //根据学校代码查询详情
            return universityService.queryUniversityInfo(uc);

        } else if ("1".equals(mode) && l != null) {
            //根据省份查询学校名集合
            return universityService.queryUniversitySet(l);
        }
        return null;
    }

}
