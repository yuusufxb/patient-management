package com.example.doctorservice.dto;

import com.example.doctorservice.enums.Specialisation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

public class DoctorRequestDto {

    @NotBlank(message = "name is required")
    private String name ;

    @NotBlank(message = "email is required")
    @Email(message = "email is not valid")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "phone is required")
    @Pattern(regexp = "\\d{10}" , message = "phone number must contain 10 digits")
    private String phone ;

    @NotBlank(message = "license number is required")
    private String licenseNumber ;

    @NotNull(message = "specialisation is required")
    private Specialisation specialisation ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Specialisation getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(Specialisation specialisation) {
        this.specialisation = specialisation;
    }
}
