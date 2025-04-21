package com.Proyect.ModelSecurity.interfaces;

import com.Proyect.ModelSecurity.model.ModuleForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IModuleForm extends JpaRepository<ModuleForm, Long> {

    @Query("SELECT mf FROM ModuleForm mf WHERE mf.module.id = :idModule AND mf.deleted = false")
    List<ModuleForm> findByModuleId(@Param("idModule") Long idModule);

    @Query("SELECT mf FROM ModuleForm mf WHERE mf.form.id = :idForm AND mf.deleted = false")
    List<ModuleForm> findByFormId(@Param("idForm") Long idForm);

    @Query("SELECT mf FROM ModuleForm mf WHERE mf.module.id = :idModule AND mf.form.id = :idForm")
    Optional<ModuleForm> findByModuleIdAndFormId(@Param("idModule") Long idModule, @Param("idForm") Long idForm);
}
