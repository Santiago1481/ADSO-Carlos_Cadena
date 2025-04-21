package com.Proyect.ModelSecurity.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyect.ModelSecurity.Service.PersonService;
import com.Proyect.ModelSecurity.model.Person;

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
@RequestMapping("api/v1/Person")
public class PersonController {

    /*
     * GET = OBTENER INFO
     * POST = CREAR REGISTRO
     * PUT = ACTUALIZAR
     * PATCH = ACTIALIZACION PARCIAL
     * 

     * DELETE = ELIMINAR
     */

     @Autowired
     private PersonService personService;
 
     @GetMapping("/")
     public ResponseEntity<Object> findAllPerson() {
         var listPerson = personService.findAllPerson();
         return new ResponseEntity<>(listPerson, HttpStatus.OK);
     }
 
     @GetMapping("/{id}")
     public ResponseEntity<Object> findByIdPerson(@PathVariable int id) {
         var person = personService.findByIdPerson(id);  
         return new ResponseEntity<>(person, HttpStatus.OK);
     }
 
     @PostMapping("/")
     public String save(@RequestBody Person person) {
         personService.save(person);
         return "Register OK";
     } 
 
     @PutMapping("/{id}")
     public String update(@PathVariable int id, @RequestBody Person person) {
         personService.update(id, person);
         return "Update OK";
     }
 
     @DeleteMapping("/{id}")
     public String delete(@PathVariable int id) {
         personService.delete(id);
         return "Delete OK";
     }
    
     

}
