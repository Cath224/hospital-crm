package com.hospital.crm.main.app.dao.impl;

import com.hospital.crm.main.app.dao.api.PatientDao;
import com.hospital.crm.main.app.model.Patient;
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
import java.util.*;

@Repository
public class PatientDaoImpl implements PatientDao {

    private static final RowMapper<Patient> MAPPER = new BeanPropertyRowMapper<>(Patient.class);

    private static final String SELECT_BY_ID = "SELECT * FROM hospital_crm.patient WHERE id = ?";
    private static final String SELECT_BY_IDS = "SELECT * FROM hospital_crm.patient WHERE id in (?)";
    private static final String SELECT_ALL = "SELECT * FROM hospital_crm.patient";
    private static final String DELETE_ALL = "DELETE FROM hospital_crm.patient";
    private static final String SELECT_WHERE = " WHERE %s";
    private static final String INSERT = "INSERT INTO hospital_crm.patient (first_name, last_name, birthday, sex, phone) values(?, ?, ?, ?::hospital_crm.sex, ?)";
    private static final String UPDATE = "UPDATE hospital_crm.patient SET (first_name, last_name, birthday, sex, phone) = (?, ?, ?, ?::hospital_crm.sex, ?) WHERE id = ?";
    private static final String DELETE = "DELETE FROM hospital_crm.patient WHERE id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Patient create(Patient entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((conn) -> {
            PreparedStatement statement = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setDate(3, Date.valueOf(entity.getBirthday()));
            statement.setString(4, entity.getSex());
            statement.setString(5, entity.getPhone());
            return statement;
        }, keyHolder);
        Map<String, Object> keys = keyHolder.getKeys();
        if (keys == null) {
            throw new RuntimeException();
        }
        return jdbcTemplate.queryForObject(SELECT_BY_ID, MAPPER, keys.get("id"));
    }

    @Override
    public Patient update(Patient entity) {
        UUID id = entity.getId();
        jdbcTemplate.update((conn) -> {
            PreparedStatement statement = conn.prepareStatement(UPDATE);
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setDate(3, Date.valueOf(entity.getBirthday()));
            statement.setString(4, entity.getSex());
            statement.setString(5, entity.getPhone());
            statement.setObject(6, id);
            return statement;
        });
        return jdbcTemplate.queryForObject(SELECT_BY_ID, MAPPER, id);
    }

    @Override
    public List<Patient> get(Map<String, String> filter) {
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
        String firstNameValue = filter.get("first_name");
        if (firstNameValue != null) {
            conditions.add("first_name = ?");
            values.add(firstNameValue);
        }
        String secondNameValue = filter.get("last_name");
        if (secondNameValue != null) {
            conditions.add("last_name = ?");
            values.add(secondNameValue);
        }
        String birthdayValue = filter.get("birthday");
        if (birthdayValue != null) {
            conditions.add("birthday = ?");
            values.add(LocalDate.parse(birthdayValue));
        }
        String sex = filter.get("sex");
        if (sex != null) {
            conditions.add("sex = ?");
            values.add(sex);
        }
        String phone = filter.get("phone");
        if (phone != null) {
            conditions.add("phone = ?");
            values.add(Integer.valueOf(phone));
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
        String firstNameValue = filter.get("first_name");
        if (firstNameValue != null) {
            conditions.add("first_name = ?");
            values.add(firstNameValue);
        }
        String secondNameValue = filter.get("last_name");
        if (secondNameValue != null) {
            conditions.add("last_name = ?");
            values.add(secondNameValue);
        }
        String birthdayValue = filter.get("birthday");
        if (birthdayValue != null) {
            conditions.add("birthday = ?");
            values.add(LocalDate.parse(birthdayValue));
        }
        String sex = filter.get("sex");
        if (sex != null) {
            conditions.add("sex = ?");
            values.add(sex);
        }
        String phone = filter.get("phone");
        if (phone != null) {
            conditions.add("phone = ?");
            values.add(Integer.valueOf(phone));
        }
        jdbcTemplate.update(String.format(DELETE_ALL + SELECT_WHERE,
                String.join(" AND ", conditions)), values.toArray());
    }

    @Override
    public Patient getById(UUID id) {
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
    public List<Patient> getByIds(Set<UUID> ids) {
        Set<String> parsedIds = new HashSet<>(ids.size());
        for (UUID id : ids) {
            parsedIds.add(id.toString());
        }
        return jdbcTemplate.query(SELECT_BY_IDS, MAPPER, String.join(", ", parsedIds));
    }
}
