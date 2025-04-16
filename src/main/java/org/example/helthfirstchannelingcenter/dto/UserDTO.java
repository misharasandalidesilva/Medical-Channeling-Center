package org.example.helthfirstchannelingcenter.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private UUID uid;
    private String name;
    private String nic;
    private String age;
    private String contactNumber;
    @Column(unique = true)
    private String email;
    private String address;
    private String password;
    private String role;
}
