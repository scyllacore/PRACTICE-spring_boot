package com.scyllacore.jblogweb.service;

import com.scyllacore.jblogweb.domain.Post;
import com.scyllacore.jblogweb.persistence.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<Post> getPostList(){
        return postRepository.findAll();
    }

    @Transactional
    public void insertPost(Post post) {
        post.setCount(0);
        postRepository.save(post);
    }
}
