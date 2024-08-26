package com.example.csp.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "deaneries")
@Builder
@Slf4j
public class DeaneryEntity {
    private String name;
    private String dean;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @PostUpdate
    protected void onUpdatePost() {
        log.info("Entity has been updated: " + this);
    }
}
