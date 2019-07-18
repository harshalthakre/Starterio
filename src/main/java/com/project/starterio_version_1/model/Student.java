package com.project.starterio_version_1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student  extends User {

    @ManyToOne(fetch = FetchType.LAZY)
    /*** lookup @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})*/
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Department department;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<CurricularDepartment> curricularDepartmentSet=new HashSet<CurricularDepartment>(0);

    public Set<CurricularDepartment> getCurricularDepartmentSet() {
        return curricularDepartmentSet;
    }

    public void setCurricularDepartmentSet(Set<CurricularDepartment> curricularDepartmentSet) {
        this.curricularDepartmentSet = curricularDepartmentSet;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }
}
