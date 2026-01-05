
package com.example.taskmanager.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.taskmanager.entity.*;
import com.example.taskmanager.repository.*;

@Service
public class TaskServiceImpl implements TaskService {

 private final TaskRepository taskRepo;

 public TaskServiceImpl(TaskRepository taskRepo) {
  this.taskRepo = taskRepo;
 }

 public Task createTask(Task task, User user) {
  task.setUser(user);
  return taskRepo.save(task);
 }

 public List<Task> getTasksByUser(User user) {
  return taskRepo.findByUser(user);
 }
}
