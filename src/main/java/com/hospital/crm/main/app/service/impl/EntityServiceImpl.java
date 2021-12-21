package com.hospital.crm.main.app.service.impl;

import com.hospital.crm.main.app.dao.api.EntityDao;
import com.hospital.crm.main.app.service.api.EntityService;

import java.util.List;
import java.util.Set;

public abstract class EntityServiceImpl<E, Id> extends BaseEntityServiceImpl<E> implements EntityService<E, Id> {

    protected final EntityDao<E, Id> entityDao;


    protected EntityServiceImpl(EntityDao<E, Id> entityDao) {
        super(entityDao);
        this.entityDao = entityDao;
    }

    @Override
    public E getById(Id id) {
        return entityDao.getById(id);
    }


    @Override
    public void deleteById(Id id) {
        entityDao.deleteById(id);
    }

    @Override
    public List<E> getByIds(Set<Id> ids) {
        return entityDao.getByIds(ids);
    }
}
