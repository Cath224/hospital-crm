package com.hospital.crm.main.app.configuration;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Order(1)
@Component
public class OnApplicationStartup implements InitializingBean {

    private static final String CHECK_DATABASE_EXISTS_SQL = "SELECT COUNT(datname) FROM pg_database WHERE datname = '%s'";
    private static final String CREATE_DATABASE_NAME_TEMPLATE_SQL = "CREATE DATABASE %s";

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Autowired
    private DatabaseProperties databaseProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        try (Connection connection = DriverManager.getConnection(databaseProperties.getRdmsUrl() + "/",
                databaseProperties.getUsername(),
                databaseProperties.getPassword());
             Statement statement = connection.createStatement()
        ) {
            String databaseName = databaseProperties.getDatabaseName();
            String checkDatabaseSql = String.format(CHECK_DATABASE_EXISTS_SQL, databaseName);

            ResultSet resultSet = statement.executeQuery(checkDatabaseSql);

            if (resultSet.next()) {
                int result = resultSet.getInt(1);

                if (result >= 1) {
                    dataSourceProperties.setUrl(databaseProperties.getRdmsUrlFull());
                    return;
                }
            }

            statement.executeUpdate(String.format(CREATE_DATABASE_NAME_TEMPLATE_SQL, databaseName));

            dataSourceProperties.setUrl(databaseProperties.getRdmsUrlFull());
        }
    }

}
