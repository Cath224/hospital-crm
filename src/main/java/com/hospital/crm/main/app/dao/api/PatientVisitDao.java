package com.hospital.crm.main.app.dao.api;

import com.hospital.crm.main.app.model.DoctorPatientStatistic;
import com.hospital.crm.main.app.model.PatientVisit;

import java.util.List;
import java.util.UUID;

public interface PatientVisitDao extends EntityDao<PatientVisit, UUID> {

    List<DoctorPatientStatistic> getPatientVisitStatisticsByDoctorId(UUID doctorId);

}
