package com.hospitalcrm.mainapp.model;

import java.util.Objects;
import java.util.UUID;

public class Patient {
    private UUID id;
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
        Patient patient = (Patient) o;
        return birthday == patient.birthday &&
                id.equals(patient.id) &&
                firstName.equals(patient.firstName) &&
                lastName.equals(patient.lastName) &&
                gender.equals(patient.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, gender, birthday);
    }
}
