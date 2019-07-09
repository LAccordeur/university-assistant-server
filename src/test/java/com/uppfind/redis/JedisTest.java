package com.uppfind.redis;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by LAccordeur on 2017/7/30.
 */
public class JedisTest {

    private final static String key = "HEAT_SEARCH";

    @Test
    public void demo() {
        /*Jedis jedis = new Jedis("119.29.215.249",6379);

        jedis.set("name", "test");
        String value = jedis.get("name");
        System.out.println(value);
        jedis.close();*/

        System.out.println(key.toLowerCase());
    }
}
