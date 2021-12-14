package com.hospital.crm.main.app.controller;

import com.hospital.crm.main.app.model.Doctor;
import com.hospital.crm.main.app.service.api.DoctorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.hospital.crm.main.app.controller.ApiConstants.DOCTOR_API;

@RestController
@RequestMapping(DOCTOR_API)
public class DoctorController extends EntityController<Doctor, UUID> {

    public DoctorController(DoctorService doctorService) {
        super(doctorService);
    }

    @Override
    protected void setId(UUID uuid, Doctor entity) {
        entity.setId(uuid);
    }

}
