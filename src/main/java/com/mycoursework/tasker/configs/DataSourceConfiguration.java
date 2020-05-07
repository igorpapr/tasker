package com.mycoursework.tasker.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/taskerdb?&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&rewriteBatchedStatements=true");
//        dataSource.setUsername("root");
//        dataSource.setPassword("admin");
//        return dataSource;
//    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://ec2-46-137-156-205.eu-west-1.compute.amazonaws.com:5432/dar8qogfcohdrf");
        dataSource.setUsername("dbyxlbwkgndjez");
        dataSource.setPassword("df10ad043b3bcd88ae3e21f7754136dff5c1a7c34588acbda9ac307a8fe20cd9");
        return dataSource;
    }
}
