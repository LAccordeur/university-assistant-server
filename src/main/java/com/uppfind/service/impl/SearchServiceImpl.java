package com.uppfind.service.impl;

import com.uppfind.dao.redis.CacheRedisDao;
import com.uppfind.dto.Response;
import com.uppfind.entity.School;
import com.uppfind.entity.Teacher;
import com.uppfind.entity.University;
import com.uppfind.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
    @Autowired
    private CacheRedisDao cacheRedisDao;

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public Response queryAllList(String keyword) {

        Response<List<Response<Object>>> response = new Response<List<Response<Object>>>();
        List<Response<Object>> list = new ArrayList<Response<Object>>();



        list.add(universityService.queryUniversityList(keyword));
        list.add(schoolService.querySchoolList(keyword));
        list.add(teacherService.queryTeacherList(keyword));
        list.add(masterMajorService.queryMasterMajorList(keyword));
        list.add(phdMajorService.queryPhdMajorList(keyword));
        list.add(researchFieldService.queryMajorFieldList(keyword));


        response.setData(list);
        response.setCount(list.size());

        return response;
    }

    public Response queryAllListByThread(String keyword) {
        Response<List<Response<Object>>> response = new Response<List<Response<Object>>>();
        List<Response<Object>> list = new CopyOnWriteArrayList<Response<Object>>();
        response.setData(list);

        QueryTask task1 = new QueryTask(response, keyword, universityService);
        QueryTask task2 = new QueryTask(response, keyword, schoolService);
        QueryTask task3 = new QueryTask(response, keyword, teacherService);
        QueryTask task4 = new QueryTask(response, keyword, masterMajorService);
        QueryTask task5 = new QueryTask(response, keyword, phdMajorService);
        QueryTask task6 = new QueryTask(response, keyword, researchFieldService);
        Future future1 = executorService.submit(task1);
        Future future2 = executorService.submit(task2);
        Future future3 = executorService.submit(task3);
        Future future4 = executorService.submit(task4);
        Future future5 = executorService.submit(task5);
        Future future6 = executorService.submit(task6);

        Boolean flag = true;
        while (flag) {
            if (future1.isDone() && future2.isDone() && future3.isDone() && future4.isDone() && future5.isDone() && future6.isDone()) {
                response.setCount(list.size());
                break;
            } else {
                continue;
            }
        }


        return response;
    }

    private class QueryTask implements Runnable {

        private Response<List<Response<Object>>> response;
        private String keyword;

        private UniversityService universityService = null;
        private SchoolService schoolService = null;
        private TeacherService teacherService = null;
        private MasterMajorService masterMajorService = null;
        private PhdMajorService phdMajorService = null;
        private ResearchFieldService researchFieldService = null;

        public QueryTask(Response response, String keyword, UniversityService service) {
            this.response = response;
            this.universityService = service;
            this.keyword = keyword;
        }

        public QueryTask(Response response, String keyword, SchoolService service) {
            this.response = response;
            this.schoolService = service;
            this.keyword = keyword;
        }

        public QueryTask(Response response, String keyword, TeacherService service) {
            this.response = response;
            this.teacherService = service;
            this.keyword = keyword;
        }

        public QueryTask(Response response, String keyword, MasterMajorService service) {
            this.response = response;
            this.masterMajorService = service;
            this.keyword = keyword;
        }

        public QueryTask(Response response, String keyword, PhdMajorService service) {
            this.response = response;
            this.phdMajorService= service;
            this.keyword = keyword;
        }

        public QueryTask(Response response, String keyword, ResearchFieldService service) {
            this.response = response;
            this.researchFieldService= service;
            this.keyword = keyword;
        }

        public void run() {
            if (universityService != null) {
                response.getData().add(universityService.queryUniversityPageList(keyword, "1", "5"));
            }

            if (schoolService != null) {
                response.getData().add(schoolService.querySchoolPageList(keyword, "1", "5"));
            }

            if (teacherService != null) {
                response.getData().add(teacherService.queryTeacherPageList(keyword, "1", "5"));
            }

            if (masterMajorService != null) {
                response.getData().add(masterMajorService.queryMasterMajorPageList(keyword, "1", "5"));
            }

            if (phdMajorService != null) {
                response.getData().add(phdMajorService.queryPhdMajorPageList(keyword, "1", "5"));
            }

            if (researchFieldService != null) {
                response.getData().add(researchFieldService.queryMajorFieldPageList(keyword, "1", "5"));
            }
        }
    }

    public Response queryAllPageList(String keyword, String currentPage, String pageSize) {

        Response<List<Response<Object>>> response = new Response<List<Response<Object>>>();
        List<Response<Object>> list = new ArrayList<Response<Object>>();

        list.add(universityService.queryUniversityPageList(keyword, currentPage, pageSize));
        list.add(schoolService.querySchoolPageList(keyword, currentPage, pageSize));
        list.add(teacherService.queryTeacherPageList(keyword, currentPage, pageSize));
        list.add(masterMajorService.queryMasterMajorPageList(keyword, currentPage, pageSize));
        list.add(phdMajorService.queryPhdMajorPageList(keyword, currentPage, pageSize));
        list.add(researchFieldService.queryMajorFieldPageList(keyword, currentPage, pageSize));

        response.setData(list);
        response.setCount(list.size());

        return response;
    }

    public Response getHeatSearch() {
        Response response = new Response();
        response.setData(cacheRedisDao.getHeatSearch());
        response.setType("heatSearch");
        response.setCount(cacheRedisDao.getHeatSearch().size());
        return response;
    }
}
