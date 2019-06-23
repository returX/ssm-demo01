package com.tf.ssm.mapper;

import com.tf.ssm.entity.User;
import com.tf.ssm.vo.UserVo;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserMapper {

    public void addUser(User user);

    public User findUserById(int uid);

    public List<User> findUserListByName(String username);

    public User findUserByName(String username);

    public int selectCount(User user);

    public void updateUser(UserVo userVo);
}
