package com.example.csp.controller;

import com.example.csp.dao.entity.DeaneryEntity;
import com.example.csp.dao.repository.DeaneryRepository;
import com.example.csp.service.concrete.DeaneryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/deaneries")
public class DeaneryController {

    private final DeaneryService deaneryService;

    // Get all deaneries
    @GetMapping
    public ResponseEntity<List<DeaneryEntity>> getAllDeaneries() {
        List<DeaneryEntity> deaneries = deaneryService.getAllDeaneries();
        return ResponseEntity.ok(deaneries);
    }

    // Get deanery by id
    @GetMapping("/{id}")
    public ResponseEntity<DeaneryEntity> getDeaneryById(@PathVariable Long id) {
        Optional<DeaneryEntity> deanery = deaneryService.getDeaneryById(id);
        return deanery.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new deanery
    @PostMapping
    public ResponseEntity<DeaneryEntity> addDeanery(@RequestBody DeaneryEntity deanery) {
        DeaneryEntity savedDeanery = deaneryService.addDeanery(deanery);
        return ResponseEntity.ok(savedDeanery);
    }

    // Update an existing deanery
    @PutMapping("/{id}")
    public ResponseEntity<DeaneryEntity> updateDeanery(@PathVariable Long id, @RequestBody DeaneryEntity deanery) {
        DeaneryEntity updatedDeanery = deaneryService.updateDeanery(id, deanery);
        return updatedDeanery != null ? ResponseEntity.ok(updatedDeanery) : ResponseEntity.notFound().build();
    }

    // Delete a deanery by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeanery(@PathVariable Long id) {
        deaneryService.deleteDeanery(id);
        return ResponseEntity.noContent().build();
    }
}