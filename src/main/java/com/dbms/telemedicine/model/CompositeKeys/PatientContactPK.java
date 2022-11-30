package com.dbms.telemedicine.model.CompositeKeys;

public class PatientContactPK {
    private String patientId;
    private String phoneNumber;

    public PatientContactPK() {
    }

    public PatientContactPK(String patientId, String phoneNumber) {
        this.patientId = patientId;
        this.phoneNumber = phoneNumber;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
