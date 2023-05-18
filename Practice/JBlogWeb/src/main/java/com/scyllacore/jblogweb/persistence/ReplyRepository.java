package com.scyllacore.jblogweb.persistence;

import com.scyllacore.jblogweb.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
}
