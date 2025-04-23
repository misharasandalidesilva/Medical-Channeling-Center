package org.example.helthfirstchannelingcenter.service.impl;

import org.example.helthfirstchannelingcenter.dto.BookAppoinmentDTO;
import org.example.helthfirstchannelingcenter.entity.BookAppoinment;
import org.example.helthfirstchannelingcenter.repo.BookAppoinmentRepository;
import org.example.helthfirstchannelingcenter.repo.DoctorRepository;
import org.example.helthfirstchannelingcenter.service.BookAppoinmentService;
import org.example.helthfirstchannelingcenter.utill.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookAppoinmentImpl implements BookAppoinmentService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookAppoinmentRepository bookAppoinmentRepository;



    @Override
    public int deleteAppoinment(UUID appId) {
        if (bookAppoinmentRepository.existsById(appId)) {
            bookAppoinmentRepository.deleteById(appId);
            return VarList.OK;
        }
        return VarList.Not_Found;
    }

    @Override
    public int saveAppoinments(BookAppoinmentDTO bookAppoinmentDTO) {
        BookAppoinment bookAppoinment = modelMapper.map(bookAppoinmentDTO, BookAppoinment.class);
        bookAppoinmentRepository.save(bookAppoinment);
        return VarList.Created;
    }

    @Override
    public List<BookAppoinmentDTO> getAppoinmentsPatientId(UUID pid) {
        List<BookAppoinment> appointments = bookAppoinmentRepository.findByPatient_pid(pid);
        return appointments.stream().map(appointment -> modelMapper.map(appointment, BookAppoinmentDTO.class)).toList();
    }

    @Override
    public List<BookAppoinmentDTO> getAppoinmentsDoctorName(String name) {
        List<BookAppoinment> appointments = bookAppoinmentRepository.findByDoctorName(name);
        return appointments.stream().map(appointment -> modelMapper.map(appointment, BookAppoinmentDTO.class)).toList();
    }

    @Override
    public List<BookAppoinmentDTO> getAllAppointments() {
        List<BookAppoinment> appointments = bookAppoinmentRepository.findAll();
        return appointments.stream().map(appointment -> modelMapper.map(appointment, BookAppoinmentDTO.class)).toList();
    }
}





