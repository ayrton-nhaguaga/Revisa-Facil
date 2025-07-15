package com.revisafacil.revisafacil.controller;

import com.revisafacil.revisafacil.dto.TaskDTO;
import com.revisafacil.revisafacil.enums.TaskStatus;
import com.revisafacil.revisafacil.model.Task;
import com.revisafacil.revisafacil.service.TaskService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO dto){
        Task task = taskService.createTask(dto);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll(){
        List<Task> tasks = taskService.getAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/title")
    public ResponseEntity<List<Task>> getByTitleContainingIgnoreCase(@RequestParam String title){
        List<Task> tasks = taskService.getByTitleContainingIgnoreCase(title);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Task>> getByTopicId(@RequestParam ObjectId topicId){
        List<Task> tasks = taskService.getByTopicId(topicId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/due-date")
    public ResponseEntity<List<Task>> getByDueDate(@RequestParam LocalDateTime dueDate){
        List<Task> tasks = taskService.getByDueDate(dueDate);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<List<Task>> getByStatus(@RequestParam TaskStatus status){
        List<Task> tasks = taskService.getByStatus(status);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping("/title")
    public ResponseEntity<List<Task>> updateTask(@RequestParam String title, @RequestBody TaskDTO dto){
        List<Task> updatedList = taskService.updateTask(title, dto);

        if (updatedList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedList);
    }

    @DeleteMapping("/title")
    public ResponseEntity<Void>  deleteTask(@RequestParam String title){
        if (taskService.deleteTask(title)){
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }
}
