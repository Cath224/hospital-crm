package com.hospital.crm.main.app.controller;

import com.hospital.crm.main.app.model.Medication;
import com.hospital.crm.main.app.service.api.MedicationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.hospital.crm.main.app.controller.ApiConstants.MEDICATION_API;

@RestController
@RequestMapping(MEDICATION_API)
public class MedicationController extends EntityController<Medication, UUID> {


    public MedicationController(MedicationService medicationService) {
        super(medicationService);
    }

    @Override
    protected void setId(UUID uuid, Medication entity) {
        entity.setId(uuid);
    }
}
