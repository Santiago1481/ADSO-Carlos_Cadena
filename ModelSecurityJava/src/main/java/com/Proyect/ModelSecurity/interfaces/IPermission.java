package com.Proyect.ModelSecurity.interfaces;

import com.Proyect.ModelSecurity.model.Permission; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPermission
extends JpaRepository<Permission, Integer>
{

}

