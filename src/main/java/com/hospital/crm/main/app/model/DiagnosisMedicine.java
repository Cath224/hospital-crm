package com.hospital.crm.main.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiagnosisMedicine {
    @NotNull
    private UUID diagnosisId;
    @NotNull
    private UUID medicineId;
    private String description;
    private int number;

    public UUID getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(UUID diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public UUID getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(UUID medicineId) {
        this.medicineId = medicineId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        DiagnosisMedicine that = (DiagnosisMedicine) o;
        return number == that.number &&
                diagnosisId.equals(that.diagnosisId) &&
                medicineId.equals(that.medicineId) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diagnosisId, medicineId, description, number);
    }

}
