package com.scyllacore.jblogweb.service;

import com.scyllacore.jblogweb.domain.Post;
import com.scyllacore.jblogweb.domain.Reply;
import com.scyllacore.jblogweb.domain.User;
import com.scyllacore.jblogweb.persistence.PostRepository;
import com.scyllacore.jblogweb.persistence.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReplyService {
    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public void insertReply(int postId, Reply reply, User user){
        Post post = postRepository.findById(postId).get();
        reply.setUser(user);
        reply.setPost(post);
        replyRepository.save(reply);
    }

}
