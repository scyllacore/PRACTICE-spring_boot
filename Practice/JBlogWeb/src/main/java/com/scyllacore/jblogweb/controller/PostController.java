package com.scyllacore.jblogweb.controller;

import com.scyllacore.jblogweb.domain.Post;
import com.scyllacore.jblogweb.domain.User;
import com.scyllacore.jblogweb.dto.PostDTO;
import com.scyllacore.jblogweb.dto.ResponseDTO;
import com.scyllacore.jblogweb.service.PostService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private ModelMapper modelMapper;

    @DeleteMapping("/post/{id}")
    public @ResponseBody ResponseDTO<?> deletePost(@PathVariable int id) {
        postService.deletePost(id);
        return new ResponseDTO<>(HttpStatus.OK.value(), id + "번 게시물을 삭제했습니다.");
    }

    @PutMapping("/post")
    public @ResponseBody ResponseDTO<?> updatePost(@RequestBody Post post) {
        postService.updatePost(post);
        return new ResponseDTO<>(HttpStatus.OK.value(),post.getId() + "번 게시물을 수정했습니다.");
    }

    @GetMapping("/post/updatePost/{id}")
    public String updatePost(@PathVariable int id,Model model){
        model.addAttribute("post",postService.getPost(id));
        return "post/updatePost";
    }


    @GetMapping("/post/{id}")
    public String getPost(@PathVariable int id,Model model){
        model.addAttribute("post",postService.getPost(id));
        return "post/getPost";
    }

    @PostMapping("/post")
    public @ResponseBody ResponseDTO<?> insertPost(
            @Valid @RequestBody PostDTO postDTO, BindingResult bindingResult, HttpSession session) {

        Post post = modelMapper.map(postDTO,Post.class);
        User principal = (User) session.getAttribute("principal");
        post.setUser(principal);
        post.setCount(0);

        postService.insertPost(post);

        return new ResponseDTO<>(HttpStatus.OK.value(), "새로운 게시물이 등록되었습니다");
    }

    @GetMapping({"", "/"})
    public String getPostList(Model model,
                              @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("postList", postService.getPostList(pageable));
        return "index";
    }

    @GetMapping("/post/insertPost")
    public String insertPost() {
        return "post/insertPost";
    }
}
