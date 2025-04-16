package org.example.helthfirstchannelingcenter.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.helthfirstchannelingcenter.entity.Doctor;
import org.example.helthfirstchannelingcenter.entity.User;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookAppoinmentDTO {
    private UUID AppId;
//    @NotBlank(message = "Full Name cannot be empty")
    private String fullName;

//    @NotBlank(message = "Phone number is required")
//    @Pattern(regexp = "^[0-9]{10,15}$", message = "Phone number must be between 10 to 15 digits")
    private String phone;

    private String appointmentDate;

    private String doctorName;


    private String message;
    private User user;

}



