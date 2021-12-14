package com.hospital.crm.main.app.controller;

import com.hospital.crm.main.app.model.DoctorExperience;
import com.hospital.crm.main.app.service.api.DoctorExperienceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.hospital.crm.main.app.controller.ApiConstants.DOCTOR_EXPERIENCE_API;

@RestController
@RequestMapping(DOCTOR_EXPERIENCE_API)
public class DoctorExperienceController extends CompositeEntityController<DoctorExperience> {


    public DoctorExperienceController(DoctorExperienceService doctorExperienceService) {
        super(doctorExperienceService);
    }

}
