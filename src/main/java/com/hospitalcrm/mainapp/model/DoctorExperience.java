package com.hospitalcrm.mainapp.model;

import java.util.UUID;

public class DoctorExperience {
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
