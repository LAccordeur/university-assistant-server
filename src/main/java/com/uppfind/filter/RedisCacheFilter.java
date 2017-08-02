package com.uppfind.filter;

import com.uppfind.dao.redis.CacheRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by LAccordeur on 2017/8/1.
 * 用于检查在redis缓存中是否已经存在所要查询的信息,并且记录热度搜索的关键词
 */
@Component
public class RedisCacheFilter implements Filter {

    //不进行缓存的url
    private static String[] excludeUrls = new String[]{};


    @Autowired
    private CacheRedisDao cacheRedisDao;


    public void init(FilterConfig filterConfig) throws ServletException {


    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;


        String uri = request.getRequestURI();
        Map<String,String[]> params = request.getParameterMap();
        Set<String> paramKeys = params.keySet();
        Iterator iterator = paramKeys.iterator();

        //key值的拼接
        String[] keys = uri.split("/");
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && keys[i] != "" && keys[i] != " ") {
                key.append(keys[i]);
                key.append("_");

            }
        }

        for (int i = 0; i < params.size(); i++) {
            String[] value = params.get(iterator.next());
            if (value != null && value.length >= 1) {
                key.append(value[0]);
                key.append("_");
            }
        }
        key.replace(key.length()-1 ,key.length() ,"");
        key.replace(0, 1, "");


        //查看缓存中是否有数据
        String jsonResult = null;
        try {

            if ((key.toString()).indexOf("list") > 0) {

                if (params.get("keyword") != null) {
                    cacheRedisDao.updateHeatSearch(params.get("keyword")[0]);
                }
            }
            jsonResult = cacheRedisDao.getFromCache(key.toString());
        }catch (Exception e) {
            filterChain.doFilter(servletRequest, servletResponse);
        }

        if (jsonResult == null) {
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            output(jsonResult, response);
        }
    }

    public void destroy() {

    }

    public void output(String jsonStr, HttpServletResponse response) throws IOException {
        response.setContentType("text/json;charset=UTF-8;");
        response.setCharacterEncoding("UTF-8");
        ServletOutputStream out = response.getOutputStream();
        out.write(jsonStr.getBytes("UTF-8"));
        out.flush();
        out.close();
        //response.reset();
    }
}
