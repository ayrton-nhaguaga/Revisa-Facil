package com.revisafacil.revisafacil.service;


import com.revisafacil.revisafacil.dto.TaskDTO;
import com.revisafacil.revisafacil.enums.TaskStatus;
import com.revisafacil.revisafacil.model.Task;
import com.revisafacil.revisafacil.repository.TaskRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(TaskDTO dto){
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setId(dto.getId());
        task.setUserId(dto.getUserId());
        task.setCreatedAt(dto.getCreatedAt());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setDueDate(dto.getDueDate());
        task.setTopicId(dto.getTopicId());
        return taskRepository.save(task);
    }

    public List<Task> getAll(){
        return taskRepository.findAll();
    }


    public List<Task> getByTitleContainingIgnoreCase(String title){
        return taskRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Task> getByTopicId(ObjectId topicId){
        return taskRepository.findByTopicId(topicId);
    }

    public List<Task> getByDueDate(LocalDateTime dueDate){
        return taskRepository.findByDueDate(dueDate);
    }

    public List<Task> getByStatus(TaskStatus status){
        return taskRepository.findByStatus(status);
    }

    public List<Task> getByCreatedAt(LocalDateTime createdAt){
        return taskRepository.findByCreatedAt(createdAt);
    }

    public List<Task> updateTask(String title, TaskDTO dto){
        List<Task> existes = taskRepository.findByTitleContainingIgnoreCase(title);

        for (Task t : existes){
            t.setTitle(dto.getTitle());
            t.setTopicId(dto.getTopicId());
            t.setStatus(dto.getStatus());
            t.setDescription(dto.getDescription());
            t.setDueDate(dto.getDueDate());
            taskRepository.save(t);
        }
        return existes;
    }

    public boolean deleteTask(String title){
        List<Task> tasks = taskRepository.findByTitleContainingIgnoreCase(title);

        if (!tasks.isEmpty()){
            taskRepository.deleteAll(tasks);
            return true;
        }
        return false;
    }
}
