package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Comment;

// JpaRepository 継承によって、DBの取得や保存が可能になる
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
