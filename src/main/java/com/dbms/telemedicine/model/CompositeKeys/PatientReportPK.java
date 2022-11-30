package com.dbms.telemedicine.model.CompositeKeys;

public class PatientReportPK {
    private String patientId;
    private String patientReportId;

    public PatientReportPK() {
    }

    public PatientReportPK(String patientId, String phoneNumber) {
        this.patientId = patientId;
        this.patientReportId = phoneNumber;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientReportId() {
        return patientReportId;
    }

    public void setPatientReportId(String patientReportId) {
        this.patientReportId = patientReportId;
    }
}
