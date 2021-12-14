package com.hospital.crm.main.app.service.impl;

import com.hospital.crm.main.app.dao.api.DoctorDao;
import com.hospital.crm.main.app.model.Doctor;
import com.hospital.crm.main.app.service.api.DoctorService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DoctorServiceImpl extends EntityServiceImpl<Doctor, UUID> implements DoctorService {

    public DoctorServiceImpl(DoctorDao doctorDao) {
        super(doctorDao);
    }
}
