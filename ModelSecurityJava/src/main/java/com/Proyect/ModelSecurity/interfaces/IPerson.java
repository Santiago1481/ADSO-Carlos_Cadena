package com.Proyect.ModelSecurity.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proyect.ModelSecurity.model.Person;

@Repository
public interface IPerson
extends JpaRepository<Person, Integer>
{

}
