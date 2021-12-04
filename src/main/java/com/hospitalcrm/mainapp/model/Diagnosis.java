package com.hospitalcrm.mainapp.model;

import java.util.UUID;

public class Diagnosis {
    private UUID id;
    private UUID patientVisitId;
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPatientVisitId() {
        return patientVisitId;
    }

    public void setPatientVisitId(UUID patientVisitId) {
        this.patientVisitId = patientVisitId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
