package com.Proyect.ModelSecurity.Controller;

import com.Proyect.ModelSecurity.DTO.ModuleFormDTO;
import com.Proyect.ModelSecurity.Service.ModuleFormService;

import com.Proyect.ModelSecurity.model.ModuleForm;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/moduleform")
public class ModuleFormController {

@Autowired
private ModuleFormService moduleFormService;

@GetMapping
    public ResponseEntity<List<ModuleForm>> getAllModuleForms() {
        return ResponseEntity.ok(moduleFormService.findAllModuleForms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuleForm> getModuleFormById(@PathVariable Long id) {
        return moduleFormService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/form/{formId}")
    public ResponseEntity<List<ModuleForm>> getByFormId(@PathVariable Long formId) {
        return ResponseEntity.ok(moduleFormService.findByFormId(formId));
    }
    @GetMapping("/module/{moduleId}")
    public ResponseEntity<List<ModuleForm>> getByModuleId(@PathVariable Long moduleId) {
        return ResponseEntity.ok(moduleFormService.findByModuleId(moduleId));
     }

//    @PostMapping("/assign")
//  public ResponseEntity<String> assignFormToModule(@RequestBody ModuleFormDTO request) {
//     // Obtener el módulo completo desde la base de datos por su ID
//     Optional<Module> optionalModule = moduleRepository.findById(request.getModuleId());
//     Optional<Form> optionalForm = formRepository.findById(request.getFormId());

//     if (optionalModule.isPresent() && optionalForm.isPresent()) {
//         Module module = optionalModule.get();
//         Form form = optionalForm.get();

//         // Llamar al servicio para asignar el formulario al módulo
//         moduleFormService.assignFormToModule(module, form);
//         return ResponseEntity.ok("Formulario asignado correctamente al módulo.");
//     } else {
//         return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                 .body("El módulo o el formulario no se encontraron.");
//     }
// }


    @DeleteMapping("/remove")
    public ResponseEntity<String> removeFormFromModule(@RequestBody ModuleFormDTO request) {
        moduleFormService.removeFormFromModule(request.getModuleId(), request.getFormId());
        return ResponseEntity.ok("Relación eliminada lógicamente.");
    }
}
