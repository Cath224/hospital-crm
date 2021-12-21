package com.hospital.crm.main.app.service.impl;

import com.hospital.crm.main.app.dao.api.PatientVisitDao;
import com.hospital.crm.main.app.model.DoctorPatientStatistic;
import com.hospital.crm.main.app.model.PatientVisit;
import com.hospital.crm.main.app.service.api.PatientVisitService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientVisitServiceImpl extends EntityServiceImpl<PatientVisit, UUID> implements PatientVisitService {

    private final PatientVisitDao patientVisitDao;

    public PatientVisitServiceImpl(PatientVisitDao patientVisitDao) {
        super(patientVisitDao);
        this.patientVisitDao = patientVisitDao;
    }

    @Override
    public List<DoctorPatientStatistic> getPatientVisitStatisticsByDoctorId(UUID doctorId) {
        return patientVisitDao.getPatientVisitStatisticsByDoctorId(doctorId);
    }
}
