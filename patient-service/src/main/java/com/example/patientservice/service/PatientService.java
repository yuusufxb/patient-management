package com.example.patientservice.service;

import com.example.patientservice.dto.PatientRequestDTO;
import com.example.patientservice.dto.PatientResponseDTO;
import com.example.patientservice.exeption.EmailAlreadyExistExeption;
import com.example.patientservice.exeption.PatientNotFoundException;
import com.example.patientservice.mapper.PatientMapper;
import com.example.patientservice.model.Patient;
import com.example.patientservice.repository.PatientRepository;
import java.util.List ;
import java.util.UUID;

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
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistExeption("email already exists -> "+patientRequestDTO.getEmail()) ;
        } ;
        Patient newPatient = patientRepository.save(PatientMapper.ToModel(patientRequestDTO));
        return PatientMapper.ToDTO(newPatient);
    }
    public PatientResponseDTO updatePatient(UUID id , PatientRequestDTO patientRequestDTO){
        Patient oldPatient = patientRepository.findById(id).orElseThrow(()-> new PatientNotFoundException("patient not found")) ;
        if(!oldPatient.getEmail().equals(patientRequestDTO.getEmail()) && patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistExeption("email already exists -> "+patientRequestDTO.getEmail()) ;
        } ;
        Patient updatedPatient = PatientMapper.updatePatient(oldPatient,patientRequestDTO) ;
        patientRepository.save(updatedPatient);
        return PatientMapper.ToDTO(updatedPatient);
    }


}
