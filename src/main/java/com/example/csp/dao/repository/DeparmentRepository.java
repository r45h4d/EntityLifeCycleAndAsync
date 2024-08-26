package com.example.csp.dao.repository;

import com.example.csp.dao.entity.DepartmentEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeparmentRepository extends JpaRepository<DepartmentEntity, Long> {
    @Cacheable("departments")
    List<DepartmentEntity> getDepartmentsByDeaneryId(Long deaneryId);
}
