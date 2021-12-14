package com.hospital.crm.main.app.service.api;

import java.util.List;
import java.util.Map;

public interface BaseEntityService<E> {

    E create(E entity);

    E update(E entity);

    List<E> get(Map<String, String> filter);
}
