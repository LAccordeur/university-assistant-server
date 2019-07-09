package com.uppfind.dao.mybatis;

import com.uppfind.entity.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by LAccordeur on 2017/8/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CommentMapperTest {

    @Resource
    private CommentMapper commentMapper;

    @Test
    public void queryCommentByTargetId() throws Exception {
        Comment comment = new Comment();
        comment.setUserId("test");
        comment.setTargetId("1061400011157");
        comment.setTargetType(1);
        System.out.println(commentMapper.queryCommentByTargetId(comment));
    }

}