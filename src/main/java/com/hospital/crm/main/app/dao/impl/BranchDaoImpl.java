package com.hospital.crm.main.app.dao.impl;

import com.hospital.crm.main.app.dao.api.BranchDao;
import com.hospital.crm.main.app.model.Branch;
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
public class BranchDaoImpl implements BranchDao {

    private static final RowMapper<Branch> MAPPER = new BeanPropertyRowMapper<>(Branch.class);

    private static final String SELECT_BY_ID = "SELECT * FROM hospital_crm.branch WHERE id = ?";
    private static final String SELECT_BY_IDS = "SELECT * FROM hospital_crm.branch WHERE id in (?)";
    private static final String SELECT_ALL = "SELECT * FROM hospital_crm.branch";
    private static final String SELECT_WHERE = " WHERE %s";
    private static final String DELETE_ALL = "DELETE FROM hospital_crm.branch";
    private static final String INSERT = "INSERT INTO hospital_crm.branch (name) values(?)";
    private static final String UPDATE = "UPDATE hospital_crm.branch SET (name) = (?) WHERE id = ?";
    private static final String DELETE = "DELETE FROM hospital_crm.branch WHERE id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Branch create(Branch entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((conn) -> {
            PreparedStatement statement = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getName());
            return statement;
        }, keyHolder);
        Map<String, Object> keys = keyHolder.getKeys();
        if (keys == null) {
            throw new RuntimeException();
        }
        return jdbcTemplate.queryForObject(SELECT_BY_ID, MAPPER, keys.get("id"));
    }

    @Override
    public Branch update(Branch entity) {
        UUID id = entity.getId();
        jdbcTemplate.update((conn) -> {
            PreparedStatement statement = conn.prepareStatement(UPDATE);
            statement.setString(1, entity.getName());
            statement.setObject(2, id);
            return statement;
        });
        return jdbcTemplate.queryForObject(SELECT_BY_ID, MAPPER, id);
    }

    @Override
    public List<Branch> get(Map<String, String> filter) {
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
        jdbcTemplate.update(String.format(DELETE_ALL + SELECT_WHERE,
                String.join(" AND ", conditions)), values.toArray());
    }

    @Override
    public Branch getById(UUID id) {
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
    public List<Branch> getByIds(Set<UUID> ids) {
        Set<String> parsedIds = new HashSet<>(ids.size());
        for (UUID id : ids) {
            parsedIds.add(id.toString());
        }
        return jdbcTemplate.query(SELECT_BY_IDS, MAPPER, String.join(", ", parsedIds));
    }

}
