package com.Proyect.ModelSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyect.ModelSecurity.interfaces.IPerson;
import com.Proyect.ModelSecurity.model.Person;

import java.util.List;
import java.util.Optional;

@Service 
public class PersonService {
    @Autowired
    private IPerson PersonData;

    public List<Person> findAllPerson() {
        return PersonData.findAll();
    }

    public Optional<Person> findByIdPerson(int Id) {
        return PersonData.findById(Id);
    }

    public void save(Person Person) {
        PersonData.save(Person);
    }

    public void update(int Id, Person PersonUpdate) {
        var Person = findByIdPerson(Id);
        if (Person.isPresent()) {
            Person.get().setLastName(PersonUpdate.getLastName());
            Person.get().setFirstName(PersonUpdate.getFirstName());
            Person.get().setGmail(PersonUpdate.getGmail());
            Person.get().setPhone(PersonUpdate.getPhone());
            PersonData.save(Person.get());
        }
    }

    public void delete(int Id) {
        var Person = findByIdPerson(Id);
        if (Person.isPresent()) {
            PersonData.delete(Person.get());
        }
    }
}
