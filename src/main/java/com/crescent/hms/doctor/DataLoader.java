package com.crescent.hms.doctor;

import com.crescent.hms.doctor.model.Doctor;
import com.crescent.hms.doctor.model.Specialty;
import com.crescent.hms.doctor.repository.DoctorRepository;
import com.crescent.hms.doctor.repository.SpecialtyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final DoctorRepository doctorRepository;
    private final SpecialtyRepository specialtyRepository;

    public DataLoader(DoctorRepository doctorRepository, SpecialtyRepository specialtyRepository) {
        this.doctorRepository = doctorRepository;
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading Doctor Data...");

        // 1. Create Specialties
        Specialty cardio = new Specialty();
        cardio.setName("Cardiology");

        Specialty derma = new Specialty();
        derma.setName("Dermatology");

        specialtyRepository.save(cardio);
        specialtyRepository.save(derma);

        // 2. Create Doctors
        // Dr. Smith - Cardiologist - Available
        Doctor doc1 = new Doctor();
        doc1.setName("Dr. Smith");
        doc1.setUsername("dr_smith");
        doc1.setSpecialty(cardio);
        doc1.setAvailable(true);

        // Dr. Jane - Dermatologist - Available
        Doctor doc2 = new Doctor();
        doc2.setName("Dr. Jane Doe");
        doc2.setUsername("dr_jane");
        doc2.setSpecialty(derma);
        doc2.setAvailable(true);

        // Dr. House - Cardiologist - NOT Available (For testing)
        Doctor doc3 = new Doctor();
        doc3.setName("Dr. Gregory House");
        doc3.setUsername("dr_house");
        doc3.setSpecialty(cardio);
        doc3.setAvailable(false);

        doctorRepository.save(doc1);
        doctorRepository.save(doc2);
        doctorRepository.save(doc3);

        System.out.println("Doctor Data Loaded Successfully!");
    }
}