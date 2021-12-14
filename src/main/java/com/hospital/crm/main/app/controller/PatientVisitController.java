package com.hospital.crm.main.app.controller;

import com.hospital.crm.main.app.model.PatientVisit;
import com.hospital.crm.main.app.service.api.PatientVisitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.hospital.crm.main.app.controller.ApiConstants.PATIENT_VISIT_API;

@RestController
@RequestMapping(PATIENT_VISIT_API)
public class PatientVisitController extends EntityController<PatientVisit, UUID> {


    public PatientVisitController(PatientVisitService patientVisitService) {
        super(patientVisitService);
    }

    @Override
    protected void setId(UUID uuid, PatientVisit entity) {
        entity.setId(uuid);
    }
}
