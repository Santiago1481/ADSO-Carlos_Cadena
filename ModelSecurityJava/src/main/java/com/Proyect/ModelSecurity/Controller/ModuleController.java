package com.Proyect.ModelSecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Proyect.ModelSecurity.DTO.ModuleDTO;
import com.Proyect.ModelSecurity.Service.ModuleService;
import java.util.List;
import java.util.Optional;
import com.Proyect.ModelSecurity.model.Module;



@RestController
@RequestMapping("api/v1/ModuleController")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @GetMapping("/")
    public ResponseEntity<List<ModuleDTO>> findAllModuleControllers() {
        List<ModuleDTO> moduleDTOList = moduleService.findAllModules();  
        return new ResponseEntity<>(moduleDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuleDTO> findByIdModuleController(@PathVariable int id) {
        Optional<ModuleDTO> moduleDTO = moduleService.findByIdModule(id);
        return moduleDTO
            .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public String save(@RequestBody Module module) {
        moduleService.save(module);
        return "Register OK";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Module module) {
        moduleService.update(id, module);
        return "Update OK";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        moduleService.delete(id);
        return "Delete OK";
    }
}
