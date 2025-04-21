package com.Proyect.ModelSecurity.Controller;

import com.Proyect.ModelSecurity.DTO.AssignRolRequest;
import com.Proyect.ModelSecurity.Service.RolUserService;
import com.Proyect.ModelSecurity.model.RolUser;
import com.Proyect.ModelSecurity.model.Users;
import com.Proyect.ModelSecurity.model.Rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/roluser")
public class RolUserController {

    @Autowired
    private RolUserService rolUserService;

    @GetMapping
    public ResponseEntity<List<RolUser>> getAllRolUsers() {
        return ResponseEntity.ok(rolUserService.findAllRolUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolUser> getRolUserById(@PathVariable Long id) {
        Optional<RolUser> rolUser = rolUserService.findById(id);
        return rolUser.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RolUser>> getRolesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(rolUserService.findByUserId(userId));
    }

    @GetMapping("/rol/{rolId}")
    public ResponseEntity<List<RolUser>> getUsersByRolId(@PathVariable Long rolId) {
        return ResponseEntity.ok(rolUserService.findByRolId(rolId));
    }

    // ✅ Asignar un rol usando DTO y JSON
    @PostMapping("/assign")
    public ResponseEntity<String> assignRolToUser(@RequestBody AssignRolRequest request) {
        Users user = new Users();
        user.setId_Users(request.getUserId().intValue());

        Rol rol = new Rol();
        rol.setId_Roles(request.getRolId().intValue());

        rolUserService.assignRolToUser(user, rol);

        return ResponseEntity.ok("Rol asignado al usuario correctamente");
    }

    // ✅ Eliminar rol lógicamente usando el mismo DTO
    @DeleteMapping("/remove")
    public ResponseEntity<String> removeRolFromUser(@RequestBody AssignRolRequest request) {
        rolUserService.removeRolFromUser(request.getUserId(), request.getRolId());
        return ResponseEntity.ok("Rol eliminado lógicamente del usuario");
    }
}
