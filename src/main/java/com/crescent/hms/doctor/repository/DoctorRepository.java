package com.crescent.hms.doctor.repository;

import com.crescent.hms.doctor.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findBySpecialty_Name(String specialtyName);
    List<Doctor> findByAvailableTrue();
    List<Doctor> findBySpecialty_NameAndAvailableTrue(String specialtyName);

}