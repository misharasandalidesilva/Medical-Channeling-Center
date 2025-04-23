package org.example.helthfirstchannelingcenter.repo;

import org.example.helthfirstchannelingcenter.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
    List<Patient> findByUser_Uid(UUID userId);
}
