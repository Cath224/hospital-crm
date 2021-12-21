package com.hospital.crm.main.app.service.api;

import com.hospital.crm.main.app.model.DoctorPatientStatistic;
import com.hospital.crm.main.app.model.PatientVisit;

import java.util.List;
import java.util.UUID;

public interface PatientVisitService extends EntityService<PatientVisit, UUID> {

    List<DoctorPatientStatistic> getPatientVisitStatisticsByDoctorId(UUID doctorId);

}
