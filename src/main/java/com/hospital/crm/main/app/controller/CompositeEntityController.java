package com.hospital.crm.main.app.controller;

import com.hospital.crm.main.app.service.api.CompositeEntityService;

public abstract class CompositeEntityController<E> extends BaseEntityController<E> {


    protected CompositeEntityController(CompositeEntityService<E> baseEntityService) {
        super(baseEntityService);
    }

}
