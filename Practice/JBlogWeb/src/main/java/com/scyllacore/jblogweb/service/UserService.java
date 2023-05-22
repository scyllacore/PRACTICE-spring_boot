package com.scyllacore.jblogweb.service;

import org.springframework.beans.factory.annotation.Autowired;
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
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }
}
