package org.example.helthfirstchannelingcenter.service.impl;

import jakarta.transaction.Transactional;
import org.example.helthfirstchannelingcenter.controller.DoctorController;
import org.example.helthfirstchannelingcenter.dto.DoctorDTO;
import org.example.helthfirstchannelingcenter.entity.Doctor;
import org.example.helthfirstchannelingcenter.repo.DoctorRepository;
import org.example.helthfirstchannelingcenter.service.DoctorService;
import org.example.helthfirstchannelingcenter.utill.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public DoctorDTO saveDoctor(DoctorDTO doctorDTO) {
        doctorRepository.save(modelMapper.map(doctorDTO, Doctor.class));
        return doctorDTO;
    }

    @Override
    public String deleteDoctor(long did) {
        doctorRepository.deleteById(did);
        return "Doctor with ID " + did + " deleted successfully";
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(doctor -> modelMapper.map(doctor, DoctorDTO.class)).toList();
    }


    public DoctorDTO updateDoctor(DoctorDTO doctorDTO) {
        doctorRepository.save(modelMapper.map(doctorDTO, Doctor.class));
        return doctorDTO;
    }
}
