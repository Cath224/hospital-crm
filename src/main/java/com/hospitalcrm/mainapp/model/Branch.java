package com.hospitalcrm.mainapp.model;

import java.util.Objects;
import java.util.UUID;

public class Branch {
    private UUID id;
    private String name;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return id.equals(branch.id) &&
                name.equals(branch.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
