package com.in28minutes.database.databasedemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String location;
    private Date birthDate;

    public Person() {
    }

    public Person(int id, String name, String location, Date birthdate) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthdate;
    }

    public Person(String name, String location, Date birthdate) {
        super();
        this.name = name;
        this.location = location;
        this.birthDate = birthdate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String toString() {
        return String.format("\nPerson [id=%s, name=%s, location=%s, birthdate=%s", id, name, location, birthDate);
    }
}
