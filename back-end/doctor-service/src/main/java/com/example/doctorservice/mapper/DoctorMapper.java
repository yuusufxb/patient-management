package com.example.doctorservice.mapper;

import com.example.doctorservice.dto.DoctorRequestDto;
import com.example.doctorservice.dto.DoctorResposeDto;
import com.example.doctorservice.model.Doctor;

import java.time.LocalDate;
import java.util.List;

public class DoctorMapper {
    public static DoctorResposeDto toDTO(Doctor doctor){
        DoctorResposeDto doctorResposeDto = new DoctorResposeDto() ;
        doctorResposeDto.setId(doctor.getId());
        doctorResposeDto.setName(doctor.getName());
        doctorResposeDto.setEmail(doctor.getEmail());
        doctorResposeDto.setPhone(doctor.getPhone());
        doctorResposeDto.setSpecialisation(doctor.getSpecialisation().toString());
        return doctorResposeDto ;
    }
    public static Doctor toModule(DoctorRequestDto doctorRequestDto){
        Doctor newDoctor = new Doctor();
        newDoctor.setName(doctorRequestDto.getName());
        newDoctor.setEmail(doctorRequestDto.getEmail());
        newDoctor.setDateOfBirth(doctorRequestDto.getDateOfBirth());
        newDoctor.setPhone(doctorRequestDto.getPhone());
        newDoctor.setLicenseNumber(doctorRequestDto.getLicenseNumber());
        newDoctor.setSpecialisation(doctorRequestDto.getSpecialisation());
        return newDoctor ;
    }
}
