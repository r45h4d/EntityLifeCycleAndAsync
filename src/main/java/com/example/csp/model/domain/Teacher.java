package com.example.csp.model.domain;

import com.example.csp.dao.entity.DepartmentEntity;
import com.example.csp.model.enums.TeacherPositions;
import org.springframework.stereotype.Component;

@Component
public class Teacher {
    String name;
    String surname;
    String fatherName;
    DepartmentEntity departmentEntity;
    TeacherPositions position;
}
