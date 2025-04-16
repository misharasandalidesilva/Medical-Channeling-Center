package com.medicalchannelingcenter.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminProfileDTO {

    private Long id;

    @NotBlank(message = "Full name is required")
    @Size(min = 3, message = "Name should be at least 3 characters long")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    private String email;

    private String profileImageUrl;
}
