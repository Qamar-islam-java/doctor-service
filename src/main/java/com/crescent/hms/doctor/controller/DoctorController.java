package com.crescent.hms.doctor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @GetMapping("/my-profile")
    public ResponseEntity<String> getMyProfile() {
        return ResponseEntity.ok("Welcome Doctor! Here is your sensitive data.");
    }
}