package com.hospitalcrm.mainapp.model;


import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;
    private String gender;
    private int birthday;

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
        Person person = (Person) o;
        return birthday == person.birthday &&
                firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                gender.equals(person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, gender, birthday);
    }
}
