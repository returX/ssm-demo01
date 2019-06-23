package com.tf.ssm.service;

import com.tf.ssm.entity.Reply;
import com.tf.ssm.mapper.ReplyMapper;
import com.tf.ssm.service.impl.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyMapper mapper;

    @Override
    public void insertComment(Reply reply) {
        mapper.insertSelective(reply);
    }

    @Override
    public List<Reply> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public void deleteByPrimaryKey(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }
}
