package org.example.helthfirstchannelingcenter.controller;

import jakarta.validation.Valid;
import org.example.helthfirstchannelingcenter.dto.DoctorDTO;
import org.example.helthfirstchannelingcenter.dto.ResponseDTO;
import org.example.helthfirstchannelingcenter.service.DoctorService;
import org.example.helthfirstchannelingcenter.utill.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequestMapping("api/v1/doctor")
@RestController
@CrossOrigin(origins = "http://localhost:63342/")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @PostMapping("/savedoctor")
    public ResponseEntity<ResponseDTO> saveDoctor(@Valid @RequestBody DoctorDTO doctorDTO) {
        try {
            return ResponseEntity.ok(new ResponseDTO(VarList.Created, "Success", doctorService.saveDoctor(doctorDTO)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @PutMapping("/updatedoctor")
    public ResponseEntity<ResponseDTO> updateDoctor(@Valid @RequestBody DoctorDTO doctorDTO) {
        try {
            return ResponseEntity.ok(new ResponseDTO(VarList.Created, "Success", doctorService.updateDoctor(doctorDTO)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/deletedoctor/{id}")
    public ResponseEntity<ResponseDTO> deleteDoctor(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(new ResponseDTO(VarList.Created, "Success", doctorService.deleteDoctor(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @GetMapping("/getdoctors")
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/getdoctorName")
    public ResponseEntity<List<String>> getdoctorName() {
        return ResponseEntity.ok(doctorService.getAllDoctors().stream().map(DoctorDTO::getName).collect(Collectors.toList()));
    }

    @GetMapping("/getdoctor/{userId}")
    public ResponseEntity<DoctorDTO> getDoctorByUserId(@PathVariable UUID userId) {
        DoctorDTO doctor = doctorService.getDoctorByUserId(userId);
        return ResponseEntity.ok(doctor);
    }

}
