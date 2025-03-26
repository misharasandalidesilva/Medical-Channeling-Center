package org.example.helthfirstchannelingcenter.controller;

import jakarta.validation.Valid;
import org.example.helthfirstchannelingcenter.dto.BookAppoinmentDTO;
import org.example.helthfirstchannelingcenter.service.BookAppoinmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("api/v1/bookappoinment")
@RestController
@CrossOrigin(origins = "http://localhost:63342/")
public class BookAppoinmentController {

    @Autowired
    private BookAppoinmentService bookAppoinmentService;

    @PostMapping("/saveBookappoinment")
    public ResponseEntity<?> saveBookAppoinment(@Valid @RequestBody BookAppoinmentDTO bookAppoinmentDTO, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(bookAppoinmentService.saveBookAppoinment(bookAppoinmentDTO));
    }


    @GetMapping("/getAllBookAppoinment")
    public ResponseEntity<List<BookAppoinmentDTO>> getAllBookAppoinment() {
        return ResponseEntity.ok(bookAppoinmentService.getAllAppointments());
    }

    @DeleteMapping("/cancelBookAppoinment/{Bid}")
    public ResponseEntity<String> cancelBookAppoinment(@PathVariable long Bid) {
        return ResponseEntity.ok(bookAppoinmentService.cancelBookAppoinment(Bid));
    }
}
