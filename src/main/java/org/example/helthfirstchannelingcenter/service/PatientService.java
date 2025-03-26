package org.example.helthfirstchannelingcenter.service;

import org.example.helthfirstchannelingcenter.dto.PatientDTO;

import java.util.List;

public interface PatientService {
    PatientDTO savePatient(PatientDTO patientDTO);
    List<PatientDTO> getAllPatients();
    PatientDTO getPatientById(Long id);
    String deletePatient(Long id);
}
