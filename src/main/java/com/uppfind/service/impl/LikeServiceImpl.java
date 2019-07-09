package com.uppfind.service.impl;

import com.uppfind.dao.mybatis.LikeMapper;
import com.uppfind.dao.mybatis.TeacherMapper;
import com.uppfind.dto.Response;
import com.uppfind.entity.Like;
import com.uppfind.service.LikeService;
import com.uppfind.util.jwt.JwtHelper;
import com.uppfind.util.jwt.TokenState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LAccordeur on 2017/7/18.
 */
@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeMapper likeMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    private Object lock = new Object();
    private Object lock1 = new Object();

    public Response queryLikeByTeacherId(String teacherId) {
        Response<Like> response = new Response<Like>();

        Like queryLike = new Like(teacherId, 1);
        Like like = likeMapper.queryLikeByTargetId(queryLike);

        if (like == null) {

            like = new Like(teacherId, 1, 0);
            likeMapper.addLike(like);

        }
        response.setData(like);
        response.setType("like");


        return response;
    }

    public Response addLike(Like like, String token) {

        //利用jwt验证token防止相同用户连续点赞
        if (token == null) {
            //用户第一次点赞或者后端不验证
            //防止多个线程同时更新
            synchronized (lock) {
                Like oldLike = likeMapper.queryLikeByTargetId(like);
                if (oldLike == null) {
                    //说明还没人给该对象点赞
                    like.setLikeCount(1);
                    likeMapper.addLike(like);
                } else {
                    like.setLikeCount(oldLike.getLikeCount());
                    likeMapper.updateLike(like);
                }
            }

            Response response = new Response();
            response.setCode(200);
            response.setMsg("点赞成功");
            return response;

        } else {
            //该用户已经点过赞了，判断其限制时间是否过期，若过期则可再点赞
            Map<String, Object> resultMap = JwtHelper.validToken(token);
            TokenState state = TokenState.getTokenState((String) resultMap.get("state"));

            switch (state) {
                case VALID:{
                    //说明限制点赞时间还没过期，则不允许点赞
                    Response response = new Response();
                    response.setType("token");
                    response.setData(null);
                    response.setMsg("时间限制未解除");
                    return response;
                }
                case EXPIRED:{
                    //说明限制点赞的时间已经过了，可以再点赞
                    //防止多个线程同时更新
                    synchronized (lock) {
                        Like oldLike = likeMapper.queryLikeByTargetId(like);
                        if (likeMapper.queryLikeByTargetId(like) == null) {
                            //说明还没人给该对象点赞
                            likeMapper.addLike(like);
                        } else {
                            like.setLikeCount(oldLike.getLikeCount());
                            likeMapper.updateLike(like);
                        }
                     }
                    //返回新的token
                    return getTokenResponse();

                }
                case INVALID:{
                    //无效的token
                    Response response = new Response();
                    response.setType("token");
                    response.setData(null);
                    response.setMsg("token无效");
                    return response;
                }
            }
        }

        return null;

    }

    public Response minusLike(Like like) {
        Response response = new Response();

        synchronized (lock1) {
            Like oldLike = likeMapper.queryLikeByTargetId(like);

            if (oldLike != null) {
                like.setLikeCount(oldLike.getLikeCount());
                if (likeMapper.minusLike(like) > 0) {
                    response.setCode(200);
                    response.setMsg("取消点赞成功");
                } else {
                    response.setCode(500);
                    response.setMsg("取消点赞失败");
                }
            } else {
                response.setCode(500);
                response.setMsg("取消点赞失败");
            }
        }

        return response;
    }

    public Response getTokenResponse() {
        Response response = new Response();
        Map<String, Object> payload = new HashMap<String, Object>();
        Date date = new Date();

        //payload.put("id", likeId); //点赞表id
        payload.put("iat", date.getTime()); //生成时间
        payload.put("ext", date.getTime() + 1000 * 20); //20s内不能再点赞
        String tokenStr = JwtHelper.createToken(payload);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("token", tokenStr);

        //返回数据
        response.setData(result);
        response.setType("token");
        return response;
    }


}
