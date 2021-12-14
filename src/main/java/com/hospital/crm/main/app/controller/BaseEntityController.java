package com.hospital.crm.main.app.controller;

import com.hospital.crm.main.app.service.api.BaseEntityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseEntityController<E> {

    private static final String EQUAL = "==";
    private static final String PATTERN = ";";

    private final BaseEntityService<E> baseEntityService;

    protected BaseEntityController(BaseEntityService<E> baseEntityService) {
        this.baseEntityService = baseEntityService;
    }


    @PostMapping
    public E create(@RequestBody E entity) {
        return baseEntityService.create(entity);
    }

    @GetMapping
    public List<E> get(@RequestParam(name = "filter", required = false) String filter) {
        return baseEntityService.get(parseFilter(filter));
    }

    protected Map<String, String> parseFilter(String filter) {
        if (filter == null || filter.isBlank()) {
            return null;
        }
        String[] conditions = filter.split(PATTERN);
        if (conditions.length == 0) {
            return null;
        }
        Map<String, String> filterParsed = new HashMap<>(conditions.length);
        for (String condition : conditions) {
            String[] filterConditionParts = condition.split(EQUAL);
            if (filterConditionParts.length == 0) {
                continue;
            }
            filterParsed.put(filterConditionParts[0],
                    toSnakeCase(filterConditionParts[1]));
        }
        return filterParsed;
    }

    private String toSnakeCase(String value) {
        if (value == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (char c : value.toCharArray()) {
            char nc = Character.toLowerCase(c);
            if (Character.isUpperCase(c)) {
                result.append('_').append(nc);
            } else {
                result.append(nc);
            }
        }
        return result.toString();
    }
}
