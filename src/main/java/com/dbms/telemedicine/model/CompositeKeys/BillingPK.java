package com.dbms.telemedicine.model.CompositeKeys;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class BillingPK {
    private String billingId;
    private String paymentId;
    private String patientId;
    private String representativeId;

    public BillingPK() {
    }

    public BillingPK(String billingId, String paymentId, String patientId, String representativeId) {
        this.billingId = billingId;
        this.paymentId = paymentId;
        this.patientId = patientId;
        this.representativeId = representativeId;
    }

    public String getBillingId() {
        return billingId;
    }

    public void setBillingId(String billingId) {
        this.billingId = billingId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getRepresentativeId() {
        return representativeId;
    }

    public void setRepresentativeId(String representativeId) {
        this.representativeId = representativeId;
    }
}
