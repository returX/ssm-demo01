package com.tf.ssm.controller;

import com.tf.ssm.entity.User;
import com.tf.ssm.service.impl.UserService;
import com.tf.ssm.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public String login(@RequestBody User user
                    , HttpServletRequest request){
        boolean flag = userService.checkUser(user);
        if (flag){
            User u = userService.findUserByName(user.getUsername());
            System.err.println(u);
            u.setLast_ip(request.getRemoteAddr());
            u.setLast_time(new Date());
            UserVo userVo = new UserVo();
            userVo.setUser(u);
            userService.updateUser(userVo);
            request.getSession().setAttribute("USER_INF",u);
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/comment")
    public String comment(){
        return "/comment";
    }

}
