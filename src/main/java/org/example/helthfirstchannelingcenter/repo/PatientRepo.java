package org.example.helthfirstchannelingcenter.repo;

import org.example.helthfirstchannelingcenter.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
}
