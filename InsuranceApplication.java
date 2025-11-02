package com.healthcare.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.healthcare.insurance.controller",
    "com.healthcare.insurance.service", 
    "com.healthcare.insurance.repository",
    "com.healthcare.insurance.config"
})
@RestController
public class InsuranceApplication {
    
    // Test endpoints in main class
    @GetMapping("/main-test")
    public String mainTest() {
        return "MAIN CLASS TEST WORKING!";
    }
    
    @GetMapping("/service-test") 
    public String serviceTest() {
        return "Services are accessible!";
    }

    // MAIN PACKAGE PATIENT CONTROLLER
    @RestController
    @RequestMapping("/api/main-patients")
    class MainPatientController {
        
        private List<String> patients = new ArrayList<>();
        
        @GetMapping
        public List<String> getPatients() {
            return patients;
        }
        
        @PostMapping
        public String createPatient(@RequestBody String patientName) {
            patients.add(patientName);
            return "Patient created: " + patientName;
        }
        
        @GetMapping("/test")
        public String test() {
            return "MAIN PACKAGE PATIENT CONTROLLER WORKING!";
        }
    }

    // MAIN PACKAGE INSURANCE CONTROLLER  
    @RestController
    @RequestMapping("/api/main-insurance")
    class MainInsuranceController {
        
        @GetMapping
        public String getInsurance() {
            return "MAIN PACKAGE INSURANCE CONTROLLER WORKING!";
        }
        
        @PostMapping
        public String createInsurance() {
            return "Insurance application submitted from main package!";
        }
        
        @GetMapping("/status/{policyNumber}")
        public String getStatus(@PathVariable String policyNumber) {
            return "Policy " + policyNumber + " status: APPROVED";
        }
    }
    
    public static void main(String[] args) {
        SpringApplication.run(InsuranceApplication.class, args);
        System.out.println("Healthcare Insurance System Started Successfully!");
    }
}