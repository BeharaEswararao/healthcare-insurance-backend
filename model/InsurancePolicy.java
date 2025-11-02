package com.healthcare.insurance.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "insurance_policies")
public class InsurancePolicy {

    // Primary key - auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Policy details
    private String policyNumber;
    private String insuranceType; // EMERGENCY or PLANNED
    private Double coverageAmount;
    private Double premium;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; // PENDING, APPROVED, REJECTED

    // Relationship with Patient (Many policies to one patient)
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    // Medical and application details
    private String medicalCondition;
    private String hospitalName;
    private LocalDate applicationDate;

    // Default constructor (required by JPA)
    public InsurancePolicy() {
    }

    // Parameterized constructor (for easy object creation)
    public InsurancePolicy(String policyNumber, String insuranceType, Double coverageAmount, Double premium,
                         LocalDate startDate, LocalDate endDate, String status, Patient patient,
                         String medicalCondition, String hospitalName, LocalDate applicationDate) {
        this.policyNumber = policyNumber;
        this.insuranceType = insuranceType;
        this.coverageAmount = coverageAmount;
        this.premium = premium;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.patient = patient;
        this.medicalCondition = medicalCondition;
        this.hospitalName = hospitalName;
        this.applicationDate = applicationDate;
    }

    // GETTER METHODS

    public Long getId() {
        return id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public Double getCoverageAmount() {
        return coverageAmount;
    }

    public Double getPremium() {
        return premium;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    // SETTER METHODS

    public void setId(Long id) {
        this.id = id;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public void setCoverageAmount(Double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }
}