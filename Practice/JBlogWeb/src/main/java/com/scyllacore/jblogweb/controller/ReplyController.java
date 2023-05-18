package com.scyllacore.jblogweb.controller;

import com.scyllacore.jblogweb.domain.Reply;
import com.scyllacore.jblogweb.domain.User;
import com.scyllacore.jblogweb.dto.ResponseDTO;
import com.scyllacore.jblogweb.service.ReplyService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @PostMapping("/reply/{postId}")
    public @ResponseBody ResponseDTO<?> insertReply(@PathVariable int postId,
                                                    @RequestBody Reply reply, HttpSession session){
        User principal = (User) session.getAttribute("principal");
        replyService.insertReply(postId,reply,principal);
        return new ResponseDTO<>(HttpStatus.OK.value(), postId + "번 게시글에 댓글을 등록했습니다");
    }
}
