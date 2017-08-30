package com.uppfind.service.impl;

import com.uppfind.dao.mybatis.TeacherMapper;
import com.uppfind.dto.Response;
import com.uppfind.entity.Teacher;
import com.uppfind.service.TeacherService;
import com.uppfind.util.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LAccordeur on 2017/6/2.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    public Response queryTeacherSet(String province, String university, String school) {

        Response<List<Teacher>> response = new Response<List<Teacher>>();
        //组装返回的Response对象
        List<Teacher> teachers = teacherMapper.queryTeacherSet(province, university, school);
        response.setData(teachers);
        response.setCount(teachers.size());
        response.setType("teacher");

        return response;
    }

    public Response queryTeacherList(String keyword) {
        Response<List<Teacher>> response = new Response<List<Teacher>>();
        //组装返回的Response对象
        List<Teacher> teachers = teacherMapper.queryTeacherList(keyword);
        response.setData(teachers);
        response.setCount(teachers.size());
        response.setType("teacher");

        return response;
    }

    public Response queryTeacherListById(String schoolCode) {
        Response<List<Teacher>> response = new Response<List<Teacher>>();
        //组装返回的Response对象
        List<Teacher> teachers = teacherMapper.queryTeacherListById(schoolCode);
        response.setData(teachers);
        response.setCount(teachers.size());
        response.setType("teacher");

        return response;
    }

    public Response queryTeacherListByPhdMajorId(String majorCode) {
        Response<List<Teacher>> response = new Response<List<Teacher>>();
        //组装返回的Response对象
        List<Teacher> teachers = teacherMapper.queryTeacherListByPhdMajorId(majorCode);
        response.setData(teachers);
        response.setCount(teachers.size());
        response.setType("teacher");

        return response;
    }

    public Response queryTeacherListByMasterMajorId(String majorCode) {
        Response<List<Teacher>> response = new Response<List<Teacher>>();
        //组装返回的Response对象
        List<Teacher> teachers = teacherMapper.queryTeacherListByMasterMajorId(majorCode);
        response.setData(teachers);
        response.setCount(teachers.size());
        response.setType("teacher");

        return response;
    }

    public Response queryTeacherPageList(String keyword, String currentPage, String pageSize) {
        Response<Page<Teacher>> response = new Response<Page<Teacher>>();

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


        Page<Teacher> pageData = null;
        List<Teacher> teachers = null;


        teachers = teacherMapper.queryTeacherPageList(keyword, offset, rows);
        int resultCount = teacherMapper.queryTeacherCount(keyword);
        if (teachers != null && teachers.size() > 0) {
            pageData = new Page<Teacher>(pageSizeInt, currentPageInt, teachers.size(), teachers);
            response.setData(pageData);
            response.setCount(resultCount);
            response.setType("teacher");
        } else {
            response.setData(null);
            response.setCount(0);
            response.setType("teacher");
        }

        return response;
    }

    public Response queryTeacherPageListById(String schoolCode, String currentPage, String pageSize) {
        Response<Page<Teacher>> response = new Response<Page<Teacher>>();

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


        Page<Teacher> pageData = null;
        List<Teacher> teachers = null;


        teachers = teacherMapper.queryTeacherPageListById(schoolCode, offset, rows);
        int resultCount = teacherMapper.queryTeacherCountById(schoolCode);
        if (teachers != null && teachers.size() > 0) {
            pageData = new Page<Teacher>(pageSizeInt, currentPageInt, teachers.size(), teachers);
            response.setData(pageData);
            response.setCount(resultCount);
            response.setType("teacher");
        } else {
            response.setData(null);
            response.setCount(0);
            response.setType("teacher");
        }

        return response;
    }

    public Response queryTeacherPageListByPhdMajorId(String majorCode, String currentPage, String pageSize) {
        Response<Page<Teacher>> response = new Response<Page<Teacher>>();

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


        Page<Teacher> pageData = null;
        List<Teacher> teachers = null;


        teachers = teacherMapper.queryTeacherPageListByPhdMajorId(majorCode, offset, rows);
        int resultCount = teacherMapper.queryTeacherCountByPhdMajorId(majorCode);
        if (teachers != null && teachers.size() > 0) {
            pageData = new Page<Teacher>(pageSizeInt, currentPageInt, teachers.size(), teachers);
            response.setData(pageData);
            response.setCount(resultCount);
            response.setType("teacher");
        } else {
            response.setData(null);
            response.setCount(0);
            response.setType("teacher");
        }

        return response;
    }

    public Response queryTeacherPageListByMasterMajorId(String majorCode, String currentPage, String pageSize) {
        Response<Page<Teacher>> response = new Response<Page<Teacher>>();

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


        Page<Teacher> pageData = null;
        List<Teacher> teachers = null;


        teachers = teacherMapper.queryTeacherPageListByMasterMajorId(majorCode, offset, rows);
        int resultCount = teacherMapper.queryTeacherCountByMasterMajorId(majorCode);
        if (teachers != null && teachers.size() > 0) {
            pageData = new Page<Teacher>(pageSizeInt, currentPageInt, teachers.size(), teachers);
            response.setData(pageData);
            response.setCount(resultCount);
            response.setType("teacher");
        } else {
            response.setData(null);
            response.setCount(0);
            response.setType("teacher");
        }

        return response;
    }

    public Response queryTeacherInfo(String teacherCode) {
        Response<List<Teacher>> response = new Response<List<Teacher>>();
        //组装返回的Response对象
        List<Teacher> teacher = teacherMapper.queryTeacherInfo(Long.parseLong(teacherCode));
        response.setData(teacher);
        response.setCount(teacher.size());
        response.setType("teacher");

        return response;
    }


    private Response getResponse(Response<List<Teacher>> response, List<Teacher> teachers, String type) {

        if (teachers != null) {
            response.setData(teachers);
            response.setCount(teachers.size());
            response.setType(type);
        } else {
            response.setData(null);
            response.setCount(0);
            response.setType(type);
        }

        return response;
    }

}
