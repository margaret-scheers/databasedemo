package com.in28minutes.database.databasedemo.jdbc;

import com.in28minutes.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //select * from person
    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM PERSON",
                new BeanPropertyRowMapper(Person.class));

    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM person WHERE id=?", new Object[] { id },
                new BeanPropertyRowMapper<Person>(Person.class));

    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete FROM person WHERE id=?", new Object[] { id });

    }

    public int insert(Person person) {
        return jdbcTemplate.update("insert into person(ID, NAME, LOCATION, BIRTH_DATE)"
                + " VALUES(?, ?, ?, ?)", new Object[] { person.getId(), person.getName(),
                person.getLocation(), new Timestamp(person.getBirthDate().getTime())
         });}

        public int update(Person person){
            return jdbcTemplate.update("UPDATE PERSON"
                            + " set NAME =?, LOCATION=?, BIRTH_DATE=?"
                            + " where id = ? ",
                    new Object[]{
                            person.getName(),
                            person.getLocation(),
                            new Timestamp(person.getBirthDate().getTime()),
                                    person.getId()
                    });
        }
    }

