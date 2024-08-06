package com.surenraj.taskmanagement.service;

import com.surenraj.taskmanagement.entity.Task;
import com.surenraj.taskmanagement.exception.ResourceCreationException;
import com.surenraj.taskmanagement.exception.ResourceDeleteException;
import com.surenraj.taskmanagement.exception.ResourceNotFoundException;
import com.surenraj.taskmanagement.exception.ResourceUpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.surenraj.taskmanagement.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    //to D.I task repository
    @Autowired
    private TaskRepository taskRepository;
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }
    public Task findTaskById(Long id) {
        //gets task details via id
        //throws not found exception if task with the id do not exist
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

    }
    public Task saveTask(Task task) {
        try {
            //default status when task was first created
            task.setStatus("New");
        } catch (Exception e) {
            throw new ResourceCreationException("Failed to create task: " + e.getMessage());
        }
        return taskRepository.save(task);
    }
    public void deleteTask(Long id) {
        try {
            taskRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceDeleteException("Failed to delete task with id " + id + ": " + e.getMessage());
        }
    }
    public Task updateTask(Long id, Task taskDetails) {
        //checks whether task exist or not via id
        //if not throws exception
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + id));

        try {
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setStatus(taskDetails.getStatus());
        } catch (Exception e) {
            throw new ResourceUpdateException("Failed to update task with id " + id + ": " + e.getMessage());
        }

        return taskRepository.save(task);
    }
}
