package com.hospital.crm.main.app.dao.impl;

import com.hospital.crm.main.app.dao.api.PatientVisitDao;
import com.hospital.crm.main.app.model.PatientVisit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class PatientVisitDaoImpl implements PatientVisitDao {

    private static final RowMapper<PatientVisit> MAPPER = new BeanPropertyRowMapper<>(PatientVisit.class);

    private static final String SELECT_BY_ID = "SELECT * FROM hospital_crm.patient_visit WHERE id = ?";
    private static final String SELECT_BY_IDS = "SELECT * FROM hospital_crm.patient_visit WHERE id in (?)";
    private static final String SELECT_ALL = "SELECT * FROM hospital_crm.patient_visit";
    private static final String SELECT_WHERE = " WHERE %s";
    private static final String INSERT = "INSERT INTO hospital_crm.patient_visit (doctor_id, patient_id, actual_timestamp, planed_timestamp) values(?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE hospital_crm.patient_visit SET (doctor_id, patient_id, actual_timestamp, planed_timestamp) = (?, ?, ?, ?) WHERE id = ?";
    private static final String DELETE = "DELETE FROM hospital_crm.patient_visit WHERE id = ?";


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public PatientVisit create(PatientVisit entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((conn) -> {
            PreparedStatement statement = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setObject(1, entity.getDoctorId());
            statement.setObject(2, entity.getPatientId());
            statement.setTimestamp(3, entity.getActualTimestamp() != null ? Timestamp.valueOf(entity.getActualTimestamp()) : null);
            statement.setTimestamp(4, entity.getPlanedTimestamp() != null ? Timestamp.valueOf(entity.getPlanedTimestamp()) : null);
            return statement;
        }, keyHolder);
        Map<String, Object> keys = keyHolder.getKeys();
        if (keys == null) {
            throw new RuntimeException();
        }
        return jdbcTemplate.queryForObject(SELECT_BY_ID, MAPPER, keys.get("id"));
    }

    @Override
    public PatientVisit update(PatientVisit entity) {
        UUID id = entity.getId();
        jdbcTemplate.update((conn) -> {
            PreparedStatement statement = conn.prepareStatement(UPDATE);
            statement.setObject(1, entity.getDoctorId());
            statement.setObject(2, entity.getPatientId());
            statement.setTimestamp(3, entity.getActualTimestamp() != null ? Timestamp.valueOf(entity.getActualTimestamp()) : null);
            statement.setTimestamp(4, entity.getPlanedTimestamp() != null ? Timestamp.valueOf(entity.getPlanedTimestamp()) : null);
            statement.setObject(5, id);
            return statement;
        });
        return jdbcTemplate.queryForObject(SELECT_BY_ID, MAPPER, id);
    }

    @Override
    public List<PatientVisit> get(Map<String, String> filter) {
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
        String doctorId = filter.get("doctor_id");
        if (doctorId != null) {
            conditions.add("doctor_id = ?");
            values.add(UUID.fromString(doctorId));
        }
        String patientId = filter.get("patient_id");
        if (patientId != null) {
            conditions.add("patient_id = ?");
            values.add(UUID.fromString(patientId));
        }
        String actualTimestamp = filter.get("actual_timestamp");
        if (actualTimestamp != null) {
            conditions.add("actual_timestamp = ?");
            values.add(LocalDateTime.parse(actualTimestamp));
        }
        String planedTimestamp = filter.get("planed_timestamp");
        if (actualTimestamp != null) {
            conditions.add("planed_timestamp = ?");
            values.add(LocalDateTime.parse(planedTimestamp));
        }
        return jdbcTemplate.query(String.format(SELECT_ALL + SELECT_WHERE,
                String.join(" AND ", conditions)), MAPPER, values.toArray());
    }

    @Override
    public PatientVisit getById(UUID id) {
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
    public List<PatientVisit> getByIds(Set<UUID> ids) {
        Set<String> parsedIds = new HashSet<>(ids.size());
        for (UUID id : ids) {
            parsedIds.add(id.toString());
        }
        return jdbcTemplate.query(SELECT_BY_IDS, MAPPER, String.join(", ", parsedIds));
    }
}
