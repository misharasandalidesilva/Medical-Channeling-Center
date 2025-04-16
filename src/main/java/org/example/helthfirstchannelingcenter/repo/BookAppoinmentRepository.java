package org.example.helthfirstchannelingcenter.repo;

import org.example.helthfirstchannelingcenter.entity.BookAppoinment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookAppoinmentRepository extends JpaRepository<BookAppoinment, UUID> {
}
