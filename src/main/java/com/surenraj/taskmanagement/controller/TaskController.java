package com.surenraj.taskmanagement.controller;

import com.surenraj.taskmanagement.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.surenraj.taskmanagement.service.TaskService;

import java.util.List;
import java.util.Optional;
//to allow FE communicate with BE API
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    //to D.I task service
    @Autowired
    private TaskService taskService;

    //to create a new task
    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    //to get single task
    @GetMapping("/getTask/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.findTaskById(id);
        return ResponseEntity.ok(task);
    }

    //to update existing task
    @PutMapping("/update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(id, task);
        return ResponseEntity.ok(updatedTask);
    }

    //to delete task
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    //to get all task, in array of task objects
    @GetMapping("/getAll")
    public List<Task> getAllTasks() {
        return taskService.findAllTasks();
    }

}
