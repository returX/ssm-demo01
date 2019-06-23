package com.tf.ssm.interceptor;

import com.tf.ssm.util.TokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {
    /**
     * 在每个请求前执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("accessToken");
        System.err.println("我是拦截器");
        //token不存在
        if(null != token){
            //验证token是否正确
            boolean result = TokenUtil.verify(token);
            System.err.println("验证码"+result);
            if (result){
                return true;
            }
        }
        //重定向到错误页面
        return false;
    }
}
