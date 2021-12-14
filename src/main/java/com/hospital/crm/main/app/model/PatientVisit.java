package com.hospital.crm.main.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientVisit {

    private UUID id;
    private UUID doctorId;
    private UUID patientId;
    private LocalDateTime actualTimestamp;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientVisit that = (PatientVisit) o;
        return actualTimestamp == that.actualTimestamp &&
                planedTimestamp == that.planedTimestamp &&
                id.equals(that.id) &&
                doctorId.equals(that.doctorId) &&
                patientId.equals(that.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctorId, patientId, actualTimestamp, planedTimestamp);
    }
}
