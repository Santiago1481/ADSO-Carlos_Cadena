package com.Proyect.ModelSecurity.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proyect.ModelSecurity.model.Module;

@Repository
public interface IModule 
extends JpaRepository<Module, Integer>
{


}
