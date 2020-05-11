package com.mycoursework.tasker.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://ec2-54-228-209-117.eu-west-1.compute.amazonaws.com:5432/d6dfo4fdpmc115");
        dataSource.setUsername("gmtbmuwhvbiiun");
        dataSource.setPassword("4dc59e4be2d89b404717e898ed8422963c0bd751116746b969484fbf7badf7fd");
        return dataSource;
    }
}
