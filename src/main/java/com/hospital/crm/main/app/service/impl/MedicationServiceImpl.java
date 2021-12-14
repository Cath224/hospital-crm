package com.hospital.crm.main.app.service.impl;

import com.hospital.crm.main.app.dao.api.MedicationDao;
import com.hospital.crm.main.app.model.Medication;
import com.hospital.crm.main.app.service.api.MedicationService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MedicationServiceImpl extends EntityServiceImpl<Medication, UUID> implements MedicationService {


    public MedicationServiceImpl(MedicationDao medicationDao) {
        super(medicationDao);
    }
}
