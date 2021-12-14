package com.hospital.crm.main.app.service.impl;

import com.hospital.crm.main.app.dao.api.OfficeDao;
import com.hospital.crm.main.app.model.Office;
import com.hospital.crm.main.app.service.api.OfficeService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OfficeServiceImpl extends EntityServiceImpl<Office, UUID> implements OfficeService {

    public OfficeServiceImpl(OfficeDao officeDao) {
        super(officeDao);
    }
}
