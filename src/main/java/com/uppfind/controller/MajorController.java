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
@RequestMapping
public class MajorController {

    @Autowired
    private PhdMajorService phdMajorService;

    @Autowired
    private MasterMajorService masterMajorService;


    @RequestMapping(value = "/searchmajor.php",
            method = RequestMethod.GET,
            produces = {"application/json;charset=utf8"})
    @ResponseBody
    public Response<List<School>> queryMajor(String mode,
                                               String coin,
                                               @RequestParam(required = false) String l,
                                               @RequestParam(required = false) String u,
                                               @RequestParam(required = false) String s,
                                               @RequestParam(required = false) String sc,
                                               @RequestParam(required = false) String p,
                                               @RequestParam(required = false) String pc,
                                               @RequestParam(required = false) String m,
                                               @RequestParam(required = false) String mc,
                                               @RequestParam(required = false) String f) {

        if ("1".equals(coin)) {
            //硕士专业信息查询
            if ("1".equals(mode) && l != null && u != null && s != null) {
                //根据省份、学校名、学院名查询专业集合
                return masterMajorService.queryMasterMajorSet(l, u, s);

            } else if ("2".equals(mode) && m != null) {
                //根据关键词查询专业列表
                return masterMajorService.queryMasterMajorList(m);

            } else if ("3".equals(mode) && sc != null && mc != null) {
                //根据学院代码和专业代码查详情
                return masterMajorService.queryMasterMajorInfo(sc, mc);
            }

        } else if ("2".equals(coin)) {
            //博士专业信息查询
            if ("1".equals(mode) && l != null && u != null && s != null) {
                //根据省份、学校名、学院名查询专业集合
                return phdMajorService.queryPhdMajorSet(l, u, s);

            } else if ("2".equals(mode) && p != null) {
                //根据关键词查询专业列表
                return phdMajorService.queryPhdMajorList(p);

            } else if ("3".equals(mode) && sc != null && pc != null) {
                //根据学院代码和专业代码查详情
                return masterMajorService.queryMasterMajorInfo(sc, pc);
            }
        }


        return null;
    }




}
