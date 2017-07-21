package com.uppfind.util.assembler;

import com.uppfind.dto.CommentDTO;
import com.uppfind.entity.Comment;
import org.springframework.beans.BeanUtils;

/**
 * Created by LAccordeur on 2017/7/21.
 */
public class CommentAssembler {
    public static Comment toEntity(CommentDTO commentDTO) {
        Comment entity = new Comment(commentDTO.getId(), commentDTO.getType(),commentDTO.getContent(),"");
        return entity;
    }

}
