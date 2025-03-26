package org.example.helthfirstchannelingcenter.service;

import org.example.helthfirstchannelingcenter.dto.DoctorDTO;

import java.util.List;

public interface DoctorService{
    DoctorDTO saveDoctor(DoctorDTO doctorDTO);

    String deleteDoctor(long did);

    List<DoctorDTO> getAllDoctors();


}
