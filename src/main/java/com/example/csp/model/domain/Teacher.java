package com.example.csp.model.domain;

import com.example.csp.model.enums.TeacherPositions;
import org.springframework.stereotype.Component;

@Component
public class Teacher {
    String name;
    String surname;
    String fatherName;
    Department department;
    TeacherPositions position;
}
