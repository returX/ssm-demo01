package com.tf.ssm.controller;

import com.tf.ssm.entity.Comment;
import com.tf.ssm.entity.Reply;
import com.tf.ssm.service.impl.CommentService;
import com.tf.ssm.service.impl.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;
    @Autowired
    ReplyService replyService;

    @ResponseBody
    @RequestMapping("/getComment")
    public List<Comment> comment(@RequestBody Map<String,String> map
            , HttpServletRequest request){
        List<Comment> comments = new ArrayList<>();
        Comment comment = new Comment();
        String author_id = map.get("author_id");
        String content = map.get("content");
        comment.setAuthorId(Integer.valueOf(author_id));
        comment.setContent(content);
        comment.setReleaseTime(new Date());
        commentService.insertComment(comment);
        comments = commentService.selectAll();
        request.getSession().getServletContext().setAttribute("comments",comments);
        return comments;
    }

    @RequestMapping("/deleteComment")
    public String deleteComment(HttpServletRequest request){
        List<Comment> comments = new ArrayList<>();
        String id = request.getParameter("deleteId");
        commentService.deleteByPrimaryKey(Integer.valueOf(id));
        comments = commentService.selectAll();
        request.getSession().getServletContext().setAttribute("comments",comments);
        return "comment";
    }

    @ResponseBody
    @RequestMapping("/getReply")
    public List<Reply> reply(@RequestBody Map<String,String> map
                        ,HttpServletRequest request){
        List<Reply> replies = new ArrayList<>();
        Reply reply = new Reply();
        String author_id = map.get("author_id");
        String content = map.get("content");
        String comment_id = map.get("comment_id");
        reply.setAuthorId(Integer.valueOf(author_id));
        reply.setCommentId(Integer.valueOf(comment_id));
        reply.setContent(content);
        reply.setCommentTime(new Date());
        replyService.insertComment(reply);
        replies = replyService.selectAll();
        request.getSession().getServletContext().setAttribute("replies",replies);
        return replies;
    }

    @RequestMapping("/deleteReply")
    public String deleteReply(HttpServletRequest request){
        List<Reply> replies = new ArrayList<>();
        String id = request.getParameter("deleteId");
        replyService.deleteByPrimaryKey(Integer.valueOf(id));
        replies = replyService.selectAll();
        request.getSession().getServletContext().setAttribute("replies",replies);
        return "comment";
    }
}
