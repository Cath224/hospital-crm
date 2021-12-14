package com.hospital.crm.main.app.service.api;

import java.util.List;
import java.util.Set;

public interface EntityService<E, Id> extends BaseEntityService<E> {


    E getById(Id id);

    void deleteById(Id id);

    List<E> getByIds(Set<Id> ids);

}
