package com.uppfind.service.impl;

import com.uppfind.dao.ResearchFieldMapper;
import com.uppfind.dto.Response;
import com.uppfind.entity.ResearchField;
import com.uppfind.service.ResearchFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LAccordeur on 2017/7/10.
 */
@Service
public class ResearchFieldServiceImpl implements ResearchFieldService {

    @Autowired
    private ResearchFieldMapper researchFieldMapper;

    public Response queryMajorFieldList(String keyword) {

        Response<List<ResearchField>> response = new Response<List<ResearchField>>();
        //组装返回的Response对象
        List<ResearchField> researchFields = researchFieldMapper.queryMajorFieldList(keyword);
        response.setResult(researchFields);
        response.setTotal(researchFields.size());
        response.setCount(researchFields.size());
        response.setStart(0);

        return response;
    }
}
