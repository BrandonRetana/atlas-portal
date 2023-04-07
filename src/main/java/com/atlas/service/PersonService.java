package com.atlas.service;

import com.atlas.repository.PersonRepository;
import com.atlas.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Person getPersonById(long id){
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            return person.get();
       } else {
            throw new RuntimeException("Person not found");
       }

    }

    public Class getPersonByName(String name){ 
        Optional<Person> person = personRepository.findByName(name);
           if (person.isPresent()) {
           return person.get();
       } else {
           throw new RuntimeException("Person not found");
       }
    }


    

    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    public Person addPerson(Person person){
        return personRepository.save(person);
    }

    public Person updatePerson(Person person){
        return personRepository.save(person);
    }

    public void deletePerson(long id){
        personRepository.deleteById(id);
    }

}

