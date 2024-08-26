package com.example.csp.dao.repository;

import com.example.csp.dao.entity.DeaneryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeaneryRepository extends JpaRepository<DeaneryEntity, Long> {
}