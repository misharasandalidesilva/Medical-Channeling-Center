package org.example.helthfirstchannelingcenter.service;

import org.example.helthfirstchannelingcenter.dto.BookAppoinmentDTO;

import java.util.List;
import java.util.UUID;

public interface BookAppoinmentService {
    List<BookAppoinmentDTO> getAllAppointments();

    int deleteAppoinment(UUID appId);

    int saveAppoinments(BookAppoinmentDTO bookAppoinmentDTO);

    List<BookAppoinmentDTO> getAppoinmentsPatientId(UUID pid);

    List<BookAppoinmentDTO> getAppoinmentsDoctorName(String name);
}

