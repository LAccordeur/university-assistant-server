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
@RequestMapping
public class ResearchFieldController {

    @Autowired
    private ResearchFieldService researchFieldService;

    @RequestMapping(value = "/searchfield.php",
            method = RequestMethod.GET,
            produces = {"application/json;charset=utf8"})
    @ResponseBody
    public Response<List<School>> queryField(String mode,
                                             @RequestParam(required = false) String f,
                                             @RequestParam(required = false) String ps,
                                             @RequestParam(required = false) String cp) {

        if ("2".equals(mode) && f != null && ps != null && cp != null) {
            //返回分页信息
            return researchFieldService.queryMajorFieldPageList(f, cp, ps);
        } else if ("2".equals(mode) && f != null) {
            //根据关键词查询方向列表
            return researchFieldService.queryMajorFieldList(f);
        }
        return null;
    }
}
