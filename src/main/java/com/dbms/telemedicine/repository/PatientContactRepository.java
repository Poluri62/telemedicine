package com.dbms.telemedicine.repository;

import com.dbms.telemedicine.model.CompositeKeys.PatientContactPK;
import com.dbms.telemedicine.model.PatientContact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientContactRepository extends CrudRepository<PatientContact, PatientContactPK> {
    List<PatientContact> getAllByPatientId(String patientId);
}
