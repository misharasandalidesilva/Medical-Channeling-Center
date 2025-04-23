package org.example.helthfirstchannelingcenter.service;

import org.example.helthfirstchannelingcenter.dto.DoctorDTO;

import java.util.List;
import java.util.UUID;

public interface DoctorService{
    DoctorDTO saveDoctor(DoctorDTO doctorDTO);

    List<DoctorDTO> getAllDoctors();


    int deleteDoctor(UUID id);

    DoctorDTO updateDoctor(DoctorDTO doctorDTO) throws Exception;

    DoctorDTO getDoctorByUserId(UUID userId);
}
