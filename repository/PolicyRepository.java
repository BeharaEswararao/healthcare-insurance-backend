package com.healthcare.insurance.repository;

import com.healthcare.insurance.model.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// PolicyRepository interface for database operations on InsurancePolicy entities
// Extends JpaRepository which provides basic CRUD operations
public interface PolicyRepository extends JpaRepository<InsurancePolicy, Long> {
    
    // Custom method to find an insurance policy by policy number
    // Returns a single InsurancePolicy object
    InsurancePolicy findByPolicyNumber(String policyNumber);
    
    // Custom method to find policies by insurance type
    // Returns a list of policies (EMERGENCY or PLANNED)
    List<InsurancePolicy> findByInsuranceType(String insuranceType);
    
    // Custom method to find policies by status
    // Returns a list of policies (PENDING, APPROVED, or REJECTED)
    List<InsurancePolicy> findByStatus(String status);
    
    // Custom method to find policies by patient ID
    // Returns a list of policies for a specific patient
    List<InsurancePolicy> findByPatientId(Long patientId);
}