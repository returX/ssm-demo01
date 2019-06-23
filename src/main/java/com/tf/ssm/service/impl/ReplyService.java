package com.tf.ssm.service.impl;

import com.tf.ssm.entity.Reply;

import java.util.List;

public interface ReplyService {
    void insertComment(Reply reply);

    List<Reply> selectAll();

    void deleteByPrimaryKey(Integer id);
}
