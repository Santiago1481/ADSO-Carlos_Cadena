package com.Proyect.ModelSecurity.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Proyect.ModelSecurity.model.RolFormPermission;

@Repository
public interface IRolFormPermission extends JpaRepository<RolFormPermission, Integer> {
}
