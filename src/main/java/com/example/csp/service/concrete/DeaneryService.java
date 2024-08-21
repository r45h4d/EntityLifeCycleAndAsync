package com.example.csp.service.concrete;

import com.example.csp.dao.repository.DeaneryRepository;
import com.example.csp.dao.entity.DeaneryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeaneryService {

    private final DeaneryRepository deaneryRepository;

    // Get all deaneries
    public List<DeaneryEntity> getAllDeaneries() {
        return deaneryRepository.findAll();
    }

    // Get deanery by id
    public Optional<DeaneryEntity> getDeaneryById(Long id) {
        return deaneryRepository.findById(id);
    }

    // Add a new deanery
    public DeaneryEntity addDeanery(DeaneryEntity deanery) {
        return deaneryRepository.save(deanery);
    }

    // Update an existing deanery

    public DeaneryEntity updateDeanery(Long id, DeaneryEntity deanery) {
        if (deaneryRepository.existsById(id)) {
            deanery.setId(id);
            return deaneryRepository.save(deanery);
        }
        return null; // or throw an exception if preferred
    }

    // Delete a deanery by id
    public void deleteDeanery(Long id) {
        if (deaneryRepository.existsById(id)) {
            deaneryRepository.deleteById(id);
        }
    }
}
