package com.scyllacore.jblogweb.persistence;

import com.scyllacore.jblogweb.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
