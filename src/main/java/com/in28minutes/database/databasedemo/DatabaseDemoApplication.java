package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.Date;


//@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonSpringDataRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("All users -> {} ", repository.findAll());
        LOGGER.info("find user 10001-> {} ", repository.findById (10001));
        repository.deleteById(10002);
        LOGGER.info("deleted user 10002 ");
        LOGGER.info("insert user -> {} ", repository.save(new Person(10004, "Tara", "Berlin", new Date())));
        LOGGER.info("update user -> {} ", repository.save(new Person(10003, "Pieter", "Utrecht", new Date())));

    }
}
