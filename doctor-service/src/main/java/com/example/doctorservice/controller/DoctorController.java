package com.example.doctorservice.controller;

import com.example.doctorservice.model.Doctor;
import com.example.doctorservice.repository.DoctorRepository;
import com.example.doctorservice.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    private DoctorService doctorService ;
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService ;
    }
    @GetMapping
    public ResponseEntity<List<DoctorRepository>> getdoctors(){
        List<Doctor> doctors =
    }
}
