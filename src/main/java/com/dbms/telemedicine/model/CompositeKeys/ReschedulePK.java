package com.dbms.telemedicine.model.CompositeKeys;

public class ReschedulePK {
    private String appointmentId;
    private String doctorId;


    public ReschedulePK() {
    }

    public ReschedulePK(String appointmentId, String doctorId) {
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}
