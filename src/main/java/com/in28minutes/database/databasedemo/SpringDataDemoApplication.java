package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJpaRepository jpa;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("All users -> {} ", jpa.findAll());
        LOGGER.info("find user 10001-> {} ", jpa.findById (10001));
        jpa.deleteById(10002);
        LOGGER.info("deleted user 10002 ");
        LOGGER.info("insert user -> {} ",jpa.insert(new Person(10004, "Tara", "Berlin", new Date())));
        LOGGER.info("update user -> {} ",jpa.update(new Person(10003, "Pieter", "Utrecht", new Date())));

    }
}
