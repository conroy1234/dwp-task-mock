package com.mock.task.dwp.repository;

import com.mock.task.dwp.dto.TaskTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskTemplateRepository extends CrudRepository<TaskTemplate,Integer> {
List<TaskTemplate> findByOrganisationUnitName(String organisationUnitName);
    List<TaskTemplate> findByTemplateName(String templateName);


}