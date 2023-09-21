package com.mock.task.dwp.repository;


import com.mock.task.dwp.dto.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task,String> {
}