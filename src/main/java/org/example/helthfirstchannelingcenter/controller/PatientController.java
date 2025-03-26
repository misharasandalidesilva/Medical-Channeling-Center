package org.example.helthfirstchannelingcenter.controller;

import jakarta.validation.Valid;
import org.example.helthfirstchannelingcenter.dto.PatientDTO;
import org.example.helthfirstchannelingcenter.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("api/v1/patient")
@RestController
@CrossOrigin(origins = "http://localhost:63342/")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/savePatient")
    public ResponseEntity<?> savePatient(@Valid @RequestBody PatientDTO patientDTO, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.savePatient(patientDTO));
    }

    @GetMapping("/getAllPatients")
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/getPatient/{pid}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable long pid) {
        PatientDTO patient = patientService.getPatientById(pid);
        if (patient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(patient);
    }

    @DeleteMapping("/deletePatient/{pid}")
    public ResponseEntity<String> deletePatient(@PathVariable long pid) {
        return ResponseEntity.ok(patientService.deletePatient(pid));
    }
}

