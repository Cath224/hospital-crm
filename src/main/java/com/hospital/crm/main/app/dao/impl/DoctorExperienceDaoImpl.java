package com.hospital.crm.main.app.dao.impl;

import com.hospital.crm.main.app.dao.api.DoctorExperienceDao;
import com.hospital.crm.main.app.model.DoctorExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class DoctorExperienceDaoImpl implements DoctorExperienceDao {

    private static final RowMapper<DoctorExperience> MAPPER = new BeanPropertyRowMapper<>(DoctorExperience.class);

    private static final String SELECT_BY_ID = "SELECT * FROM hospital_crm.doctor_experience WHERE doctor_id = ? AND branch_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM hospital_crm.doctor_experience";
    private static final String DELETE_ALL = "DELETE FROM hospital_crm.doctor_experience";
    private static final String SELECT_WHERE = " WHERE %s";
    private static final String INSERT = "INSERT INTO hospital_crm.doctor_experience (doctor_id, branch_id, start_practicing_date) values(?, ?, ?)";
    private static final String UPDATE = "UPDATE hospital_crm.doctor_experience SET (start_practicing_date) = (?) WHERE doctor_id = ? AND branch_id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public DoctorExperience create(DoctorExperience entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((conn) -> {
            PreparedStatement statement = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setObject(1, entity.getDoctorId());
            statement.setObject(2, entity.getBranchId());
            statement.setDate(3, Date.valueOf(entity.getStartPracticingDate()));
            return statement;
        }, keyHolder);
        Map<String, Object> keys = keyHolder.getKeys();
        if (keys == null) {
            throw new RuntimeException();
        }
        return jdbcTemplate.queryForObject(SELECT_BY_ID, MAPPER, keys.get("doctor_id"), keys.get("branch_id"));
    }

    @Override
    public DoctorExperience update(DoctorExperience entity) {
        UUID doctorId = entity.getDoctorId();
        UUID branchId = entity.getBranchId();
        jdbcTemplate.update((conn) -> {
            PreparedStatement statement = conn.prepareStatement(UPDATE);
            statement.setDate(1, Date.valueOf(entity.getStartPracticingDate()));
            statement.setObject(2, doctorId);
            statement.setObject(3, branchId);
            return statement;
        });
        return jdbcTemplate.queryForObject(SELECT_BY_ID, MAPPER, doctorId, branchId);
    }

    @Override
    public List<DoctorExperience> get(Map<String, String> filter) {
        if (filter == null || filter.isEmpty()) {
            return jdbcTemplate.query(SELECT_ALL, MAPPER);
        }
        int size = filter.size();
        List<String> conditions = new ArrayList<>(size);
        String doctorId = filter.get("doctor_id");
        List<Object> values = new ArrayList<>(size);
        if (doctorId != null) {
            conditions.add("doctor_id = ?");
            values.add(UUID.fromString(doctorId));
        }
        String branchId = filter.get("branch_id");
        if (branchId != null) {
            conditions.add("branch_id = ?");
            values.add(UUID.fromString(branchId));
        }
        String startPracticingDate = filter.get("start_practicing_date");
        if (startPracticingDate != null) {
            conditions.add("start_practicing_date = ?");
            values.add(LocalDate.parse(startPracticingDate));
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
        String doctorId = filter.get("doctor_id");
        List<Object> values = new ArrayList<>(size);
        if (doctorId != null) {
            conditions.add("doctor_id = ?");
            values.add(UUID.fromString(doctorId));
        }
        String branchId = filter.get("branch_id");
        if (branchId != null) {
            conditions.add("branch_id = ?");
            values.add(UUID.fromString(branchId));
        }
        String startPracticingDate = filter.get("start_practicing_date");
        if (startPracticingDate != null) {
            conditions.add("start_practicing_date = ?");
            values.add(LocalDate.parse(startPracticingDate));
        }
        jdbcTemplate.update(String.format(DELETE_ALL + SELECT_WHERE,
                String.join(" AND ", conditions)), values.toArray());
    }
}
