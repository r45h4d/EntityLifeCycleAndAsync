package com.example.csp.service.concrete;

import com.example.csp.dao.entity.DepartmentEntity;
import com.example.csp.dao.repository.DeparmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DeparmentRepository departmentRepository;
    @Cacheable("departmentList")
    public List<DepartmentEntity> getDepartmentsByDeaneryId(Long deaneryId){
        return departmentRepository.getDepartmentsByDeaneryId(deaneryId);
    }
}
