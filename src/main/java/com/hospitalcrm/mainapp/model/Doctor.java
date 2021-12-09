package com.hospitalcrm.mainapp.model;

import java.util.Objects;
import java.util.UUID;

public class Doctor {
    private UUID id;
    private UUID officeId;
    private String firstName;
    private String lastName;
    private String gender;
    private int birthday;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UUID getOfficeId() {
        return officeId;
    }

    public void setOfficeId(UUID officeId) {
        this.officeId = officeId;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return birthday == doctor.birthday &&
                id.equals(doctor.id) &&
                officeId.equals(doctor.officeId) &&
                firstName.equals(doctor.firstName) &&
                lastName.equals(doctor.lastName) &&
                gender.equals(doctor.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, officeId, firstName, lastName, gender, birthday);
    }
}
