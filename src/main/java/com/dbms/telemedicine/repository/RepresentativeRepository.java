package com.dbms.telemedicine.repository;

import com.dbms.telemedicine.model.CompositeKeys.RepresentativePK;
import com.dbms.telemedicine.model.Patient;
import com.dbms.telemedicine.model.Representative;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepresentativeRepository extends CrudRepository<Representative, RepresentativePK>{
    Representative getByEmailId(String emailId);
    List<Representative> getByRepresentativeId(String representativeId);
    List<Representative> getByPatientId(String patientId);
}