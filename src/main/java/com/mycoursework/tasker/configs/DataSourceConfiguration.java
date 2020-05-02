package com.mycoursework.tasker.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class DataSourceConfiguration {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&rewriteBatchedStatements=true");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        return dataSource;
    }
}
