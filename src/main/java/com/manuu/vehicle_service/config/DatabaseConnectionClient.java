package com.manuu.vehicle_service.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

@Component
public class DatabaseConnectionClient {

    @Autowired
    private DataSource dataSource;

    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }

}
