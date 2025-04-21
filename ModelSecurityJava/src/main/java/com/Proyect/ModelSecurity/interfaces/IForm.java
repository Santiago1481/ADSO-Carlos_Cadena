package com.Proyect.ModelSecurity.interfaces;

import com.Proyect.ModelSecurity.model.Form; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IForm 
extends JpaRepository<Form, Integer>
{

}
