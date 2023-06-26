package org.jhay.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jhay.annotation.Age;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRequest {
    @NotEmpty(message = "username must not be empty")
    @Size(min = 4, message = "username must be more than 4 characters")
    private String username;
    @NotEmpty(message = "username must not be empty")
    @Email(message = "must be a valid email")
    private String email;
    @NotEmpty(message = "Password must not be empty")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*=/,.:;|?])(?=.*[0-9]).{8,}$", message = "Password must be a strong password")
    private String password;
    @Age(message = "must be 16 years old or older")
    private LocalDate dateOfBirth;
}
