package com.uppfind.util.user;

import com.uppfind.dto.Response;
import com.uppfind.util.UUIDUtil.UUIDUtils;

/**
 * Created by LAccordeur on 2017/8/30.
 * 用于生成user id标识点赞用户
 */
public class UserUtil {

    /**
     * 产生一个不含有‘-’的32为UUID小写字符串
     * @return
     */
    public static Response getUserToken() {
        Response response = new Response();
        response.setData(UUIDUtils.get32UUIDAsLowerCase());
        response.setType("userId");
        return response;
    }
}
