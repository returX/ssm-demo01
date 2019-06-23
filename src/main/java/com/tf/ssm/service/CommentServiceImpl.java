package com.tf.ssm.service;

import com.tf.ssm.entity.Comment;
import com.tf.ssm.mapper.CommentMapper;
import com.tf.ssm.service.impl.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper mapper;

    @Override
    public void insertComment(Comment comment) {
        mapper.insertSelective(comment);
    }

    @Override
    public List<Comment> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public void deleteByPrimaryKey(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }
}
