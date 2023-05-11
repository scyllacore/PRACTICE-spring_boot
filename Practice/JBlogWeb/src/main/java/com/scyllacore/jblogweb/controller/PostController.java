package com.scyllacore.jblogweb.controller;

import com.scyllacore.jblogweb.domain.Post;
import com.scyllacore.jblogweb.domain.User;
import com.scyllacore.jblogweb.dto.ResponseDTO;
import com.scyllacore.jblogweb.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public @ResponseBody ResponseDTO<?> insertPost(@RequestBody Post post, HttpSession session){
        User principal = (User) session.getAttribute("principal");
        post.setUser(principal);
        post.setCount(0);

        postService.insertPost(post);

        return new ResponseDTO<>(HttpStatus.OK.value(),"새로운 게시물이 등록되었습니다");
    }

    @GetMapping({"","/"})
    public String index(){
        return "index";
    }

    @GetMapping("/post/insertPost")
    public String insertPost(){
        return "post/insertPost";
    }
}
