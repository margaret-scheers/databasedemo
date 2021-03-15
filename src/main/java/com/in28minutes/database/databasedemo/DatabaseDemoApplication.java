package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJdbcDao dao;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("All users -> {} ",dao.findAll());
        LOGGER.info("find user -> {} ",dao.findById(10001));
        LOGGER.info("deleted user -> {} ",dao.deleteById(10002));
        LOGGER.info("insert user -> {} ",dao.insert(new Person(10004, "Tara", "Berlin", new Date())));
        LOGGER.info("update user -> {} ",dao.update(new Person(10003, "Pieter", "Utrecht", new Date())));

    }
}
