package org.example.helthfirstchannelingcenter.service;

import jakarta.validation.Valid;
import org.example.helthfirstchannelingcenter.dto.PatientDTO;

import java.util.List;
import java.util.UUID;

public interface PatientService {

    PatientDTO savePatient(@Valid PatientDTO patientDTO);

    List<PatientDTO> getAllPatients();

    String deletePatient(UUID id);

    List<PatientDTO> getPatient(UUID userId);
}
