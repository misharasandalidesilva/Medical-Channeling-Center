package org.example.helthfirstchannelingcenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uid", columnDefinition = "VARCHAR(36)", unique = true, nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID uid;
    private String name;
    private String username;
    private String nic;
    private String age;
    private String contactNumber;
    @Column(unique = true)
    private String email;
    private String address;
    private String password;
    private String role;

    User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

