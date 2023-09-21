package com.mock.task.dwp.service;

import com.mock.task.dwp.dto.Task;
import com.mock.task.dwp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public Iterable<Task> findAll(){
        return taskRepository.findAll();
    }

    public Optional<Task> findById(String organisationUnitName){
        return taskRepository.findById(organisationUnitName);
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

}