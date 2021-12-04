package com.hospitalcrm.mainapp.model;

import java.util.UUID;

public class DiagnosisMeddicine {
    private UUID diagnosisId;
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
}
