package com.scyllacore.jblogweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scyllacore.jblogweb.domain.RoleType;
import com.scyllacore.jblogweb.domain.User;
import com.scyllacore.jblogweb.persistence.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void insertUser(User user){
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }
}
