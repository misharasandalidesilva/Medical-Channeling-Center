package org.example.helthfirstchannelingcenter.service;

import org.example.helthfirstchannelingcenter.dto.BookAppoinmentDTO;

import java.util.List;

public interface BookAppoinmentService {
    BookAppoinmentDTO saveBookAppoinment(BookAppoinmentDTO bookAppoinmentDTO);

    List<BookAppoinmentDTO> getAllAppointments();

    String cancelBookAppoinment(long bid);
}
