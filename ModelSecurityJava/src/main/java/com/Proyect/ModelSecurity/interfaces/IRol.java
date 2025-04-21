package com.Proyect.ModelSecurity.interfaces;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Proyect.ModelSecurity.model.Rol;
@Repository
public interface IRol
extends JpaRepository<Rol,Integer>
{

}