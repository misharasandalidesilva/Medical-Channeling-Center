package org.example.helthfirstchannelingcenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.helthfirstchannelingcenter.entity.User;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDTO {
    private UUID pid;
    private String name;
    private String gender;
    private String birthday;
    private String address;
    private String age;

    private User user;
}
