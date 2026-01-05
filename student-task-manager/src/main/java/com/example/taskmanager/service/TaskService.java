
package com.example.taskmanager.service;

import java.util.List;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.entity.User;

public interface TaskService {
 Task createTask(Task task, User user);
 List<Task> getTasksByUser(User user);
}
