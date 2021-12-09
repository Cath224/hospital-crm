package com.hospitalcrm.mainapp.model;

import java.util.Objects;
import java.util.UUID;

public class DoctorExperience {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorExperience that = (DoctorExperience) o;
        return startPracticingDate == that.startPracticingDate &&
                doctorId.equals(that.doctorId) &&
                branchId.equals(that.branchId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId, branchId, startPracticingDate);
    }

    private UUID doctorId;
    private UUID branchId;
    private int startPracticingDate;


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

    public int getStartPracticingDate() {
        return startPracticingDate;
    }

    public void setStartPracticingDate(int startPracticingDate) {
        this.startPracticingDate = startPracticingDate;
    }
}
