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

    public List<Task> findAll(){
        return taskRepository.findAll();
    }


    public List<Task> findByTitleContainigIgnoreCase(String title){
        return taskRepository.findByTitleContainigIgnoreCase(title);
    }

    public List<Task> findByTopicId(ObjectId topicId){
        return taskRepository.findByTopicId(topicId);
    }

    public List<Task> findByDueDate(LocalDateTime dueDate){
        return taskRepository.findByDueDate(dueDate);
    }

    public List<Task> findByStatus(TaskStatus status){
        return taskRepository.findByStatus(status);
    }

    public List<Task> findByCreateDate(LocalDateTime createdAt){
        return taskRepository.findByCreateDate(createdAt);
    }

    public List<Task> updateTask(String title, TaskDTO dto){
        List<Task> existes = taskRepository.findByTitleContainigIgnoreCase(title);

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
        List<Task> tasks = taskRepository.findByTitleContainigIgnoreCase(title);

        if (!tasks.isEmpty()){
            taskRepository.deleteAll(tasks);
            return true;
        }
        return false;
    }
}
