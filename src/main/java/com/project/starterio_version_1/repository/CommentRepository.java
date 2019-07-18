package com.project.starterio_version_1.repository;

import com.project.starterio_version_1.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository  extends JpaRepository<Comment,Integer>{

    public Comment findByCommentId(int commentId);
    public List<Comment> findByUserId(int userId);
}
