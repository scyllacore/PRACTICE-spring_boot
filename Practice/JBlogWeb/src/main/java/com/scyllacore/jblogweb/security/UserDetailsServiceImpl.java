package com.scyllacore.jblogweb.security;

import com.scyllacore.jblogweb.domain.User;
import com.scyllacore.jblogweb.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(username).orElseThrow(()-> {
            return new UsernameNotFoundException(username + " 사용자는 존재하지 않습니다.");
        });

        return new UserDetailsImpl(principal);
    }
}
