package com.hospitalcrm.mainapp.model;

import java.util.Objects;
import java.util.UUID;

public class office {
    private UUID id;
    private String name;
    private int number;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        office office = (office) o;
        return number == office.number &&
                id.equals(office.id) &&
                name.equals(office.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, number);
    }
}
