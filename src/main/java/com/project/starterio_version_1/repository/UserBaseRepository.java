package com.project.starterio_version_1.repository;

import com.project.starterio_version_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBaseRepository<T extends User> extends JpaRepository<T,Integer>{
    public T findByUsername(String username);
    public T findById(int id);
}
