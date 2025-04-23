package org.example.helthfirstchannelingcenter.repo;

import org.example.helthfirstchannelingcenter.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
    Object findByUser_Uid(UUID userId);
}
