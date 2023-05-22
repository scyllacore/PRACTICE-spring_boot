/*
package com.scyllacore.jblogweb.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.scyllacore.jblogweb.domain.User;
import com.scyllacore.jblogweb.dto.ResponseDTO;
import com.scyllacore.jblogweb.service.UserService;



@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/auth/login")
    public String login() {
        return "system/login";
    }

    @GetMapping("/auth/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/auth/login")
    public @ResponseBody ResponseDTO<?> login(@RequestBody User user,HttpSession session) {
        User findUser = userService.getUser(user.getUserName());
        System.out.println(findUser.getUserName());

        if (findUser.getUserName() == null) {
            return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "존재하지 않는 회원입니다.");
        }

        if(user.getPassword().equals(findUser.getPassword())){
            session.setAttribute("principal",findUser);
            return new ResponseDTO<>(HttpStatus.OK.value(), findUser.getUserName() + "님 로그인 완료.");
        }

        return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "비밀번호 오류입니다.");
    }



}
*/
