package com.hospital.crm.main.app.dao.impl;

import com.hospital.crm.main.app.dao.api.OfficeDao;
import com.hospital.crm.main.app.model.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;

@Repository
public class OfficeDaoImpl implements OfficeDao {


    private static final RowMapper<Office> MAPPER = new BeanPropertyRowMapper<>(Office.class);

    private static final String SELECT_BY_ID = "SELECT * FROM hospital_crm.office WHERE id = ?";
    private static final String SELECT_BY_IDS = "SELECT * FROM hospital_crm.office WHERE id in (?)";
    private static final String SELECT_ALL = "SELECT * FROM hospital_crm.office";
    private static final String DELETE_ALL = "DELETE FROM hospital_crm.office";
    private static final String SELECT_WHERE = " WHERE %s";
    private static final String INSERT = "INSERT INTO hospital_crm.office (name, number) values(?, ?)";
    private static final String UPDATE = "UPDATE hospital_crm.office SET (name, number) = (?, ?) WHERE id = ?";
    private static final String DELETE = "DELETE FROM hospital_crm.office WHERE id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Office create(Office entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((conn) -> {
            PreparedStatement statement = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getName());
            statement.setInt(2, entity.getNumber());
            return statement;
        }, keyHolder);
        Map<String, Object> keys = keyHolder.getKeys();
        if (keys == null) {
            throw new RuntimeException();
        }
        return jdbcTemplate.queryForObject(SELECT_BY_ID, MAPPER, keys.get("id"));
    }

    @Override
    public Office update(Office entity) {
        UUID id = entity.getId();
        jdbcTemplate.update((conn) -> {
            PreparedStatement statement = conn.prepareStatement(UPDATE);
            statement.setString(1, entity.getName());
            statement.setInt(2, entity.getNumber());
            statement.setObject(3, id);
            return statement;
        });
        return jdbcTemplate.queryForObject(SELECT_BY_ID, MAPPER, id);
    }

    @Override
    public List<Office> get(Map<String, String> filter) {
        if (filter == null || filter.isEmpty()) {
            return jdbcTemplate.query(SELECT_ALL, MAPPER);
        }
        int size = filter.size();
        List<String> conditions = new ArrayList<>(size);
        String idValue = filter.get("id");
        List<Object> values = new ArrayList<>(size);
        if (idValue != null) {
            conditions.add("id = ?");
            values.add(UUID.fromString(idValue));
        }
        String nameValue = filter.get("name");
        if (nameValue != null) {
            conditions.add("name = ?");
            values.add(nameValue);
        }
        String numberValue = filter.get("number");
        if (numberValue != null) {
            conditions.add("number = ?");
            values.add(numberValue);
        }
        return jdbcTemplate.query(String.format(SELECT_ALL + SELECT_WHERE,
                String.join(" AND ", conditions)), MAPPER, values.toArray());
    }

    @Override
    public void delete(Map<String, String> filter) {
        if (filter == null || filter.isEmpty()) {
            jdbcTemplate.update(DELETE_ALL);
        }
        int size = filter.size();
        List<String> conditions = new ArrayList<>(size);
        String idValue = filter.get("id");
        List<Object> values = new ArrayList<>(size);
        if (idValue != null) {
            conditions.add("id = ?");
            values.add(UUID.fromString(idValue));
        }
        String nameValue = filter.get("name");
        if (nameValue != null) {
            conditions.add("name = ?");
            values.add(nameValue);
        }
        String numberValue = filter.get("number");
        if (numberValue != null) {
            conditions.add("number = ?");
            values.add(numberValue);
        }
        jdbcTemplate.update(String.format(DELETE_ALL + SELECT_WHERE,
                String.join(" AND ", conditions)), values.toArray());
    }

    @Override
    public Office getById(UUID id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, MAPPER, id);
    }

    @Override
    public void deleteById(UUID id) {
        jdbcTemplate.update((conn) -> {
            PreparedStatement statement = conn.prepareStatement(DELETE);
            statement.setObject(1, id);
            return statement;
        });
    }

    @Override
    public List<Office> getByIds(Set<UUID> ids) {
        Set<String> parsedIds = new HashSet<>(ids.size());
        for (UUID id : ids) {
            parsedIds.add(id.toString());
        }
        return jdbcTemplate.query(SELECT_BY_IDS, MAPPER, String.join(", ", parsedIds));
    }
}
