package com.tf.ssm.service;

import com.tf.ssm.entity.User;
import com.tf.ssm.mapper.UserMapper;
import com.tf.ssm.service.impl.UserService;
import com.tf.ssm.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;


    /**
     * 添加用户
     */
    @Override
    public void addUser(User user) {
        mapper.addUser(user);
    }

    /**
     * 根据id查询用户
     */
    @Override
    public User findUserById(int uid) {
        return mapper.findUserById(uid);
    }

    /**
     * 根据用户名模糊查询用户
     */
    @Override
    public List<User> findUserListByName(String username) {
        username = "%"+username+"%";
        List<User> users;
        users = mapper.findUserListByName(username);
        return users;
    }

    /**
     * 检查用户是否存在
     */
    @Override
    public boolean checkUser(User user) {
        int count = mapper.selectCount(user);
        if (count == 1){
            return true;
        }
        return false;
    }

    /**
     * 根据用户名查询用户
     */
    @Override
    public User findUserByName(String username) {
        return mapper.findUserByName(username);
    }

    @Override
    public void updateUser(UserVo userVo) {
        mapper.updateUser(userVo);
    }
}
