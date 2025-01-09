package com.example.demo.service;

import com.example.demo.models.Task;
import com.example.demo.repository.ITask;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements ITask {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveTask(Task task) {
        entityManager.persist(task);
    }

    @Override
    @Transactional
    public void deleteTaskById(Long id) {
//        Task task = getTaskById(id);
//        entityManager.remove(task);

        String query = "delete from Task t where t.id = :id";
        entityManager.createQuery(query).setParameter("id", id).executeUpdate();
    }

    @Override
    @Transactional
    public Task getTaskById(Long id) {
        String query = "select t from Task t where t.id = :id ";
        return entityManager.createQuery(query, Task.class).setParameter("id", id).getSingleResult();
    }

    @Override
    @Transactional
    public List<Task> getAllTask() {
        String query= " Select t From Task t ";
        return entityManager.createQuery(query, Task.class).getResultList();
    }


}
