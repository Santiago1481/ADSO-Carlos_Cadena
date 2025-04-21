package com.Proyect.ModelSecurity.Controller;

import com.Proyect.ModelSecurity.Service.PermissionService;
import com.Proyect.ModelSecurity.DTO.PermissionDTO; // Asegúrate de tener el DTO correcto
import com.Proyect.ModelSecurity.model.Permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    // Obtener todos los permisos mapeados a PermissionDTO
    @GetMapping("/")
    public ResponseEntity<List<PermissionDTO>> findAllPermissions() {
        var permissionList = permissionService.findAllPermissions();  
        var permissionDTOList = permissionService.mapToPermissionDTO(permissionList);  
        return new ResponseEntity<>(permissionDTOList, HttpStatus.OK);
    }

    // Buscar permiso por ID y mapear a PermissionDTO
    @GetMapping("/{id}")
    public ResponseEntity<PermissionDTO> findByIdPermission(@PathVariable int id) {
        var permission = permissionService.findByIdPermission(id);
        if (permission.isPresent()) {
            var permissionDTO = permissionService.mapToPermissionDTO(permission.get());  
            return new ResponseEntity<>(permissionDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Guardar nuevo permiso
    @PostMapping("/")
    public String save(@RequestBody Permission permission) {
        permissionService.save(permission);
        return "Register OK";
    }

    // Actualizar permiso existente
    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Permission permission) {
        permissionService.update(id, permission);
        return "Update OK";
    }

    // Eliminar permiso
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        permissionService.delete(id);
        return "Delete OK";
    }
}
