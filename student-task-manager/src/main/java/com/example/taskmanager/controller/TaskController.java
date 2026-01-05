package com.example.taskmanager.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.taskmanager.entity.*;
import com.example.taskmanager.repository.*;
import com.example.taskmanager.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

 private final TaskService taskService;
 private final UserRepository userRepo;

 public TaskController(TaskService taskService, UserRepository userRepo) {
  this.taskService = taskService;
  this.userRepo = userRepo;
 }

 @PostMapping("/assignTask")
 public Task create(@RequestBody Task task, Principal principal) {
  User user = userRepo.findByUsername(principal.getName()).orElseThrow();
  return taskService.createTask(task, user);
 }

 @GetMapping("/getAllTask")
 public List<Task> myTasks(Principal principal) {
  User user = userRepo.findByUsername(principal.getName()).orElseThrow();
  return taskService.getTasksByUser(user);
 }
}
