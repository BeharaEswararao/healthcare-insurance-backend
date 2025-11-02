package com.healthcare.insurance.service;

import com.healthcare.insurance.model.Patient;
import com.healthcare.insurance.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

// Service class for handling patient operations
// Contains business logic for patient management and document handling
@Service
public class PatientService {

    // Dependency injection of PatientRepository
    @Autowired
    private PatientRepository patientRepository;

    // Method to get all patients from database
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Method to get a patient by their ID
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    // Method to create a new patient
    public Patient createPatient(Patient patient) {
        // Generate patient ID if not provided
        if (patient.getPatientId() == null) {
            String generatedId = "PAT" + System.currentTimeMillis();
            patient.setPatientId(generatedId);
        }
        // Save patient to database and return the saved patient
        return patientRepository.save(patient);
    }

    // Method to get a patient by patient ID (custom ID, not database ID)
    public Patient getPatientByPatientId(String patientId) {
        Patient patient = patientRepository.findByPatientId(patientId);
        if (patient == null) {
            throw new RuntimeException("Patient not found with patient ID: " + patientId);
        }
        return patient;
    }

    // Method to search patients by name (case-insensitive)
    public List<Patient> searchPatients(String name) {
        return patientRepository.findByNameContainingIgnoreCase(name);
    }

    // DOCUMENT MANAGEMENT METHODS

    // Method to update patient document information (Aadhar and Bank numbers)
    public Patient updatePatientDocuments(Long patientId, String aadharNumber, String bankAccountNumber) {
        // Get patient from database
        Patient patient = getPatientById(patientId);
        // Update document information
        patient.setAadharNumber(aadharNumber);
        patient.setBankAccountNumber(bankAccountNumber);
        // Set document status to PENDING for verification
        patient.setDocumentStatus("PENDING");
        // Save updated patient and return
        return patientRepository.save(patient);
    }

    // Method to update document verification status (Admin function)
    public Patient updateDocumentStatus(Long patientId, String status) {
        // Get patient from database
        Patient patient = getPatientById(patientId);
        
        // Validate the status value
        if (!status.equals("VERIFIED") && !status.equals("REJECTED") && !status.equals("PENDING")) {
            throw new RuntimeException("Invalid document status. Use: VERIFIED, REJECTED, or PENDING");
        }
        
        // Update document status
        patient.setDocumentStatus(status);
        // Save updated patient and return
        return patientRepository.save(patient);
    }

    // Method to get all patients with pending document verification
    public List<Patient> getPatientsWithPendingDocuments() {
        // Get all patients from database
        List<Patient> allPatients = patientRepository.findAll();
        // Filter patients with PENDING document status
        return allPatients.stream()
                .filter(patient -> "PENDING".equals(patient.getDocumentStatus()))
                .collect(Collectors.toList());
    }

    // Method to check if a patient's documents are verified
    public boolean areDocumentsVerified(Long patientId) {
        // Get patient from database
        Patient patient = getPatientById(patientId);
        // Return true if documents are VERIFIED
        return "VERIFIED".equals(patient.getDocumentStatus());
    }
}