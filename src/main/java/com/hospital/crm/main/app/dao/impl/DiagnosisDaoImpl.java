package com.hospital.crm.main.app.dao.impl;

import com.hospital.crm.main.app.dao.api.DiagnosisDao;
import com.hospital.crm.main.app.model.Diagnosis;
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
public class DiagnosisDaoImpl implements DiagnosisDao {

    private static final RowMapper<Diagnosis> MAPPER = new BeanPropertyRowMapper<>(Diagnosis.class);

    private static final String SELECT_BY_ID = "SELECT * FROM hospital_crm.diagnosis WHERE id = ?";
    private static final String SELECT_BY_IDS = "SELECT * FROM hospital_crm.diagnosis WHERE id in (?)";
    private static final String SELECT_ALL = "SELECT * FROM hospital_crm.diagnosis";
    private static final String SELECT_WHERE = " WHERE %s";
    private static final String DELETE_ALL = "DELETE FROM hospital_crm.diagnosis";
    private static final String INSERT = "INSERT INTO hospital_crm.diagnosis (description, patient_visit_id) values(?, ?)";
    private static final String UPDATE = "UPDATE hospital_crm.diagnosis SET (description, patient_visit_id) = (?, ?) WHERE id = ?";
    private static final String DELETE = "DELETE FROM hospital_crm.diagnosis WHERE id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Diagnosis create(Diagnosis entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((conn) -> {
            PreparedStatement statement = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getDescription());
            statement.setObject(2, entity.getPatientVisitId());
            return statement;
        }, keyHolder);
        Map<String, Object> keys = keyHolder.getKeys();
        if (keys == null) {
            throw new RuntimeException();
        }
        return jdbcTemplate.queryForObject(SELECT_BY_ID, MAPPER, keys.get("id"));
    }

    @Override
    public Diagnosis update(Diagnosis entity) {
        UUID id = entity.getId();
        jdbcTemplate.update((conn) -> {
            PreparedStatement statement = conn.prepareStatement(UPDATE);
            statement.setString(1, entity.getDescription());
            statement.setObject(2, entity.getPatientVisitId());
            statement.setObject(3, id);
            return statement;
        });
        return jdbcTemplate.queryForObject(SELECT_BY_ID, MAPPER, id);
    }

    @Override
    public List<Diagnosis> get(Map<String, String> filter) {
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
        String description = filter.get("description");
        if (description != null) {
            conditions.add("description = ?");
            values.add(description);
        }
        String patientVisitId = filter.get("patient_visit_id");
        if (patientVisitId != null) {
            conditions.add("patient_visit_id = ?");
            values.add(patientVisitId);
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
        String description = filter.get("description");
        if (description != null) {
            conditions.add("description = ?");
            values.add(description);
        }
        String patientVisitId = filter.get("patient_visit_id");
        if (patientVisitId != null) {
            conditions.add("patient_visit_id = ?");
            values.add(patientVisitId);
        }
        jdbcTemplate.update(String.format(DELETE_ALL + SELECT_WHERE,
                String.join(" AND ", conditions)), values.toArray());
    }

    @Override
    public Diagnosis getById(UUID id) {
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
    public List<Diagnosis> getByIds(Set<UUID> ids) {
        Set<String> parsedIds = new HashSet<>(ids.size());
        for (UUID id : ids) {
            parsedIds.add(id.toString());
        }
        return jdbcTemplate.query(SELECT_BY_IDS, MAPPER, String.join(", ", parsedIds));
    }
}
