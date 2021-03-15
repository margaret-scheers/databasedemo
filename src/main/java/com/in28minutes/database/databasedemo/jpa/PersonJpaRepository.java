package com.in28minutes.database.databasedemo.jpa;

import com.in28minutes.database.databasedemo.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Person> findAll() {
        TypedQuery<Person> namedQuery = (TypedQuery<Person>) entityManager.createNamedQuery("find_all_persons");
        return namedQuery.getResultList();
    }

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    // update
    public Person update(Person person){

        return entityManager.merge(person);
    }

    public Person insert(Person person){

        return entityManager.merge(person);
    }

    public void deleteById(int id){
        findById(id);
        Person person = findById(id);

        entityManager.remove(person);
    }
}
