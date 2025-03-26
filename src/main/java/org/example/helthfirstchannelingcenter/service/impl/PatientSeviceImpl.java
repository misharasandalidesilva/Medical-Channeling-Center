package org.example.helthfirstchannelingcenter.service.impl;

import jakarta.transaction.Transactional;
import org.example.helthfirstchannelingcenter.dto.PatientDTO;
import org.example.helthfirstchannelingcenter.repo.PatientRepo;
import org.example.helthfirstchannelingcenter.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional// ✅ Ensure this annotation is present
public class PatientSeviceImpl implements PatientService {
    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PatientDTO savePatient(PatientDTO patientDTO) {
        // Business logic here
        return patientDTO;
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        // Business logic here
        return List.of();
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        // Business logic here
        return null;
    }

    @Override
    public String deletePatient(Long id) {
        // Business logic here
        return "";
    }
}
