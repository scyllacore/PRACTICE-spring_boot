package com.scyllacore.jblogweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.function.Supplier;
import com.scyllacore.jblogweb.exception.JBlogException;

import com.scyllacore.jblogweb.domain.RoleType;
import com.scyllacore.jblogweb.domain.User;
import com.scyllacore.jblogweb.persistence.UserRepository;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/get/{id}")
    public @ResponseBody User getUser(@PathVariable int id){
        //존재하지 않는 회원 조회 시 예외 반환.

        User findUser = userRepository.findById(id).orElseThrow(new Supplier<JBlogException>() {
            @Override
            public JBlogException get() {
                return new JBlogException(id + "번 회원은 없습니다.");
            }
        });
        return findUser;
    }


    @PostMapping("/user")
    public @ResponseBody String insertUser(@RequestBody User user){
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return user.getUserName() + " 회원가입 성공";
    }

}
