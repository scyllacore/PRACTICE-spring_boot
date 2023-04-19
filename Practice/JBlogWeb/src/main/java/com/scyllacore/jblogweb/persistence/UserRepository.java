package com.scyllacore.jblogweb.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.scyllacore.jblogweb.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
