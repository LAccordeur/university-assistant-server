package com.uppfind.service.impl;

import com.uppfind.dao.*;
import com.uppfind.dto.Response;
import com.uppfind.entity.School;
import com.uppfind.entity.University;
import com.uppfind.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAccordeur on 2017/7/12.
 * 搜索所有与关键词相关的信息
 */
@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    private PhdMajorService phdMajorService;
    @Autowired
    private MasterMajorService masterMajorService;
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private UniversityService universityService;
    @Autowired
    private ResearchFieldService researchFieldService;
    @Autowired
    private TeacherService teacherService;


    public Response queryAllList(String keyword) {

        Response<List<Response<Object>>> response = new Response<List<Response<Object>>>();
        List<Response<Object>> list = new ArrayList<Response<Object>>();


        list.add(universityService.queryUniversityList(keyword));
        list.add(schoolService.querySchoolList(keyword));
        list.add(teacherService.queryTeacherList(keyword));
        list.add(masterMajorService.queryMasterMajorList(keyword));
        list.add(phdMajorService.queryPhdMajorList(keyword));
        list.add(researchFieldService.queryMajorFieldList(keyword));


        response.setResult(list);
        response.setCount(list.size());
        response.setTotal(list.size());
        response.setStart(0);

        return response;
    }
}
