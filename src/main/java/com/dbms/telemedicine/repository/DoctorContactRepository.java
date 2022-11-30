package com.dbms.telemedicine.repository;

import com.dbms.telemedicine.model.CompositeKeys.DoctorContactPK;
import com.dbms.telemedicine.model.CompositeKeys.PatientContactPK;
import com.dbms.telemedicine.model.DoctorContact;
import com.dbms.telemedicine.model.PatientContact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorContactRepository extends CrudRepository<DoctorContact, DoctorContactPK> {
    List<DoctorContact> getAllByDoctorId(String doctorId);
}
