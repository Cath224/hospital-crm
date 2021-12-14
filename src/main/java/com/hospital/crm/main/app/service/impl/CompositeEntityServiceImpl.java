package com.hospital.crm.main.app.service.impl;

import com.hospital.crm.main.app.dao.api.CompositeEntityDao;
import com.hospital.crm.main.app.service.api.CompositeEntityService;

public abstract class CompositeEntityServiceImpl<E> extends BaseEntityServiceImpl<E> implements CompositeEntityService<E> {


    protected CompositeEntityServiceImpl(CompositeEntityDao<E> baseEntityDao) {
        super(baseEntityDao);
    }

}
