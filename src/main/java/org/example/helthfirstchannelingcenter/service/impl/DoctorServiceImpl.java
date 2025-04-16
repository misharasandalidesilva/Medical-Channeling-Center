package org.example.helthfirstchannelingcenter.service.impl;

import jakarta.transaction.Transactional;
import org.example.helthfirstchannelingcenter.dto.DoctorDTO;
import org.example.helthfirstchannelingcenter.entity.Doctor;
import org.example.helthfirstchannelingcenter.repo.DoctorRepository;
import org.example.helthfirstchannelingcenter.service.DoctorService;
import org.example.helthfirstchannelingcenter.utill.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(doctor -> modelMapper.map(doctor, DoctorDTO.class)).toList();
    }

    @Override
    public int deleteDoctor(UUID id) {
        doctorRepository.deleteById(id);
        return VarList.OK;
    }

    @Override
    public DoctorDTO updateDoctor(DoctorDTO doctorDTO){
        if (doctorRepository.existsById(doctorDTO.getDid())) {
            return modelMapper.map(doctorRepository.save(modelMapper.map(doctorDTO, Doctor.class)), DoctorDTO.class);
        } else {
           return doctorDTO;

        }
    }

}
