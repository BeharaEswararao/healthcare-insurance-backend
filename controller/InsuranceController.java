package com.healthcare.insurance.controller;

import com.healthcare.insurance.model.InsurancePolicy;
import com.healthcare.insurance.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/insurance")
public class InsuranceController {
    
    @Autowired
    private InsuranceService insuranceService;
    
    // Add constructor for debugging
    public InsuranceController() {
        System.out.println("✅ InsuranceController loaded successfully!");
    }
    
    // Apply Emergency Insurance
    @PostMapping("/emergency")
    public InsurancePolicy applyEmergencyInsurance(
            @RequestBody InsurancePolicy policy,
            @RequestParam Long patientId) {
        return insuranceService.applyEmergencyInsurance(policy, patientId);
    }
    
    // Apply Planned Insurance
    @PostMapping("/planned")
    public InsurancePolicy applyPlannedInsurance(
            @RequestBody InsurancePolicy policy,
            @RequestParam Long patientId) {
        return insuranceService.applyPlannedInsurance(policy, patientId);
    }
    
    // View Approved Insurance
    @GetMapping("/approved")
    public List<InsurancePolicy> getApprovedPolicies() {
        return insuranceService.getApprovedPolicies();
    }
    
    // View Insurance Information (All policies)
    @GetMapping("/policies")
    public List<InsurancePolicy> getAllPolicies() {
        return insuranceService.getAllPolicies();
    }
    
    // Insurance Status
    @GetMapping("/status/{policyNumber}")
    public String getInsuranceStatus(@PathVariable String policyNumber) {
        return insuranceService.checkInsuranceStatus(policyNumber);
    }
    
    // View policies by type
    @GetMapping("/type/{insuranceType}")
    public List<InsurancePolicy> getPoliciesByType(@PathVariable String insuranceType) {
        return insuranceService.getPoliciesByType(insuranceType);
    }
}