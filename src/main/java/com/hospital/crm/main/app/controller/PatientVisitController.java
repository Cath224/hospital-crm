package com.hospital.crm.main.app.controller;

import com.hospital.crm.main.app.model.DoctorPatientStatistic;
import com.hospital.crm.main.app.model.PatientVisit;
import com.hospital.crm.main.app.service.api.PatientVisitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.hospital.crm.main.app.controller.ApiConstants.PATIENT_VISIT_API;

@RestController
@RequestMapping(PATIENT_VISIT_API)
public class PatientVisitController extends EntityController<PatientVisit, UUID> {


    private final PatientVisitService patientVisitService;

    public PatientVisitController(PatientVisitService patientVisitService) {
        super(patientVisitService);
        this.patientVisitService = patientVisitService;
    }

    @Override
    protected void setId(UUID uuid, PatientVisit entity) {
        entity.setId(uuid);
    }

    @GetMapping("statistics/{doctorId}")
    public List<DoctorPatientStatistic> getDoctorStatistics(@PathVariable UUID doctorId) {
        return patientVisitService.getPatientVisitStatisticsByDoctorId(doctorId);
    }
}
