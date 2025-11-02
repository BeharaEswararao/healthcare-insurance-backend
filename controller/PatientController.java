package com.healthcare.insurance.controller;

import com.healthcare.insurance.model.Patient;
import com.healthcare.insurance.model.DocumentRequest;
import com.healthcare.insurance.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    
    @Autowired
    private PatientService patientService;
    
    // GET ALL PATIENTS
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }
    
    // GET PATIENT BY ID
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }
    
    // CREATE NEW PATIENT
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }
    
    // GET PATIENT BY PATIENT ID
    @GetMapping("/patient-id/{patientId}")
    public Patient getPatientByPatientId(@PathVariable String patientId) {
        return patientService.getPatientByPatientId(patientId);
    }
    
    // SEARCH PATIENTS BY NAME
    @GetMapping("/search")
    public List<Patient> searchPatients(@RequestParam String name) {
        return patientService.searchPatients(name);
    }

    // DOCUMENT MANAGEMENT ENDPOINTS

    // UPDATE DOCUMENT INFORMATION (Aadhar & Bank Numbers)
    @PutMapping("/{patientId}/documents")
    public Patient updateDocuments(@PathVariable Long patientId, @RequestBody DocumentRequest request) {
        return patientService.updatePatientDocuments(patientId, request.getAadharNumber(), request.getBankAccountNumber());
    }

    // VERIFY DOCUMENTS (Admin Function)
    @PutMapping("/{patientId}/verify-documents")
    public Patient verifyDocuments(@PathVariable Long patientId, @RequestParam String status) {
        return patientService.updateDocumentStatus(patientId, status);
    }

    // CHECK DOCUMENT STATUS
    @GetMapping("/{patientId}/document-status")
    public String getDocumentStatus(@PathVariable Long patientId) {
        Patient patient = patientService.getPatientById(patientId);
        return "Patient: " + patient.getName() + " | Document Status: " + patient.getDocumentStatus();
    }

    // GET PATIENTS WITH PENDING DOCUMENTS (Admin)
    @GetMapping("/pending-documents")
    public List<Patient> getPatientsWithPendingDocuments() {
        return patientService.getPatientsWithPendingDocuments();
    }

    // CHECK IF DOCUMENTS ARE VERIFIED
    @GetMapping("/{patientId}/documents-verified")
    public String checkDocumentsVerified(@PathVariable Long patientId) {
        boolean verified = patientService.areDocumentsVerified(patientId);
        return verified ? "Documents are VERIFIED" : "Documents are NOT VERIFIED";
    }
}
