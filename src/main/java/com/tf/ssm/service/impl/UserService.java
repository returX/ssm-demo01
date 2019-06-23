package com.tf.ssm.service.impl;


import com.tf.ssm.entity.User;
import com.tf.ssm.vo.UserVo;

import java.util.List;

public interface UserService {

    public void addUser(User user);

    public User findUserById(int uid);

    public List<User> findUserListByName(String username);

    public boolean checkUser(User user);

    public User findUserByName(String username);

    public void updateUser(UserVo userVo);
}
