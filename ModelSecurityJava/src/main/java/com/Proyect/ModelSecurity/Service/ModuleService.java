package com.Proyect.ModelSecurity.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyect.ModelSecurity.DTO.ModuleDTO;
import com.Proyect.ModelSecurity.interfaces.IModule;
import com.Proyect.ModelSecurity.model.Module;


@Service
public class ModuleService {

    @Autowired
    private IModule ModuleData;

    // Obtener todos los Moduleularios
    public List<ModuleDTO> findAllModules() {
        List<Module> Modules = ModuleData.findAll();
        return Modules.stream()
                    .map(Module -> new ModuleDTO(Module.getIdModule(), Module.getNameModuele(), Module.getDescriptionModule(), Module.getCreateDate(), Module.getActive()))
                    .collect(Collectors.toList());
    }

    // Buscar un Moduleulario por ID
    public Optional<ModuleDTO> findByIdModule(int id) {
        Optional<Module> Module = ModuleData.findById(id);
        return Module.map(f -> new ModuleDTO(f.getIdModule(), f.getNameModuele(), f.getDescriptionModule(), f.getCreateDate(), f.getActive()));
    }

    // Guardar un nuevo Moduleulario
    public void save(Module Module) {
        ModuleData.save(Module);
    }

    // Actualizar un Moduleulario
    public void update(int id, Module updatedModule) {
        var Module = ModuleData.findById(id);
        if (Module.isPresent()) {
            Module existingModule = Module.get();
            existingModule.setNameModuele(updatedModule.getNameModuele());
            existingModule.setDescriptionModule(updatedModule.getDescriptionModule());
            existingModule.setCreateDate(updatedModule.getCreateDate());
            existingModule.setActive(updatedModule.getActive());
            ModuleData.save(existingModule);
        }
    }

    // Eliminar un Moduleulario
    public void delete(int id) {
        var Module = ModuleData.findById(id);
        Module.ifPresent(ModuleData::delete);
    }

     // Mapeo de Module a ModuleDTO
    public ModuleDTO mapToModuleDTO(Module Module) {
        return new ModuleDTO(
            Module.getIdModule(),
            Module.getNameModuele(),
            Module.getDescriptionModule(),
            Module.getCreateDate(),
            Module.getActive()
        );
    }

    // Mapeo de lista de Module a lista de ModuleDTO
    public List<ModuleDTO> mapToModuleDTO(List<Module> ModuleList) {
        return ModuleList.stream()
                .map(this::mapToModuleDTO)
                .collect(Collectors.toList());
    }

}
