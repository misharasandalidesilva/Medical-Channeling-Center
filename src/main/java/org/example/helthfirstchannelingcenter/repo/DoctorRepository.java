package org.example.helthfirstchannelingcenter.repo;

import org.example.helthfirstchannelingcenter.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
