package com.Proyect.ModelSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyect.ModelSecurity.interfaces.IRolUser;
import com.Proyect.ModelSecurity.model.Rol;
import com.Proyect.ModelSecurity.model.RolUser;
import com.Proyect.ModelSecurity.model.Users;

import java.util.List;
import java.util.Optional;

@Service
public class RolUserService {

    @Autowired
    private IRolUser rolUserRepository;

    // Método público que retorna una lista de todas las relaciones RolUser que no están eliminadas
    public List<RolUser> findAllRolUsers() {
        return rolUserRepository.findAll();  
    }

    // Busca una relación RolUser por su clave primaria (id), pero solo si no está eliminada
    public Optional<RolUser> findById(Long id) {
        return rolUserRepository.findById(id)
                .filter(ru -> !ru.getDeleted()); 
    }

    // Retorna todos los roles asignados a un usuario específico que no están eliminados
    public List<RolUser> findByUserId(Long userId) {
        return rolUserRepository.findByUserId(userId);  
    }

    // Retorna todos los Usuarios asignados a un Rol específico que no están eliminados
    public List<RolUser> findByRolId(Long rolId) {
        return rolUserRepository.findByRolId(rolId);  
    }

    // Asigna un rol a un usuario, marcándolo como NO eliminado
    public void assignRolToUser(Users user, Rol rol) {
        RolUser rolUser = new RolUser();
        rolUser.setUser(user);
        rolUser.setRol(rol);
        rolUser.setDeleted(false);  
        rolUserRepository.save(rolUser); 
    }

    // Remueve un rol de un usuario (cambia el estado a eliminado lógico)
    public void removeRolFromUser(Long userId, Long rolId) {
        Optional<RolUser> rolUser = rolUserRepository.findByUserIdAndRolId(userId, rolId);
        rolUser.ifPresent(ru -> {
            ru.setDeleted(true);  
            rolUserRepository.save(ru);  
        });
    }
}
