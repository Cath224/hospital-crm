package com.hospital.crm.main.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Diagnosis {


    private UUID id;
    @NotNull
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnosis diagnosis = (Diagnosis) o;
        return id.equals(diagnosis.id) &&
                patientVisitId.equals(diagnosis.patientVisitId) &&
                description.equals(diagnosis.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientVisitId, description);
    }

}
