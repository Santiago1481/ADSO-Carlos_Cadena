package com.Proyect.ModelSecurity.Service;

import com.Proyect.ModelSecurity.interfaces.IModuleForm;
import com.Proyect.ModelSecurity.model.Module;
import com.Proyect.ModelSecurity.model.Form;
import com.Proyect.ModelSecurity.model.ModuleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleFormService {

    @Autowired
    private IModuleForm moduleFormRepository;

    public List<ModuleForm> findAllModuleForms() {
        return moduleFormRepository.findAll();
    }

    public Optional<ModuleForm> findById(Long id) {
        return moduleFormRepository.findById(id).filter(mf -> !mf.getDeleted());
    }

    public List<ModuleForm> findByModuleId(Long moduleId) {
        return moduleFormRepository.findByModuleId(moduleId);
    }

    public List<ModuleForm> findByFormId(Long formId) {
        return moduleFormRepository.findByFormId(formId);
    }

    public void assignFormToModule(Module module, Form form) {
        ModuleForm moduleForm = new ModuleForm();
        moduleForm.setModule(module);
        moduleForm.setForm(form);
        moduleForm.setDeleted(false);
        moduleFormRepository.save(moduleForm);
    }

    public void removeFormFromModule(Long moduleId, Long formId) {
        Optional<ModuleForm> moduleForm = moduleFormRepository.findByModuleIdAndFormId(moduleId, formId);
        moduleForm.ifPresent(mf -> {
            mf.setDeleted(true);
            moduleFormRepository.save(mf);
        });
    }
}
