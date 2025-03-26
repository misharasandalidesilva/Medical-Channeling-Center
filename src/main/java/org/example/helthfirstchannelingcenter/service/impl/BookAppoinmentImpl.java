package org.example.helthfirstchannelingcenter.service.impl;

import jakarta.transaction.Transactional;
import org.example.helthfirstchannelingcenter.dto.BookAppoinmentDTO;
import org.example.helthfirstchannelingcenter.entity.BookAppoinment;
import org.example.helthfirstchannelingcenter.repo.BookAppoinmentRepository;
import org.example.helthfirstchannelingcenter.repo.DoctorRepository;
import org.example.helthfirstchannelingcenter.service.BookAppoinmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookAppoinmentImpl implements BookAppoinmentService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BookAppoinmentRepository bookAppoinmentRepository;

    @Override
    public BookAppoinmentDTO saveBookAppoinment(BookAppoinmentDTO bookAppoinmentDTO) {
        bookAppoinmentRepository.save(modelMapper.map(bookAppoinmentDTO, BookAppoinment.class));
        return bookAppoinmentDTO;
    }

    @Override
    public List<BookAppoinmentDTO> getAllAppointments() {
        List<BookAppoinment> bookAppoinments = bookAppoinmentRepository.findAll();
        return bookAppoinments.stream().map(bookAppoinment -> modelMapper.map(bookAppoinment, BookAppoinmentDTO.class)).toList();
    }

    @Override
    public String cancelBookAppoinment(long bid) {
        return "";
    }
}






