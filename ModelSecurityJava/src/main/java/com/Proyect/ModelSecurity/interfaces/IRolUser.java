package com.Proyect.ModelSecurity.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Proyect.ModelSecurity.model.RolUser;

import java.util.List;
import java.util.Optional;

public interface IRolUser extends JpaRepository<RolUser, Long> {

    // Buscar todos los roles de un usuario que NO están eliminados
    @Query("SELECT ru FROM RolUser ru WHERE ru.user.id = :userId AND ru.deleted = false")
    List<RolUser> findByUserId(@Param("userId") Long userId);

    // Buscar todos los usuarios asignados a un rol (que no estén eliminados)
    @Query("SELECT ru FROM RolUser ru WHERE ru.rol.id = :rolId AND ru.deleted = false")
    List<RolUser> findByRolId(@Param("rolId") Long rolId);

    // Buscar si existe una relación específica entre un usuario y un rol (activa)
    @Query("SELECT ru FROM RolUser ru WHERE ru.user.id = :userId AND ru.rol.id = :rolId AND ru.deleted = false")
    Optional<RolUser> findByUserIdAndRolId(@Param("userId") Long userId, @Param("rolId") Long rolId);
}
