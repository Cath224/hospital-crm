package com.hospital.crm.main.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoctorPatientStatistic {

    private int month;
    private int numberOfPatients;


    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getNumberOfPatients() {
        return numberOfPatients;
    }

    public void setNumberOfPatients(int numberOfPatients) {
        this.numberOfPatients = numberOfPatients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoctorPatientStatistic)) return false;
        DoctorPatientStatistic that = (DoctorPatientStatistic) o;
        return month == that.month && numberOfPatients == that.numberOfPatients;
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, numberOfPatients);
    }
}
