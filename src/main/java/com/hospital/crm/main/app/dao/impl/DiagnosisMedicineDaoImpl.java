package com.hospital.crm.main.app.dao.impl;

import com.hospital.crm.main.app.dao.api.DiagnosisMedicineDao;
import com.hospital.crm.main.app.model.DiagnosisMedicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class DiagnosisMedicineDaoImpl implements DiagnosisMedicineDao {

    private static final RowMapper<DiagnosisMedicine> MAPPER = new BeanPropertyRowMapper<>(DiagnosisMedicine.class);

    private static final String SELECT_BY_ID = "SELECT * FROM hospital_crm.diagnosis_medicine WHERE diagnosis_id = ? AND medicine_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM hospital_crm.diagnosis_medicine";
    private static final String SELECT_WHERE = " WHERE %s";
    private static final String INSERT = "INSERT INTO hospital_crm.diagnosis_medicine (diagnosis_id, medicine_id, number, description) values(?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE hospital_crm.diagnosis_medicine SET (number, description) = (?, ?) WHERE diagnosis_id = ? AND medicine_id = ?";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public DiagnosisMedicine create(DiagnosisMedicine entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((conn) -> {
            PreparedStatement statement = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setObject(1, entity.getDiagnosisId());
            statement.setObject(2, entity.getMedicineId());
            statement.setInt(3, entity.getNumber());
            statement.setString(4, entity.getDescription());
            return statement;
        }, keyHolder);
        Map<String, Object> keys = keyHolder.getKeys();
        if (keys == null) {
            throw new RuntimeException();
        }
        return jdbcTemplate.queryForObject(SELECT_BY_ID, MAPPER, keys.get("diagnosis_id"), keys.get("medicine_id"));
    }

    @Override
    public DiagnosisMedicine update(DiagnosisMedicine entity) {
        UUID diagnosisId = entity.getDiagnosisId();
        UUID medicineId = entity.getMedicineId();
        jdbcTemplate.update((conn) -> {
            PreparedStatement statement = conn.prepareStatement(UPDATE);
            statement.setInt(1, entity.getNumber());
            statement.setString(2, entity.getDescription());
            statement.setObject(3, diagnosisId);
            statement.setObject(4, medicineId);
            return statement;
        });
        return jdbcTemplate.queryForObject(SELECT_BY_ID, MAPPER, diagnosisId, medicineId);
    }

    @Override
    public List<DiagnosisMedicine> get(Map<String, String> filter) {
        if (filter == null || filter.isEmpty()) {
            return jdbcTemplate.query(SELECT_ALL, MAPPER);
        }
        int size = filter.size();
        List<String> conditions = new ArrayList<>(size);
        String diagnosisId = filter.get("diagnosis_id");
        List<Object> values = new ArrayList<>(size);
        if (diagnosisId != null) {
            conditions.add("diagnosis_id = ?");
            values.add(UUID.fromString(diagnosisId));
        }
        String medicineId = filter.get("medicine_id");
        if (medicineId != null) {
            conditions.add("medicine_id = ?");
            values.add(UUID.fromString(medicineId));
        }
        String number = filter.get("number");
        if (number != null) {
            conditions.add("number = ?");
            values.add(Integer.valueOf(number));
        }
        String description = filter.get("description");
        if (description != null) {
            conditions.add("description = ?");
            values.add(description);
        }
        return jdbcTemplate.query(String.format(SELECT_ALL + SELECT_WHERE,
                String.join(" AND ", conditions)), MAPPER, values.toArray());
    }
}
