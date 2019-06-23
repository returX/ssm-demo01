<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.tf.ssm.entity.User" %>
<%@ page import="com.tf.ssm.entity.Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>社区</title>
    <link type="text/css" rel="stylesheet" href="../../css/comment.css" />
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="../../js/comment.js"></script>
    <% User user = (User) session.getAttribute("USER_INF");
        String uid = String.valueOf(user.getUid());%>
</head>
<body>
    <c:set var="uid" value="<%=uid%>" scope="page"/>
    <div id="container">
        <div id="c">
            <textarea name="text" rows="10" cols="50">
            </textarea>
        </div>
        <button id="commit" onclick="commit_comment(${uid})">发帖</button>
        <div>
            <ul id="commit-comment">
                <c:forEach var="comment" items="${applicationScope.get('comments')}">
                    <li><p>作者：${comment.authorId}</p>
                    <p>内容：${comment.content}</p>
                    <p>发布时间：${comment.releaseTime}</p>
                        <c:if test="${comment.authorId == uid}">
                            <a href="/deleteComment?deleteId=${comment.id}">删除评论</a>
                        </c:if>
                    <a onclick="showform()">点击回复</a></li>
                    <div id="container-reply" style="display: none">
                        <textarea name="reply-text" rows="10" cols="50">
                        </textarea>
                        <button id="commit-reply" onclick="commit_reply(${uid},${comment.authorId})">回复</button>
                    </div>
                    <c:forEach var="reply" items="${applicationScope.get('replies')}">
                        <li><p>${uid}回复${comment.authorId}</p>
                            <p>内容：${reply.content}</p>
                            <p>发布时间：${reply.commentTime}</p>
                            <c:if test="${comment.authorId == uid}">
                                <a href="/deleteReply?deleteId=${reply.id}">删除回复</a>
                            </c:if>
                        </li>
                    </c:forEach>
                </c:forEach>

            </ul>
        </div>
    </div>
</body>
</html>
