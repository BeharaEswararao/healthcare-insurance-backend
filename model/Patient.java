package com.healthcare.insurance.model;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {
    
    // Primary key - auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Basic patient information
    private String patientId;
    private String name;
    private Integer age;
    private String gender;
    private String contactNumber;
    private String address;
    private String medicalHistory;

    // Document information fields (text data only - no file upload)
    private String aadharNumber;
    private String bankAccountNumber;
    private String documentStatus = "PENDING"; // PENDING, VERIFIED, REJECTED

    // Default constructor (required by JPA)
    public Patient() {
    }

    // GETTER METHODS

    public Long getId() {
        return id;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

    // SETTER METHODS

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }
}

