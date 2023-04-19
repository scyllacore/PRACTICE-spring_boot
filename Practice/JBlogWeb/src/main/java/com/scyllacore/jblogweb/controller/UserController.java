package com.scyllacore.jblogweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scyllacore.jblogweb.domain.RoleType;
import com.scyllacore.jblogweb.domain.User;
import com.scyllacore.jblogweb.persistence.UserRepository;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public @ResponseBody String insertUser(@RequestBody User user){
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return user.getUserName() + " 회원가입 성공";
    }

}
