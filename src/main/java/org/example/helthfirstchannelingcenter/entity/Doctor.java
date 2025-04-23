package org.example.helthfirstchannelingcenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column( columnDefinition = "VARCHAR(36)", unique = true, nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID did;
    private String name;
    private String gender;
    private String birthday;
    private String address;
    private String specialization;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "user_id", referencedColumnName = "uid")
    private User user;

}
