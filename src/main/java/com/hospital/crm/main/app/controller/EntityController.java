package com.hospital.crm.main.app.controller;

import com.hospital.crm.main.app.service.api.EntityService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public abstract class EntityController<E, Id> extends BaseEntityController<E> {


    private final EntityService<E, Id> entityService;


    protected EntityController(EntityService<E, Id> entityService) {
        super(entityService);
        this.entityService = entityService;
    }

    @PutMapping("{id}")
    public E update(@PathVariable Id id, @Valid @RequestBody E entity) {
        setId(id, entity);
        return entityService.update(entity);
    }

    @GetMapping("{id}")
    public E getById(@PathVariable Id id) {
        return entityService.getById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Id id) {
        entityService.deleteById(id);
    }

    protected abstract void setId(Id id, E entity);
}
