package com.scyllacore.jblogweb.controller;

import org.springframework.web.bind.annotation.*;

import com.scyllacore.jblogweb.domain.User;

@RestController
public class RESTController {

    @GetMapping("/jblog")
    public User httpGet(){
        User findUser = User.builder()
                .id(1)
                .userName("scyllacore")
                .password("123")
                .email("scyllacore@gmail.com")
                .build();

        return findUser;
    }

    /*@PostMapping("/jblog")
    public String httPost(User user){
        return "Post 요청 처리 입력 값 : " + user.toString();
    }*/

    @PostMapping("/jblog")
    public String httPostJson(@RequestBody User user){
        return "Post 요청 처리 입력 값 : " + user.toString();
    }

    @PutMapping("/jblog")
    public String httpPut(@RequestBody User user){
        return "Put 요청 처리 입력 값 : " + user.toString();
    }

    @DeleteMapping("/jblog")
    public String httpDelete(@RequestParam int id){
        return "Delete 요청 처리 입력값 : " + id;
    }

}
