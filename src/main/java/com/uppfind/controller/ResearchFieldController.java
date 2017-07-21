package com.uppfind.controller;

import com.uppfind.dto.Response;
import com.uppfind.entity.School;
import com.uppfind.service.ResearchFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by LAccordeur on 2017/7/10.
 */
@Controller
@RequestMapping(value = "/field", produces = {"application/json;charset=utf8"})
public class ResearchFieldController {

    @Autowired
    private ResearchFieldService researchFieldService;

    @RequestMapping(value = "/list",
            method = RequestMethod.GET)
    @ResponseBody
    public Response<List<School>> queryField(String keyword,
                                             @RequestParam(required = false) String currentPage,
                                             @RequestParam(required = false) String pageSize) {

        if (keyword != null && currentPage != null && pageSize != null) {
            return researchFieldService.queryMajorFieldPageList(keyword, currentPage, pageSize);
        } else {
            return researchFieldService.queryMajorFieldList(keyword);
        }
    }
}
