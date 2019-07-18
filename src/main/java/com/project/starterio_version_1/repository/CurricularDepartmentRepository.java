package com.project.starterio_version_1.repository;

import com.project.starterio_version_1.model.CurricularDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurricularDepartmentRepository extends JpaRepository<CurricularDepartment,Integer> {

    public CurricularDepartment findById(int id);
    public CurricularDepartment findByName(String name);
}
