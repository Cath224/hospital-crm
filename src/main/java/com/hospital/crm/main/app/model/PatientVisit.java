package com.hospital.crm.main.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientVisit {

    private UUID id;
    @NotNull
    private UUID doctorId;
    @NotNull
    private UUID patientId;
    @NotNull
    private UUID branchId;

    private LocalDateTime actualTimestamp;
    @NotBlank
    private LocalDateTime planedTimestamp;


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

    public LocalDateTime getActualTimestamp() {
        return actualTimestamp;
    }

    public void setActualTimestamp(LocalDateTime actualTimestamp) {
        this.actualTimestamp = actualTimestamp;
    }

    public LocalDateTime getPlanedTimestamp() {
        return planedTimestamp;
    }

    public void setPlanedTimestamp(LocalDateTime planedTimestamp) {
        this.planedTimestamp = planedTimestamp;
    }

    public UUID getBranchId() {
        return branchId;
    }

    public void setBranchId(UUID branchId) {
        this.branchId = branchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientVisit)) return false;
        PatientVisit that = (PatientVisit) o;
        return Objects.equals(id, that.id) && Objects.equals(doctorId, that.doctorId) && Objects.equals(patientId, that.patientId) && Objects.equals(branchId, that.branchId) && Objects.equals(actualTimestamp, that.actualTimestamp) && Objects.equals(planedTimestamp, that.planedTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctorId, patientId, branchId, actualTimestamp, planedTimestamp);
    }
}
