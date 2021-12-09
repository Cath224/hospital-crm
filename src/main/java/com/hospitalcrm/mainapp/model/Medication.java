package com.hospitalcrm.mainapp.model;

import java.util.Objects;
import java.util.UUID;

public class Medication {
    private UUID id;
    private UUID branchId;
    private String name;
    private String description;
    private String serialNumber;
    private String indications;
    private String contraindications;
    private int number;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getBranchId() {
        return branchId;
    }

    public void setBranchId(UUID branchId) {
        this.branchId = branchId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getIndications() {
        return indications;
    }

    public void setIndications(String indications) {
        this.indications = indications;
    }

    public String getContraindications() {
        return contraindications;
    }

    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medication that = (Medication) o;
        return number == that.number &&
                id.equals(that.id) &&
                branchId.equals(that.branchId) &&
                name.equals(that.name) &&
                description.equals(that.description) &&
                serialNumber.equals(that.serialNumber) &&
                indications.equals(that.indications) &&
                contraindications.equals(that.contraindications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, branchId, name, description, serialNumber, indications, contraindications, number);
    }
}
