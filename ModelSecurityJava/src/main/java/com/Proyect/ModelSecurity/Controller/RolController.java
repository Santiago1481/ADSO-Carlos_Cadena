package com.Proyect.ModelSecurity.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyect.ModelSecurity.Service.RolService;
import com.Proyect.ModelSecurity.model.Rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("api/v1/Rol")
public class RolController {

    /*
     * GET = OBTENER INFO
     * POST = CREAR REGISTRO
     * PUT = ACTUALIZAR
     * PATCH = ACTIALIZACION PARCIAL
     * DELETE = ELIMINAR
     */

     @Autowired
     private RolService RolServicie;

     @GetMapping("/")
     public ResponseEntity<Object>findAllRol() {
        var ListRol=RolServicie.findAllRol();
        return new ResponseEntity<Object>(ListRol,HttpStatus.OK);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Object> findByIdRol(@PathVariable int Id) {
        var Rol=RolServicie.findByIdRol(Id);  
        return new ResponseEntity<>(Rol,HttpStatus.OK);
    }

    @PostMapping("/")
    public String save(@RequestBody Rol Rol){
        RolServicie.save(Rol);
        return "Registrer OK";
    } 

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Rol Rol) {
        RolServicie.update(id, Rol);
        return "Update OK";
    }
    

    @DeleteMapping("/{Id}")
    public String delete(@PathVariable int Id){
        RolServicie.delete(Id);
        return "Dlete Ok";
    }
    
     

}
