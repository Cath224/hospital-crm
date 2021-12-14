package com.hospital.crm.main.app.service.impl;

import com.hospital.crm.main.app.dao.api.DoctorExperienceDao;
import com.hospital.crm.main.app.model.DoctorExperience;
import com.hospital.crm.main.app.service.api.DoctorExperienceService;
import org.springframework.stereotype.Service;

@Service
public class DoctorExperienceServiceImpl extends CompositeEntityServiceImpl<DoctorExperience> implements DoctorExperienceService {


    public DoctorExperienceServiceImpl(DoctorExperienceDao doctorExperienceDao) {
        super(doctorExperienceDao);
    }

}
