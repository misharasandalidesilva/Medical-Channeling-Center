package org.example.helthfirstchannelingcenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private UUID uid;
    private String contactNumber;
    private String email;
    private String password;
    private String role;
}
