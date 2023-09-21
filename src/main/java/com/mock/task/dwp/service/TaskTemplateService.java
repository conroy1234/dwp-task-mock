package com.mock.task.dwp.service;

import com.mock.task.dwp.dto.Task;
import com.mock.task.dwp.dto.TaskTemplate;
import com.mock.task.dwp.repository.TaskTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TaskTemplateService {
	
    @Autowired
    TaskTemplateRepository taskTemplateRepository;
    @Autowired
    TaskService taskService;

    public List<TaskTemplate> findAll(){
        return (List<TaskTemplate>) taskTemplateRepository.findAll();
    }

    public Optional<TaskTemplate> findById(int orderId){
        return taskTemplateRepository.findById(orderId);
    }

    public List<TaskTemplate> findByOrganisationalUnitName(String organisationUnitName){
        return taskTemplateRepository.findByOrganisationUnitName(organisationUnitName);
    }

    public List<TaskTemplate> findByTemplateName(String templateName){
        return taskTemplateRepository.findByTemplateName(templateName);
    }

}