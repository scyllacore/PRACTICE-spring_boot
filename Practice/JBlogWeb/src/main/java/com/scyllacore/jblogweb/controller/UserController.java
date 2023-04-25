package com.scyllacore.jblogweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.function.Supplier;

import com.scyllacore.jblogweb.exception.JBlogException;
import org.springframework.transaction.annotation.Transactional;

import com.scyllacore.jblogweb.domain.RoleType;
import com.scyllacore.jblogweb.domain.User;
import com.scyllacore.jblogweb.persistence.UserRepository;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    //@Transactional -> save를 자동으로 해줌
    @PutMapping("/user")
    public @ResponseBody String updateUser(@RequestBody User user) {
        User findUser = userRepository.findById(user.getId()).orElseThrow(() -> {
            return new JBlogException(user.getId() + "번 회원은 없습니다");
        });

        findUser.setUserName(user.getUserName());
        findUser.setPassword(user.getPassword());
        findUser.setEmail(user.getEmail());

        userRepository.save(findUser);

        return "회원 정보 수정 성공";
    }

    @GetMapping("/user/get/{id}")
    public @ResponseBody User getUser(@PathVariable int id) {
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
    public @ResponseBody String insertUser(@RequestBody User user) {
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return user.getUserName() + " 회원가입 성공";
    }

}
