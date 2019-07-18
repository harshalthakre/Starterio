package com.project.starterio_version_1.repository;

import com.project.starterio_version_1.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer>{

    public Department findByDepartmentId(int departmentId);
    public Department findByName(String name);
}
