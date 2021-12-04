package com.hospitalcrm.mainapp.model;

import java.util.UUID;

public class PatientVisit {
    private UUID id;
    private UUID doctorId;
    private UUID patientId;
    private int actualTimestamp;
    private int planedTimestamp;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public int getActualTimestamp() {
        return actualTimestamp;
    }

    public void setActualTimestamp(int actualTimestamp) {
        this.actualTimestamp = actualTimestamp;
    }

    public int getPlanedTimestamp() {
        return planedTimestamp;
    }

    public void setPlanedTimestamp(int planedTimestamp) {
        this.planedTimestamp = planedTimestamp;
    }
}
