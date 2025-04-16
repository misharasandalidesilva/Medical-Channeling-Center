package org.example.helthfirstchannelingcenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class BookAppoinment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column( columnDefinition = "VARCHAR(36)", unique = true, nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID AppId;
    private String fullName;
    private String phone;
    private String doctorName;
    private String appointmentDate;
    private String message;

    @ManyToOne
    private User user;

}









