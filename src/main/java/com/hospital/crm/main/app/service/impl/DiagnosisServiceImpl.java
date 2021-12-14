package com.hospital.crm.main.app.service.impl;

import com.hospital.crm.main.app.dao.api.DiagnosisDao;
import com.hospital.crm.main.app.model.Diagnosis;
import com.hospital.crm.main.app.service.api.DiagnosisService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DiagnosisServiceImpl extends EntityServiceImpl<Diagnosis, UUID> implements DiagnosisService {


    public DiagnosisServiceImpl(DiagnosisDao diagnosisDao) {
        super(diagnosisDao);
    }
}
