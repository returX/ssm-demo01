package com.tf.ssm.service.impl;

import com.tf.ssm.entity.Comment;

import java.util.List;

public interface CommentService {

    void insertComment(Comment comment);

    List<Comment> selectAll();

    void deleteByPrimaryKey(Integer id);
}
