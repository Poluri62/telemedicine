package com.dbms.telemedicine.model.CompositeKeys;

public class PaymentPK {
    private String paymentId;
    private String appointmentId;

    public PaymentPK() {
    }

    public PaymentPK(String paymentId, String appointmentId) {
        this.paymentId = paymentId;
        this.appointmentId = appointmentId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }
}
