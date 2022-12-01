package com.dbms.telemedicine.model.CompositeKeys;

public class AppointmentDetailsPK {
    private String appointmentId;
    private String serviceId;
    private String patientId;
    private String doctorId;

    public AppointmentDetailsPK() {
    }

    public AppointmentDetailsPK(String appointmentId, String serviceId, String patientId, String doctorId) {
        this.appointmentId = appointmentId;
        this.serviceId = serviceId;
        this.patientId = patientId;
        this.doctorId = doctorId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}
