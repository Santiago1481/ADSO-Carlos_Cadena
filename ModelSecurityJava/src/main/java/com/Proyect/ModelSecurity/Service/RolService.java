package com.Proyect.ModelSecurity.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyect.ModelSecurity.interfaces.IRol;
import com.Proyect.ModelSecurity.model.Rol;
@Service
public class RolService {

    @Autowired
    private IRol RolData;

    public List<Rol> findAllRol(){
        return RolData.findAll();
    }

    //SELECT ID
    public Optional<Rol> findByIdRol(int Id){
        return RolData.findById(Id);
    }

    //CREATE 
    public void save(Rol Rol){
        RolData.save(Rol);
    }

    //UPDATE
    public void update(int Id, Rol RolUpdate){
        var Rol  = findByIdRol(Id);
        if (Rol.isPresent()) {
            Rol.get().setNamerol(RolUpdate.getNamerol());
            Rol.get().setDescription(RolUpdate.getDescription());
            RolData.save(Rol.get());
        }

    }
 
    //DELETE
    public void delete(int Id){
        var Rol = findByIdRol(Id);
        if (Rol.isPresent()) {
            RolData.delete(Rol.get());
        }
    }

}