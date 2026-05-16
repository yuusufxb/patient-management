package com.example.patientservice.exeption;

public class EmailAlreadyExistExeption extends RuntimeException {
    public EmailAlreadyExistExeption(String message) {
        super(message);
    }

}
