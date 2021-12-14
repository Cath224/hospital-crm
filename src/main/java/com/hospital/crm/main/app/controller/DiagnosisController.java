package com.hospital.crm.main.app.controller;

import com.hospital.crm.main.app.model.Diagnosis;
import com.hospital.crm.main.app.service.api.DiagnosisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.hospital.crm.main.app.controller.ApiConstants.DIAGNOSIS_API;

@RestController
@RequestMapping(DIAGNOSIS_API)
public class DiagnosisController extends EntityController<Diagnosis, UUID> {

    public DiagnosisController(DiagnosisService diagnosisService) {
        super(diagnosisService);
    }

    @Override
    protected void setId(UUID uuid, Diagnosis entity) {
        entity.setId(uuid);
    }
}
