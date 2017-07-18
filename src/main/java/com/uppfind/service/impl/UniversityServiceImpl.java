package com.uppfind.service.impl;

import com.uppfind.dao.UniversityMapper;
import com.uppfind.dto.Response;
import com.uppfind.entity.University;
import com.uppfind.service.UniversityService;
import com.uppfind.util.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by LAccordeur on 2017/5/31.
 */
@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityMapper universityMapper;

    public Response queryProvinceSet() {

        Response<List<University>> response = new Response<List<University>>();
        //组装返回的Response对象
        List<University> universities = universityMapper.queryProvinceSet();
        response.setResult(universities);
        response.setTotal(universities.size());
        response.setType("province");

        return response;
    }

    public Response queryUniversityList(String keyword) {

        Response<List<University>> response = new Response<List<University>>();
        //组装返回的Response对象
        List<University> universities = universityMapper.queryUniversityList(keyword);
        response.setResult(universities);
        response.setTotal(universities.size());
        response.setStart(0);
        response.setCount(universities.size());
        response.setType("university");

        return response;
    }

    public Response queryUniversitySet(String province) {

        Response<List<University>> response = new Response<List<University>>();
        //组装返回的Response对象
        List<University> universities = universityMapper.queryUniversitySet(province);
        response.setResult(universities);
        response.setTotal(universities.size());
        response.setType("university");

        return response;
    }

    public Response queryUniversityInfo(String universityCode) {

        Response<List<University>> response = new Response<List<University>>();
        //组装返回的Response对象
        List<University> university = universityMapper.queryUniversityInfo(Integer.parseInt(universityCode));
        response.setResult(university);
        response.setTotal(university.size());
        response.setType("university");
        return response;
    }

    public Response queryUniversityPageList(String keyword, String currentPage, String pageSize) {
        Response<Page<University>> response = new Response<Page<University>>();

        int currentPageInt = Integer.valueOf(currentPage);
        int pageSizeInt = Integer.valueOf(pageSize);

        //当前页的下限检验
        if (currentPageInt < 1) {
            currentPageInt = 1;
        }
        if (pageSizeInt < 1) {
            pageSizeInt = 10;
        }

        //计算分页信息
        int offset = Page.getStart(currentPageInt, pageSizeInt);
        int rows = pageSizeInt;


        Page<University> pageData = null;
        List<University> universities = null;


        universities= universityMapper.queryUniversityPageList(keyword, offset, rows);
        if (universities != null && universities.size() > 0) {
            pageData = new Page<University>(universities.size(), currentPageInt, universities);
            response.setResult(pageData);
            response.setStart(0);
            response.setTotal(universities.size());
            response.setCount(universities.size());
            response.setType("university");
        }

        return response;
    }
}
