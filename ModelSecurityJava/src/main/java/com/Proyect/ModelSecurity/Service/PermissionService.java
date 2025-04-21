package com.Proyect.ModelSecurity.Service;

import com.Proyect.ModelSecurity.DTO.PermissionDTO; // Asegúrate de tener este DTO
import com.Proyect.ModelSecurity.model.Permission;
import com.Proyect.ModelSecurity.interfaces.IPermission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PermissionService {

    @Autowired
    private IPermission permissionData;

    // Obtener todos los permisos
    public List<Permission> findAllPermissions() {
        return permissionData.findAll();
    }

    // Buscar un permiso por ID
    public Optional<Permission> findByIdPermission(int id) {
        return permissionData.findById(id);
    }

    // Guardar un nuevo permiso
    public void save(Permission permission) {
        permissionData.save(permission);
    }

    // Actualizar un permiso existente
    public void update(int id, Permission updatedPermission) {
        var existingPermission = findByIdPermission(id);
        if (existingPermission.isPresent()) {
            Permission permission = existingPermission.get();
            permission.setNamePermission(updatedPermission.getNamePermission());
            permission.setDescriptionName(updatedPermission.getDescriptionName());
            permission.setActive(updatedPermission.getActive());
            permissionData.save(permission);
        }
    }

    // Eliminar un permiso
    public void delete(int id) {
        var permission = findByIdPermission(id);
        if (permission.isPresent()) {
            permissionData.delete(permission.get());
        }
    }

    // Mapeo de Permission a PermissionDTO
    public PermissionDTO mapToPermissionDTO(Permission permission) {
        return new PermissionDTO(
            permission.getId_Permission(),
            permission.getNamePermission(),
            permission.getDescriptionName(),
            permission.getActive()
        );
    }

    // Mapeo de lista de Permission a lista de PermissionDTO
    public List<PermissionDTO> mapToPermissionDTO(List<Permission> permissionList) {
        return permissionList.stream()
                .map(this::mapToPermissionDTO)
                .collect(Collectors.toList());
    }
}
