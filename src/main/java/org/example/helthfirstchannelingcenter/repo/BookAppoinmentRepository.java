package org.example.helthfirstchannelingcenter.repo;

import org.example.helthfirstchannelingcenter.entity.BookAppoinment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookAppoinmentRepository extends JpaRepository<BookAppoinment, UUID> {
    List<BookAppoinment> findByPatient_pid(UUID pid);


    List<BookAppoinment> findByDoctorName(String name);
}
