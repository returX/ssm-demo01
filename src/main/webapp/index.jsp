<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>登录</title>
    <link type="text/css" rel="stylesheet" href="css/index.css" />
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
    </script>
    <script src="js/index.js"></script>
</head>
<body>
<div id="left">
    <div id="formLogin">
        <form action="/login" method="post">
            <span>用户名</span>
            <input id="username-login" type="text" name="username">
            <span id="span1"></span>
            <span>密码</span>
            <input id="password-login" type="password" name="password">
            <span id="span2"></span>
            <input type="button" onclick="loginAction()" value="登录" >
        </form>
    </div>
    <div class="left-icon"><a><img src="img/arrow.png"></a></div>
</div>
<div class="container">
    <p><a class="login">登录</a></p>
    <p><a class="register">注册</a></p>
</div>
<div id="right">
    <div>
        <div id="formRegister">
            <form action="/register" method="post">
                <span>用户名</span>
                <input type="text" name="username">
                <span>邮箱</span>
                <input type="text" name="email">
                <span id="span3"></span>
                <span>密码</span>
                <input type="password" name="password">
                <span>再次输入密码</span>
                <input type="password" name="password">
                <span id="span4"></span>
                <span>年龄</span>
                <select id="ageSelect">
                </select>
                <span>性别</span>
                <select>
                    <option name="gender" value="0">女</option>
                    <option name="gender" value="1">男</option>
                </select>
                <input id="toRegister" type="submit" value="注册">
            </form>
        </div>
    </div>
    <div class="right-icon"><a><img src="img/arrow.png"></a></div>
</div>
</body>
</html>