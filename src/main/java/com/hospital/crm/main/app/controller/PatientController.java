package com.hospital.crm.main.app.controller;

import com.hospital.crm.main.app.model.Patient;
import com.hospital.crm.main.app.service.api.PatientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.hospital.crm.main.app.controller.ApiConstants.PATIENT_API;

@RestController
@RequestMapping(PATIENT_API)
public class PatientController extends EntityController<Patient, UUID> {


    public PatientController(PatientService patientService) {
        super(patientService);
    }

    @Override
    protected void setId(UUID uuid, Patient entity) {
        entity.setId(uuid);
    }
}
