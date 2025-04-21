package com.Proyect.ModelSecurity.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyect.ModelSecurity.Service.UserService;
import com.Proyect.ModelSecurity.model.Users;

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
@RequestMapping("api/v1/users")
public class UsersController {

    /*
     * GET = OBTENER INFO
     * POST = CREAR REGISTRO
     * PUT = ACTUALIZAR
     * PATCH = ACTIALIZACION PARCIAL
     * DELETE = ELIMINAR
     */

     @Autowired
     private UserService userService;  // Inyección de la clase UserService
 
     // Método para obtener todos los usuarios
     @GetMapping("/")
     public ResponseEntity<Object> findAllUsers() {
         var listUsers = userService.findAllUsers();  // Llamada al servicio
         return new ResponseEntity<>(listUsers, HttpStatus.OK);
     }
 
     // Método para obtener un usuario por su ID
     @GetMapping("/{id}")
     public ResponseEntity<Object> findByIdUsers(@PathVariable int id) {
         var user = userService.findByIdUsers(id);  // Llamada al servicio
         return new ResponseEntity<>(user, HttpStatus.OK);
     }

    @PostMapping("/")
    public String save(@RequestBody Users Users){
        userService.save(Users);
        return "Registrer OK";
    } 

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Users Users) {
        userService.update(id, Users);
        return "Update OK";
    }
    

    @DeleteMapping("/{Id}")
    public String delete(@PathVariable int Id){
        userService.delete(Id);
        return "Dlete Ok";
    }
    
     

}
