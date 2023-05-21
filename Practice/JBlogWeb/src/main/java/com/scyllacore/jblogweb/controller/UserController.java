package com.scyllacore.jblogweb.controller;

import com.scyllacore.jblogweb.dto.UserDTO;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

//
//import java.util.List;
//import java.util.function.Supplier;
//
//import com.scyllacore.jblogweb.exception.JBlogException;
//import org.springframework.transaction.annotation.Transactional;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.web.PageableDefault;
//
//import com.scyllacore.jblogweb.domain.RoleType;
import com.scyllacore.jblogweb.domain.User;
import com.scyllacore.jblogweb.dto.ResponseDTO;
import com.scyllacore.jblogweb.service.UserService;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
//import com.scyllacore.jblogweb.persistence.UserRepository;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/auth/insertUser")
    public String insertUser() {
        //System.out.println(9/0);
        return "user/insertUser";
    }

    @PostMapping("/auth/insertUser")
    public @ResponseBody ResponseDTO<?> insertUser(
            @Valid @RequestBody UserDTO userDTO, BindingResult bindingResult) {

        
        User user = modelMapper.map(userDTO, User.class);
        User findUser = userService.getUser(user.getUserName());
        System.out.println(findUser.getUserName());

        if (findUser.getUserName() == null) {
            userService.insertUser(user);
            return new ResponseDTO<>(HttpStatus.OK.value(), user.getUserName() + "님 회원가입 성공!");
        }
        return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), user.getUserName() + "님은 이미 회원입니다.");
    }


   /* @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/page/{page}")
    public @ResponseBody Page<User> getUserListPaging(@PathVariable int page){
        Pageable pageable =
                PageRequest.of(page,2,Sort.Direction.DESC,"id","userName");

        return userRepository.findAll(pageable);
    }

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
    }*/

}
