package com.example.doctorservice.mapper;

import com.example.doctorservice.dto.DoctorResposeDto;
import com.example.doctorservice.model.Doctor;

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
}
