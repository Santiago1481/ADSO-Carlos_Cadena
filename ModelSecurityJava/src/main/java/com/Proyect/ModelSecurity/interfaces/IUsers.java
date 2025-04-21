package com.Proyect.ModelSecurity.interfaces;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Proyect.ModelSecurity.model.Users;

@Repository
public interface IUsers
extends JpaRepository<Users,Integer>
{

}
