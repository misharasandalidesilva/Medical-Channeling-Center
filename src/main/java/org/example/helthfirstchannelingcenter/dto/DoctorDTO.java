package org.example.helthfirstchannelingcenter.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorDTO {
    private long did;

    @NotBlank(message = "Doctor name is required")
    @Size(min = 2, max = 50, message = "Doctor name should be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Specialization is required")
    @Size(min = 3, message = "Specialization must be at least 3 characters long")
    private String specialization;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String contactNumber;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits")
    private String email;
}
