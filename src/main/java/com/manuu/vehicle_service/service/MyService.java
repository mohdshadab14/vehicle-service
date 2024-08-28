package com.manuu.vehicle_service.service;

import com.manuu.vehicle_service.config.DatabaseConnectionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class MyService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MyService(DatabaseConnectionClient dbClient) {
        this.jdbcTemplate = dbClient.getJdbcTemplate();
    }

    public void queryDatabase() {

        String sql = "SELECT * FROM suppliers";


        jdbcTemplate.query(sql, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                System.out.println("Suppplier ID: " + rs.getInt("sid"));
                System.out.println("Supplier Name: " + rs.getString("sname"));
                System.out.println("Rating"+ rs.getString("rating"));
                return null;
            }
        });
    }
}