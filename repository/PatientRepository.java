package com.healthcare.insurance.repository;

import com.healthcare.insurance.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// PatientRepository interface for database operations on Patient entities
// Extends JpaRepository which provides basic CRUD operations
public interface PatientRepository extends JpaRepository<Patient, Long> {
    
    // Custom method to find a patient by patientId
    // Spring Data JPA automatically implements this method
    Patient findByPatientId(String patientId);
    
    // Custom method to search patients by name (case-insensitive)
    // Returns a list of patients whose name contains the given string
    List<Patient> findByNameContainingIgnoreCase(String name);
}