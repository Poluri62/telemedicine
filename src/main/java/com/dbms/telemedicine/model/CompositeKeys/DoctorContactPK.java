package com.dbms.telemedicine.model.CompositeKeys;

public class DoctorContactPK {
    private String doctorId;
    private String phoneNumber;

    public DoctorContactPK() {
    }

    public DoctorContactPK(String doctorId, String phoneNumber) {
        this.doctorId = doctorId;
        this.phoneNumber = phoneNumber;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
