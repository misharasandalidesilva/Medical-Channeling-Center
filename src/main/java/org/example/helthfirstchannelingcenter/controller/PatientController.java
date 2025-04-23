package org.example.helthfirstchannelingcenter.controller;

import jakarta.validation.Valid;
import org.example.helthfirstchannelingcenter.dto.PatientDTO;
import org.example.helthfirstchannelingcenter.dto.ResponseDTO;
import org.example.helthfirstchannelingcenter.service.PatientService;
import org.example.helthfirstchannelingcenter.utill.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/patient")
@RestController
@CrossOrigin(origins = "http://localhost:63342/")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/savePatient")
    public ResponseEntity<ResponseDTO> savePatient(@Valid @RequestBody PatientDTO patientDTO) {
        try {
            return ResponseEntity.ok(new ResponseDTO(VarList.Created, "Success", patientService.savePatient(patientDTO)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/getAllPatients")
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @PutMapping("/updatePatient")
    public ResponseEntity<ResponseDTO> updatePatient(@Valid @RequestBody PatientDTO patientDTO) {
        try {
            return ResponseEntity.ok(new ResponseDTO(VarList.Created, "Success", patientService.savePatient(patientDTO)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/deletePatient/{id}")
    public ResponseEntity<ResponseDTO> deletePatient(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(new ResponseDTO(VarList.Created, "Success", patientService.deletePatient(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/getPatient/{userId}")
    public ResponseEntity<List<PatientDTO>> getPersonalDataByUserId(@PathVariable UUID userId) {
        List<PatientDTO> patientsByUserId = patientService.getPatient(userId);

        if (patientsByUserId == null || patientsByUserId.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content if nothing found
        }

        return ResponseEntity.ok(patientsByUserId); // 200 OK with list of PatientDTO
    }

}
