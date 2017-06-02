package com.uppfind.controller;

import com.uppfind.dto.Response;
import com.uppfind.entity.University;
import com.uppfind.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by LAccordeur on 2017/5/31.
 */
@Controller
@RequestMapping
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @RequestMapping(value = "/queryProvince.do",
                    method = RequestMethod.GET,
                    produces = {"application/json;charset=utf8"})
    @ResponseBody
    public Response<List<University>> queryProvinceSet() {
        return universityService.queryProvinceSet();
    }


    @RequestMapping(value = "/queryUniversity.do",
                    method = RequestMethod.GET,
                    produces = {"application/json;charset=utf8"})
    @ResponseBody
    public Response<List<University>> queryUniversityList(String mode, String u) {


        if ("2".equals(mode)) {
            return universityService.queryUniversityList(u);
        }
        return null;
    }

}
