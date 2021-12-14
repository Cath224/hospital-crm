package com.hospital.crm.main.app.service.impl;

import com.hospital.crm.main.app.dao.api.CompositeEntityDao;
import com.hospital.crm.main.app.model.DiagnosisMedicine;
import com.hospital.crm.main.app.service.api.DiagnosisMedicineService;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisMedicineServiceImpl extends CompositeEntityServiceImpl<DiagnosisMedicine> implements DiagnosisMedicineService {


    public DiagnosisMedicineServiceImpl(CompositeEntityDao<DiagnosisMedicine> baseEntityDao) {
        super(baseEntityDao);
    }


}
