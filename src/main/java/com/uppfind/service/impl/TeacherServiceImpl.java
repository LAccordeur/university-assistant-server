package com.uppfind.service.impl;

import com.uppfind.dao.TeacherMapper;
import com.uppfind.dto.Response;
import com.uppfind.entity.Teacher;
import com.uppfind.service.TeacherService;
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
        response.setResult(teachers);
        response.setTotal(teachers.size());

        return response;
    }

    public Response queryTeacherList(String keyword) {
        Response<List<Teacher>> response = new Response<List<Teacher>>();
        //组装返回的Response对象
        List<Teacher> teachers = teacherMapper.queryTeacherList(keyword);
        response.setResult(teachers);
        response.setTotal(teachers.size());
        response.setCount(teachers.size());
        response.setStart(0);

        return response;
    }

    public Response queryTeacherListById(String schoolCode) {
        Response<List<Teacher>> response = new Response<List<Teacher>>();
        //组装返回的Response对象
        List<Teacher> teachers = teacherMapper.queryTeacherListById(schoolCode);
        response.setResult(teachers);
        response.setTotal(teachers.size());
        response.setCount(teachers.size());
        response.setStart(0);

        return response;
    }

    public Response queryTeacherInfo(String teacherCode) {
        Response<List<Teacher>> response = new Response<List<Teacher>>();
        //组装返回的Response对象
        List<Teacher> teacher = teacherMapper.queryTeacherInfo(Long.parseLong(teacherCode));
        response.setResult(teacher);
        response.setTotal(teacher.size());

        return response;
    }
}
