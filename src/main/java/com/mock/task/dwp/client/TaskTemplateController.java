package com.mock.task.dwp.client;

import com.mock.task.dwp.dto.TaskTemplate;
import com.mock.task.dwp.service.TaskTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskTemplateController {
	
	Logger logger = LoggerFactory.getLogger(TaskTemplateController.class);
	
    @Autowired
    TaskTemplateService taskTemplateService;

    @GetMapping("/tasks/api/v2/task-templates/{id}")
    public TaskTemplate findById(@PathVariable int id){
        TaskTemplate template = taskTemplateService.findById(id).get();
        return template;
    }
    @GetMapping("/tasks/api/v2/task-templates/organisation/{organisationUnitName}")
    public ResponseEntity<List<TaskTemplate>> findByOrganisationalUnitName(@PathVariable String organisationUnitName){
        List<TaskTemplate> entity = taskTemplateService.findByOrganisationalUnitName(organisationUnitName);

        return ResponseEntity.ok(entity);

    }
    @GetMapping("/tasks/api/v2/task-templates/template/{templateName}")
    public ResponseEntity<List<TaskTemplate>> findByTemplateName(@PathVariable String templateName){
        List<TaskTemplate> entity = taskTemplateService.findByTemplateName(templateName);

        return ResponseEntity.ok(entity);

    }



}