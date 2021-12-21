package com.hospital.crm.main.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoctorExperience {

    @NotNull
    private UUID doctorId;
    @NotNull
    private UUID branchId;
    @NotNull
    private LocalDate startPracticingDate;
    private int numberOfPatients;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoctorExperience that)) return false;
        return numberOfPatients == that.numberOfPatients
                && Objects.equals(doctorId, that.doctorId)
                && Objects.equals(branchId, that.branchId)
                && Objects.equals(startPracticingDate, that.startPracticingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId, branchId, startPracticingDate, numberOfPatients);
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public UUID getBranchId() {
        return branchId;
    }

    public void setBranchId(UUID branchId) {
        this.branchId = branchId;
    }

    public LocalDate getStartPracticingDate() {
        return startPracticingDate;
    }

    public void setStartPracticingDate(LocalDate startPracticingDate) {
        this.startPracticingDate = startPracticingDate;
    }

    public int getNumberOfPatients() {
        return numberOfPatients;
    }

    public void setNumberOfPatients(int numberOfPatients) {
        this.numberOfPatients = numberOfPatients;
    }
}
