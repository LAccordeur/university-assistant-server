package com.uppfind.service;

import com.uppfind.dto.Response;
import com.uppfind.entity.Comment;

/**
 * Created by LAccordeur on 2017/7/17.
 */
public interface CommentService {
    Response queryCommentByTeacherId(String teacherId);

    int addComment(String content, String userName, String id, String type);
}
