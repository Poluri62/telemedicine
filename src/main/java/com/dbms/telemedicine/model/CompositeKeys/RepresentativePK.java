package com.dbms.telemedicine.model.CompositeKeys;

public class RepresentativePK {
    private String representativeId;
    private String patientId;

    public RepresentativePK() {
    }

    public RepresentativePK(String representativeId, String patientId) {
        this.representativeId = representativeId;
        this.patientId = patientId;
    }

    public String getRepresentativeId() {
        return representativeId;
    }

    public void setRepresentativeId(String representativeId) {
        this.representativeId = representativeId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
