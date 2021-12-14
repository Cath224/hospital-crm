package com.hospital.crm.main.app.dao.api;

import java.util.List;
import java.util.Set;

public interface EntityDao<E, Id> extends BaseEntityDao<E> {

    E getById(Id id);

    void deleteById(Id id);

    List<E> getByIds(Set<Id> ids);
}
