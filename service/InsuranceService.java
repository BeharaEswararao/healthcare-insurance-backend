package com.healthcare.insurance.service;

import com.healthcare.insurance.model.InsurancePolicy;
import com.healthcare.insurance.model.Patient;
import com.healthcare.insurance.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

// Service class for handling insurance policy operations
// Contains business logic for insurance applications and management
@Service
public class InsuranceService {
    
    // Dependency injection of PolicyRepository
    @Autowired
    private PolicyRepository policyRepository;
    
    // Dependency injection of PatientService
    @Autowired
    private PatientService patientService;
    
    // Method to apply for emergency insurance
    public InsurancePolicy applyEmergencyInsurance(InsurancePolicy policy, Long patientId) {
        // Get the patient from database using patientId
        Patient patient = patientService.getPatientById(patientId);
        
        // Set insurance type to EMERGENCY
        policy.setInsuranceType("EMERGENCY");
        // Link the policy to the patient
        policy.setPatient(patient);
        // Set initial status to PENDING
        policy.setStatus("PENDING");
        // Set application date to current date
        policy.setApplicationDate(LocalDate.now());
        
        // Generate policy number if not provided
        if (policy.getPolicyNumber() == null) {
            policy.setPolicyNumber("EMER" + System.currentTimeMillis());
        }
        
        // Save the policy to database and return it
        return policyRepository.save(policy);
    }
    
    // Method to apply for planned insurance
    public InsurancePolicy applyPlannedInsurance(InsurancePolicy policy, Long patientId) {
        // Get the patient from database using patientId
        Patient patient = patientService.getPatientById(patientId);
        
        // Set insurance type to PLANNED
        policy.setInsuranceType("PLANNED");
        // Link the policy to the patient
        policy.setPatient(patient);
        // Set initial status to PENDING
        policy.setStatus("PENDING");
        // Set application date to current date
        policy.setApplicationDate(LocalDate.now());
        
        // Generate policy number if not provided
        if (policy.getPolicyNumber() == null) {
            policy.setPolicyNumber("PLAN" + System.currentTimeMillis());
        }
        
        // Save the policy to database and return it
        return policyRepository.save(policy);
    }
    
    // Method to get all approved policies
    public List<InsurancePolicy> getApprovedPolicies() {
        return policyRepository.findByStatus("APPROVED");
    }
    
    // Method to get policies by insurance type (EMERGENCY or PLANNED)
    public List<InsurancePolicy> getPoliciesByType(String insuranceType) {
        return policyRepository.findByInsuranceType(insuranceType);
    }
    
    // Method to get all insurance policies
    public List<InsurancePolicy> getAllPolicies() {
        return policyRepository.findAll();
    }
    
    // Method to check the status of an insurance policy
    public String checkInsuranceStatus(String policyNumber) {
        // Find policy by policy number in database
        InsurancePolicy policy = policyRepository.findByPolicyNumber(policyNumber);
        
        // If policy not found, return error message
        if (policy == null) {
            // Debug information (optional - can be removed in production)
            List<InsurancePolicy> allPolicies = getAllPolicies();
            System.out.println("Searching for policy: " + policyNumber);
            System.out.println("Total policies in database: " + allPolicies.size());
            for (InsurancePolicy p : allPolicies) {
                System.out.println("Policy in database: " + p.getPolicyNumber());
            }
            return "Policy not found: " + policyNumber;
        }
        
        // Return policy status if found
        return "Policy " + policyNumber + " Status: " + policy.getStatus();
    }
}