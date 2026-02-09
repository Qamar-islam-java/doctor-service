package com.crescent.hms.doctor.controller;

import com.crescent.hms.doctor.model.Doctor;
import com.crescent.hms.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/my-profile")
    public ResponseEntity<String> getMyProfile() {
        return ResponseEntity.ok("Welcome Doctor! Here is your sensitive data.");
    }

    // Create Doctor (Internal Use or Admin)
    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorRepository.save(doctor));
    }

    // Get Doctors by Specialty (For Receptionist)
    @GetMapping("/list/{specialtyName}")
    public ResponseEntity<List<Doctor>> getDoctorsBySpecialty(@PathVariable String specialtyName) {
        // Return only available doctors
        return ResponseEntity.ok(doctorRepository.findBySpecialty_NameAndAvailableTrue(specialtyName));
    }

    // Add this method to Repo if needed, or use the one above and filter in code.
    // For simplicity, let's assume we add the query to repo:
    // List<Doctor> findBySpecialty_NameAndAvailableTrue(String specialtyName);

}