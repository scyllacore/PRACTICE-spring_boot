package com.scyllacore.jblogweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import java.util.function.Supplier;

import com.scyllacore.jblogweb.domain.RoleType;
import com.scyllacore.jblogweb.domain.User;
import com.scyllacore.jblogweb.persistence.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void updateUser(User user){
        User findUser = userRepository.findById(user.getId()).get();
        findUser.setUsername(user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        findUser.setEmail(user.getEmail());
    }


    @Transactional(readOnly = true)
    public User getUser(String username){
        /*User findUser = userRepository.findByUserName(userName).orElseGet(
                new Supplier<User>() {
                    @Override
                    public User get() {
                        return new User();
                    }
                }
        );*/

        User findUser = userRepository.findByUsername(username).orElseGet(() -> {return new User();});
        //람라식에서 return을 쓸 때는 해당 코드를 중괄호로 감싸준다.

        return findUser;
    }

    @Transactional
    public void insertUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRole(RoleType.USER);
        userRepository.save(user);
    }
}
