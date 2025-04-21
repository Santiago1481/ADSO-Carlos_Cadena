package com.Proyect.ModelSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyect.ModelSecurity.interfaces.IRolFormPermission;
import com.Proyect.ModelSecurity.model.RolFormPermission;

import java.util.List;

@Service
public class RolFormPermissionService {

    @Autowired
    private IRolFormPermission RolFormPermissionData;

    // Obtener todos los registros de la tabla pivote
    public List<RolFormPermission> findAllRolFormPermissions() {
        return RolFormPermissionData.findAll();
    }

    // Guardar un nuevo registro en la tabla pivote
    public void save(RolFormPermission RolFormPermission) {
        RolFormPermissionData.save(RolFormPermission);
    }

    // Eliminar un registro de la tabla pivote
    public void delete(int id) {
        RolFormPermissionData.deleteById(id);
    }
}
