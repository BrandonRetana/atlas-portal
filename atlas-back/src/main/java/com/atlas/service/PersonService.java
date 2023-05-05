package com.atlas.service;

import com.atlas.GeneralInterface;
import com.atlas.models.Person;
import com.atlas.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService implements GeneralInterface {
    @Autowired
    private PersonRepository personRepository;

    public PersonService() {
    }


    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(long id) {
        return personRepository.findById(id).get();
    }
    @Transactional
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }
    @Transactional
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }
    @Transactional
    public void deletePerson(long id) {
        personRepository.deleteById(id);
    }

    public boolean isPresent(long id) {
        return personRepository.existsById(id);
    }

    @Override
    public String obetnerString() {
        return "Person";
    }

}
