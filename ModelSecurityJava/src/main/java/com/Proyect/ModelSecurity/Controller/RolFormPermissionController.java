package com.Proyect.ModelSecurity.Controller;

import com.Proyect.ModelSecurity.Service.RolFormPermissionService;
import com.Proyect.ModelSecurity.model.RolFormPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Rolfo")
public class RolFormPermissionController {

    @Autowired
    private RolFormPermissionService RolFormPermissionService;

    // Obtener todos los registros de la tabla pivote
    @GetMapping("/")
    public ResponseEntity<List<RolFormPermission>> findAllRolFormPermissions() {
        List<RolFormPermission> list = RolFormPermissionService.findAllRolFormPermissions();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // Guardar un nuevo registro en la tabla pivote
    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody RolFormPermission RolFormPermission) {
        RolFormPermissionService.save(RolFormPermission);
        return new ResponseEntity<>("RolFormPermission saved successfully", HttpStatus.CREATED);
    }

    // Eliminar un registro de la tabla pivote
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        RolFormPermissionService.delete(id);
        return new ResponseEntity<>("RolFormPermission deleted successfully", HttpStatus.OK);
    }
}
