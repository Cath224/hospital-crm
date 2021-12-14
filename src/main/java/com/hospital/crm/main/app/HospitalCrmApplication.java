package com.hospital.crm.main.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class HospitalCrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalCrmApplication.class, args);
    }

}
