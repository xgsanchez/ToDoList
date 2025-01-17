package com.example.demo.repository;

import com.example.demo.models.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITask {

    void saveTask(Task task);
    void deleteTaskById(Long id);
    void updateTask(Long id);
    Task getTaskById(Long id);
    List<Task> getAllTask();
    List<Task> getTaskNotComplete();


}
