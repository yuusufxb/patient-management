package com.example.patientservice.service;

import com.example.patientservice.dto.PatientResponseDTO;
import com.example.patientservice.mapper.PatientMapper;
import com.example.patientservice.model.Patient;
import com.example.patientservice.repository.PatientRepository;
import java.util.List ;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private PatientRepository patientRepository ;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository ;
    }

    public List<PatientResponseDTO> getPatient (){
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientMapper::ToDTO).toList();
    }

}
