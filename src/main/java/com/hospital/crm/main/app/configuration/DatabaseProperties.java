package com.hospital.crm.main.app.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring.datasource")
public class DatabaseProperties {


    private String username;
    private String password;
    private String host;
    private Integer port;
    private String rdmsUrl;
    private String databaseName;
    private String rdmsUrlFull;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getRdmsUrl() {
        return rdmsUrl;
    }

    public void setRdmsUrl(String rdmsUrl) {
        this.rdmsUrl = rdmsUrl;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getRdmsUrlFull() {
        return rdmsUrlFull;
    }

    public void setRdmsUrlFull(String rdmsUrlFull) {
        this.rdmsUrlFull = rdmsUrlFull;
    }
}
