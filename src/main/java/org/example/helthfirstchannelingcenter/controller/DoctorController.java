package org.example.helthfirstchannelingcenter.controller;

import jakarta.validation.Valid;
import org.example.helthfirstchannelingcenter.dto.DoctorDTO;
import org.example.helthfirstchannelingcenter.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("api/v1/doctor")
@RestController
@CrossOrigin(origins = "http://localhost:63342/")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/savedoctor")
    public ResponseEntity<?> saveDoctor(@Valid @RequestBody DoctorDTO doctorDTO, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }
        return ResponseEntity.ok(doctorService.saveDoctor(doctorDTO));
    }

    @PutMapping("/updatedoctor")
    public ResponseEntity<?> updateDoctor(@Valid @RequestBody DoctorDTO doctorDTO, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }
        return ResponseEntity.ok(doctorService.saveDoctor(doctorDTO));
    }

    @DeleteMapping("/deletedoctor/{did}")
    public ResponseEntity<String> deleteDoctor(@PathVariable long did) {
        return ResponseEntity.ok(doctorService.deleteDoctor(did));
    }

    @GetMapping("/getdoctors")
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }
}
