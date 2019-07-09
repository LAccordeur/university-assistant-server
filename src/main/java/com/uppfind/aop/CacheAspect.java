package com.uppfind.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uppfind.dao.redis.CacheRedisDao;
import com.uppfind.dto.Response;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

/**
 * Created by LAccordeur on 2017/8/1.
 */

@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class CacheAspect {

    @Autowired
    private CacheRedisDao cacheRedisDao;

    @Pointcut("execution(* com.uppfind.service.*.*(..))")
    public void aspect() {}


    /*@Before("aspect()")
    public void before(JoinPoint point) {
        String method = point.getSignature().getName();
        Object[] args = point.getArgs();

        if (method.startsWith("query") && method.endsWith("List")) {
            cacheRedisDao.updateHeatSearch((String) args[0]);
        }
    }*/


    /**
     * 将返回的Response对象放入缓存中
     * @param point
     * @param result
     */
    @AfterReturning(value = "aspect()", returning = "result")
    public void afterReturn(JoinPoint point, Object result) {
        String method = point.getSignature().getName();
        Object[] args = point.getArgs();
        Response response = (Response) result;


        StringBuilder key = new StringBuilder();
        if (method.startsWith("query") && (method.endsWith("Info") || method.endsWith("List")) && result != null) {

            if (method.endsWith("Info")) {
                int index = method.indexOf("Info");
                key.append(method.substring(5,index)).append("_").append("info").append("_").append((String)args[0]);
            } else {
                int index;
                if (method.indexOf("PageList") == -1) {
                    index = method.indexOf("List");
                } else {
                    index = method.indexOf("PageList");
                }
                key.append(method.substring(5,index)).append("_").append("list");
                for (int i = 0; i < args.length; i++) {
                    key.append("_");
                    key.append((String)args[i]);
                }
            }
            try {
                cacheRedisDao.saveToCache(response, (key.toString()).toLowerCase());
            } catch (Exception e) {
                return;
            }
        }
    }
}
