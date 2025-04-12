package com.sena.crud_basic.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sena.crud_basic.model.service;

/*
 * JpaRepository<entidad, tipo de dato pk
*/
@repository
public @interface IService extends JpaRepository4 {

}
