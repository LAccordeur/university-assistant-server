package com.uppfind.controller;

import com.uppfind.dto.Response;
import com.uppfind.entity.School;
import com.uppfind.service.MasterMajorService;
import com.uppfind.service.PhdMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by LAccordeur on 2017/6/2.
 * 专业信息查询相关的controller
 */
@Controller
@RequestMapping(value = "/major", produces = {"application/json;charset=utf8"})
public class MajorController {

    @Autowired
    private PhdMajorService phdMajorService;

    @Autowired
    private MasterMajorService masterMajorService;


    @RequestMapping(value = "/phd/set",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryPhdMajorSet(String locationName, String universityName, String schoolName) {
        return phdMajorService.queryPhdMajorSet(locationName, universityName, schoolName);
    }

    @RequestMapping(value = "/phd/list",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryPhdMajorList(String keyword,
                                      @RequestParam(required = false) String currentPage,
                                      @RequestParam(required = false) String pageSize) {
        if (keyword != null && currentPage != null && pageSize != null) {
            return phdMajorService.queryPhdMajorPageList(keyword, currentPage, pageSize);
        } else {
            return phdMajorService.queryPhdMajorList(keyword);
        }
    }

    @RequestMapping(value = "/phd/info",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryPhdMajorInfo(String schoolId, String majorId) {
        return phdMajorService.queryPhdMajorInfo(schoolId, majorId);
    }

    @RequestMapping(value = "/master/set",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryMasterMajorSet(String locationName, String universityName, String schoolName) {
        return phdMajorService.queryPhdMajorSet(locationName, universityName, schoolName);
    }

    @RequestMapping(value = "/master/list",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryMasterMajorList(String keyword,
                                      @RequestParam(required = false) String currentPage,
                                      @RequestParam(required = false) String pageSize) {
        if (keyword != null && currentPage != null && pageSize != null) {
            return phdMajorService.queryPhdMajorPageList(keyword, currentPage, pageSize);
        } else {
            return phdMajorService.queryPhdMajorList(keyword);
        }
    }

    @RequestMapping(value = "/master/info",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryMasterMajorInfo(String schoolId, String majorId) {
        return phdMajorService.queryPhdMajorInfo(schoolId, majorId);
    }


}
