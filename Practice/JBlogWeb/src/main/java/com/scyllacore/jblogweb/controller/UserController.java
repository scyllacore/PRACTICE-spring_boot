package com.scyllacore.jblogweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

import com.scyllacore.jblogweb.exception.JBlogException;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import com.scyllacore.jblogweb.domain.RoleType;
import com.scyllacore.jblogweb.domain.User;
import com.scyllacore.jblogweb.persistence.UserRepository;


@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

   /* @GetMapping("/user/page/{page}")
    public @ResponseBody Page<User> getUserListPaging(@PathVariable int page){
        Pageable pageable =
                PageRequest.of(page,2,Sort.Direction.DESC,"id","userName");

        return userRepository.findAll(pageable);
    }*/

    @GetMapping("/user/page/{page}")
    public @ResponseBody Page<User> getUserListPaging(
            @PageableDefault(page = 0, size = 2, direction = Sort.Direction.DESC, sort = {"id", "userName"})
            Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @GetMapping("/user/list")
    public @ResponseBody List<User> getUserList() {
        return userRepository.findAll();
    }

    @DeleteMapping("/user/{id}")
    public @ResponseBody String deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return "회원 삭제 성공";
    }

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