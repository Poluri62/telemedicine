package com.dbms.telemedicine.model.CompositeKeys;

public class ServiceDoctorDetailsPK {
    private String serviceId;
    private String doctorId;

    public ServiceDoctorDetailsPK() {
    }

    public ServiceDoctorDetailsPK(String serviceId, String doctorId) {
        this.serviceId = serviceId;
        this.doctorId = doctorId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}
