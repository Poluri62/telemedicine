package com.dbms.telemedicine.repository;

import com.dbms.telemedicine.model.CompositeKeys.PatientReportPK;
import com.dbms.telemedicine.model.Patient;
import com.dbms.telemedicine.model.PatientReport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientReportRepository extends CrudRepository<PatientReport, PatientReportPK>{
    List<PatientReport> getAllByPatientId(String patientId);
    void deleteByPatientIdAndPatientReportId(String patientId, String patientReportId);
}