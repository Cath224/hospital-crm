package com.hospital.crm.main.app.service.impl;

import com.hospital.crm.main.app.dao.api.PatientDao;
import com.hospital.crm.main.app.model.Patient;
import com.hospital.crm.main.app.service.api.PatientService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PatientServiceImpl extends EntityServiceImpl<Patient, UUID> implements PatientService {

    public PatientServiceImpl(PatientDao patientDao) {
        super(patientDao);
    }
}
