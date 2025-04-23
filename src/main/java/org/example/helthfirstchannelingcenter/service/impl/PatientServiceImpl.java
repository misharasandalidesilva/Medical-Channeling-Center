package org.example.helthfirstchannelingcenter.service.impl;

import org.example.helthfirstchannelingcenter.dto.PatientDTO;
import org.example.helthfirstchannelingcenter.entity.Patient;
import org.example.helthfirstchannelingcenter.repo.PatientRepository;
import org.example.helthfirstchannelingcenter.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public PatientDTO savePatient(PatientDTO patientDTO) {
        Patient patient = modelMapper.map(patientDTO, Patient.class);
        Patient savedPatient = patientRepository.save(patient);
        return modelMapper.map(savedPatient, PatientDTO.class);
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(patient -> modelMapper.map(patient, PatientDTO.class)).toList();
    }

    @Override
    public String deletePatient(UUID id) {
        patientRepository.deleteById(id);
        return "Patient deleted successfully";
    }

    @Override
    public List<PatientDTO> getPatient(UUID userId) {
        List<Patient> patients = patientRepository.findByUser_Uid(userId);
        return patients.stream()
                .map(patient -> modelMapper.map(patient, PatientDTO.class)) // <-- fixed here
                .collect(Collectors.toList());
    }

}
