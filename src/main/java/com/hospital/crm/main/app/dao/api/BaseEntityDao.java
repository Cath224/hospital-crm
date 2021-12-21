package com.hospital.crm.main.app.dao.api;

import java.util.List;
import java.util.Map;

public interface BaseEntityDao<E> {

    E create(E entity);

    E update(E entity);

    List<E> get(Map<String, String> filter);

    void delete(Map<String, String> filter);

}
