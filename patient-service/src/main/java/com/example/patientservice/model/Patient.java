package com.example.patientservice.model;

import com.example.patientservice.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id ;


    @NotNull
    private String name ;

    @NotNull
    @Email
    @Column(unique = true)
    private String email ;

    @NotNull
    @Column(unique = true )
    private Integer phoneNumber ;

    @Enumerated(EnumType.STRING)
    private Gender gender ;

    @NotNull
    private String address ;

    @NotNull
    private LocalDate dateOfBirth ;



    @NotNull
    private LocalDate registeredDate ;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public Gender getGender() { return gender; }

    public void setGender(Gender gender) { this.gender = gender; }
    public Integer getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(Integer phoneNumber) { this.phoneNumber = phoneNumber; }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
