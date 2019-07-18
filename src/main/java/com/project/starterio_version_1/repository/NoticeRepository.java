package com.project.starterio_version_1.repository;

import com.project.starterio_version_1.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface NoticeRepository extends JpaRepository<Notice,Integer>{

    public Notice findByNoticeId(int noticeId);
    public List<Notice> findByDepartmentDepartmentId(int departmentId);
}
