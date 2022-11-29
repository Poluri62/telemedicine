package com.dbms.telemedicine.repository;

import com.dbms.telemedicine.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, String>{
    Patient getByEmailId(String emailId);
}