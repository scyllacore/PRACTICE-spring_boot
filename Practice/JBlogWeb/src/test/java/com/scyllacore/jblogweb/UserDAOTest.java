package com.scyllacore.jblogweb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.scyllacore.jblogweb.domain.User;
import com.scyllacore.jblogweb.persistence.UserDAO;

@SpringBootTest
public class UserDAOTest {
    @Autowired
    private UserDAO userDAO;

    @Test
    void getUserListTest(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("123");
        user.setEmail("test@gmail");

        int before = userDAO.getUserList().size();
        userDAO.insertUser(user);
        int after = userDAO.getUserList().size();

        assertEquals(before+1,after);
    }
}
