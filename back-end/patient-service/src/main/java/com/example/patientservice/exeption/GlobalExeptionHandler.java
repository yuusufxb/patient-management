package com.example.patientservice.exeption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExeptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExeptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationExeption(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>() ;
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(),error.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);
    }
    @ExceptionHandler(EmailAlreadyExistExeption.class)
    public ResponseEntity<Map<String,String>> handleEmailAlreadyExistExeption(EmailAlreadyExistExeption ex){
        Map<String,String> errors = new HashMap<>();
        log.warn(ex.getMessage());
        errors.put("message","email already exists");
        return ResponseEntity.badRequest().body(errors);
    }
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String,String>> handlePatientNotFoundExeption(PatientNotFoundException ex){
        Map<String,String> error = new HashMap<>() ;
        error.put("message","patient not found") ;
        return ResponseEntity.badRequest().body(error);
    }
}
