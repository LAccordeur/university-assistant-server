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
    public Response<List<University>> queryUniversityList(String mode,
                                                          @RequestParam(required = false) String u,
                                                          @RequestParam(required = false) String uc,
                                                          @RequestParam(required = false) String l) {


        if ("2".equals(mode) && u != null) {
            return universityService.queryUniversityList(u);
        } else if ("3".equals(mode) && uc != null) {
            return universityService.queryUniversityInfo(uc);
        } else if ("1".equals(mode) && l != null) {
            return universityService.queryUniversitySet(l);
        }
        return null;
    }

}
