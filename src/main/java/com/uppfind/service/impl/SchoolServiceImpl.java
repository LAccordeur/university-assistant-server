package com.uppfind.service.impl;

import com.uppfind.dao.mybatis.SchoolMapper;
import com.uppfind.dto.Response;
import com.uppfind.entity.School;
import com.uppfind.service.SchoolService;
import com.uppfind.util.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LAccordeur on 2017/6/2.
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

    public Response querySchoolSet(String province, String university) {

        Response<List<School>> response = new Response<List<School>>();
        //组装返回的Response对象
        List<School> schools = schoolMapper.querySchoolSet(province, university);
        response.setData(schools);
        response.setCount(schools.size());
        response.setType("school");

        return response;
    }

    public Response querySchoolList(String keyword) {

        Response<List<School>> response = new Response<List<School>>();
        //组装返回的Response对象
        List<School> schools = schoolMapper.querySchoolList(keyword);
        response.setData(schools);
        response.setCount(schools.size());
        response.setType("school");

        return response;
    }

    public Response querySchoolInfo(String schoolCode) {

        Response<List<School>> response = new Response<List<School>>();
        //组装返回的Response对象
        List<School> school = schoolMapper.querySchoolInfo(Long.parseLong(schoolCode));
        response.setData(school);
        response.setCount(school.size());
        response.setType("school");

        return response;
    }

    public Response querySchoolListById(String universityCode) {
        Response<List<School>> response = new Response<List<School>>();
        //组装返回的Response对象
        List<School> schools = schoolMapper.querySchoolListById(universityCode);
        response.setData(schools);
        response.setCount(schools.size());
        response.setType("school");

        return response;
    }

    public Response querySchoolPageList(String keyword, String currentPage, String pageSize) {
        Response<Page<School>> response = new Response<Page<School>>();

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


        Page<School> pageData = null;
        List<School> schools = null;


        schools = schoolMapper.querySchoolPageList(keyword, offset, rows);
        if (schools != null && schools.size() > 0) {
            pageData = new Page<School>(pageSizeInt, currentPageInt, schools.size(), schools);
            response.setData(pageData);
            response.setCount(schools.size());
            response.setType("school");

        }

        return response;
    }
}
