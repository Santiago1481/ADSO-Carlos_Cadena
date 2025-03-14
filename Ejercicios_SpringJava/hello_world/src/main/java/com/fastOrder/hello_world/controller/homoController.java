package com.fastOrder.hello_world.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fastOrder.hello_world.DTO.requestDTO;
import com.fastOrder.hello_world.DTO.responseDTO;

import jakarta.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




/**
 * Para idindicar que esta clase es un controller se utiliza 
 * la notacion Bean RestController
 * 
*/
@RestController
/**
 * Se configura el mapping del controller, para organizar la peticiones
 */
@RequestMapping("api/v1/home")
public class homoController {

    /**
     * GET: Consultar informacion 
     * POST: craer un registro
     * PUT: actualizar un registro
     * PATCH: actualizacion parcial
     * DELETE eliminacion
     */

     /**
      * Para atender las solicitudes se tiene que diseñar 
      un end-point o fianl del camino
      para definir un end-point
      El tipo de peticion y url para la solicitud 
      La url debe ser unica para no generar problemas 
      de ambiguedad 
      */

      @GetMapping("/saludo1")
      public String saludo() {
          return "Hello World";
      }
      @GetMapping("/saludo2/{nombre}")
      public String saludo2(@PathVariable String nombre) {
          return "HOla " + nombre;
      }
      
      @GetMapping("/saludo3")
      public ResponseEntity<Object> saludo3(@RequestBody requestDTO request) {
          responseDTO response = new responseDTO(
            "Hola " + request.getFirstName()+
            " su correo es: "+request.getGmail()
          );
          return new ResponseEntity<>(response,HttpStatus.OK);
      }
      
}
