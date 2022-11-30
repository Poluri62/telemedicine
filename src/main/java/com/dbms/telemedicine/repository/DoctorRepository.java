package com.dbms.telemedicine.repository;

import com.dbms.telemedicine.model.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, String>{
    Doctor getByEmailId(String emailId);
}