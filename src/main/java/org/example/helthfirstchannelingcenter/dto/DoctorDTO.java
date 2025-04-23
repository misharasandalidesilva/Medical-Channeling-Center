package org.example.helthfirstchannelingcenter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.helthfirstchannelingcenter.entity.User;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorDTO {
    private UUID did;

    @NotBlank(message = "Doctor name is required")
    @Size(min = 2, max = 50, message = "Doctor name should be between 2 and 50 characters")
    private String name;
    private String gender;
    private String birthday;
    private String address;
    private String specialization;
    private User user;

}
