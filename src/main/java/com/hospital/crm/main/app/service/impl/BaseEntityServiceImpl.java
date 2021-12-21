package com.hospital.crm.main.app.service.impl;

import com.hospital.crm.main.app.dao.api.BaseEntityDao;
import com.hospital.crm.main.app.service.api.BaseEntityService;

import java.util.List;
import java.util.Map;

public abstract class BaseEntityServiceImpl<E> implements BaseEntityService<E> {

    protected final BaseEntityDao<E> baseEntityDao;

    protected BaseEntityServiceImpl(BaseEntityDao<E> baseEntityDao) {
        this.baseEntityDao = baseEntityDao;
    }


    @Override
    public E create(E entity) {
        return baseEntityDao.create(entity);
    }

    @Override
    public E update(E entity) {
        return baseEntityDao.update(entity);
    }

    @Override
    public List<E> get(Map<String, String> filter) {
        return baseEntityDao.get(filter);
    }

    @Override
    public void delete(Map<String, String> filter) {
        baseEntityDao.delete(filter);
    }
}
