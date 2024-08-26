package com.example.csp.controller;

import com.example.csp.dao.dto.DepartmentDTO;
import com.example.csp.dao.entity.DepartmentEntity;
import com.example.csp.service.concrete.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/by-deanery/{deaneryId}")
    public List<DepartmentDTO> getDepartmentsByDeanery(@PathVariable Long deaneryId) {
        List<DepartmentEntity> departments = departmentService.getDepartmentsByDeaneryId(deaneryId);
        return departments.stream().map(department -> {
            DepartmentDTO dto = new DepartmentDTO();
            dto.setId(department.getId());
            dto.setName(department.getName());
            dto.setDeaneryId(department.getDeanery().getId());
            return dto;
        }).collect(Collectors.toList());
    }
}
