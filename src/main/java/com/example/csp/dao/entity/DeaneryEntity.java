package com.example.csp.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "deaneries")
@Slf4j
public class DeaneryEntity {
    @Column(name = "name", nullable = false, length = 64)
    String name;

    @Column(name = "dean", nullable = false, length = 64)
    String dean;
    @Id
    private Long id;

    @PostUpdate
    protected void onUpdatePost() {
        log.info("Entity has been updated: " + this);
    }
}
