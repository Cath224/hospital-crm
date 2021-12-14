package com.hospital.crm.main.app.dao.impl;

import com.hospital.crm.main.app.dao.api.MedicationDao;
import com.hospital.crm.main.app.model.Medication;
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
public class MedicationDaoImpl implements MedicationDao {

    private static final RowMapper<Medication> MAPPER = new BeanPropertyRowMapper<>(Medication.class);

    private static final String SELECT_BY_ID = "SELECT * FROM hospital_crm.medication WHERE id = ?";
    private static final String SELECT_BY_IDS = "SELECT * FROM hospital_crm.medication WHERE id in (?)";
    private static final String SELECT_ALL = "SELECT * FROM hospital_crm.medication";
    private static final String SELECT_WHERE = " WHERE %s";
    private static final String INSERT = "INSERT INTO hospital_crm.medication (branch_id, name, description, serial_number, indications, contraindications, number) values(?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE hospital_crm.medication SET (branch_id, name, description, serial_number, indications, contraindications, number) = (?, ?, ?, ?, ?, ?, ?) WHERE id = ?";
    private static final String DELETE = "DELETE FROM hospital_crm.medication WHERE id = ?";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Medication create(Medication entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((conn) -> {
            PreparedStatement statement = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setObject(1, entity.getBranchId());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getDescription());
            statement.setString(4, entity.getSerialNumber());
            statement.setString(5, entity.getIndications());
            statement.setString(6, entity.getContraindications());
            statement.setInt(7, entity.getNumber());
            return statement;
        }, keyHolder);
        Map<String, Object> keys = keyHolder.getKeys();
        if (keys == null) {
            throw new RuntimeException();
        }
        return jdbcTemplate.queryForObject(SELECT_BY_ID, MAPPER, keys.get("id"));
    }

    @Override
    public Medication update(Medication entity) {
        UUID id = entity.getId();
        jdbcTemplate.update((conn) -> {
            PreparedStatement statement = conn.prepareStatement(UPDATE);
            statement.setObject(1, entity.getBranchId());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getDescription());
            statement.setString(4, entity.getSerialNumber());
            statement.setString(5, entity.getIndications());
            statement.setString(6, entity.getContraindications());
            statement.setInt(7, entity.getNumber());
            statement.setObject(8, id);
            return statement;
        });
        return jdbcTemplate.queryForObject(SELECT_BY_ID, MAPPER, id);
    }

    @Override
    public List<Medication> get(Map<String, String> filter) {
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
        String branchId = filter.get("branch_id");
        if (branchId != null) {
            conditions.add("branch_id = ?");
            values.add(branchId);
        }
        String name = filter.get("name");
        if (name != null) {
            conditions.add("name = ?");
            values.add(name);
        }
        String description = filter.get("description");
        if (description != null) {
            conditions.add("description = ?");
            values.add(description);
        }
        String serialNumber = filter.get("serialNumber");
        if (serialNumber != null) {
            conditions.add("office_id = ?");
            values.add(serialNumber);
        }
        String indications = filter.get("indications");
        if (indications != null) {
            conditions.add("indications = ?");
            values.add(indications);
        }
        String contraindications = filter.get("contraindications");
        if (contraindications != null) {
            conditions.add("contraindications = ?");
            values.add(contraindications);
        }
        String number = filter.get("number");
        if (number != null) {
            conditions.add("number = ?");
            values.add(number);
        }
        return jdbcTemplate.query(String.format(SELECT_ALL + SELECT_WHERE,
                String.join(" AND ", conditions)), MAPPER, values.toArray());
    }

    @Override
    public Medication getById(UUID id) {
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
    public List<Medication> getByIds(Set<UUID> ids) {
        Set<String> parsedIds = new HashSet<>(ids.size());
        for (UUID id : ids) {
            parsedIds.add(id.toString());
        }
        return jdbcTemplate.query(SELECT_BY_IDS, MAPPER, String.join(", ", parsedIds));
    }
}
