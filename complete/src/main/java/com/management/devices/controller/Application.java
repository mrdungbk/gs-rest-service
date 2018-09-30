package com.management.devices.controller;

import com.management.devices.database.dao.StoreProcedureDAO;
import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static StoreProcedureDAO storeProcedureDAO;
    public static void main(String[] args) {
        storeProcedureDAO = new StoreProcedureDAO();
        SpringApplication.run(Application.class, args);
        BasicConfigurator.configure();
    }
}
