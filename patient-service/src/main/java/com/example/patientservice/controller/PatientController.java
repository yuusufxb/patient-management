package com.example.patientservice.controller;

import com.example.patientservice.dto.PatientRequestDTO;
import com.example.patientservice.dto.PatientResponseDTO;
import com.example.patientservice.dto.validationGroups.CreatePatientValidationGroup;
import com.example.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patient")
@Tag(name = "Patient" , description = "api for managing patients")
public class PatientController {
    private final PatientService patientService ;
    public PatientController(PatientService patientService){
        this.patientService = patientService ;
    }

    @GetMapping
    @Operation(summary = "get patient")
    public ResponseEntity<List<PatientResponseDTO>> getPatient(){
        List<PatientResponseDTO> patients = patientService.getPatient() ;
        return ResponseEntity.ok().body(patients);
    }
    @PostMapping
    @Operation(summary = "create patient ")
    public ResponseEntity<PatientResponseDTO> createPatient(@Validated({Default.class , CreatePatientValidationGroup.class}) @RequestBody PatientRequestDTO patientRequestDTO){
        PatientResponseDTO newPatient = patientService.createPatient(patientRequestDTO);
        return ResponseEntity.ok().body(newPatient);
    }
    @PutMapping("{id}")
    @Operation(summary = "update patient ")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable  UUID id ,@Validated(Default.class) @RequestBody PatientRequestDTO patientRequestDTO){
        PatientResponseDTO updatedPatient = patientService.updatePatient(id,patientRequestDTO);
        return ResponseEntity.ok().body(updatedPatient);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "delete patient")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id){
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
