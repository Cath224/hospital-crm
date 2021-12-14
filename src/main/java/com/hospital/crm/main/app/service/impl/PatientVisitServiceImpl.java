package com.hospital.crm.main.app.service.impl;

import com.hospital.crm.main.app.dao.api.PatientVisitDao;
import com.hospital.crm.main.app.model.PatientVisit;
import com.hospital.crm.main.app.service.api.PatientVisitService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PatientVisitServiceImpl extends EntityServiceImpl<PatientVisit, UUID> implements PatientVisitService {

    public PatientVisitServiceImpl(PatientVisitDao patientVisitDao) {
        super(patientVisitDao);
    }
}
