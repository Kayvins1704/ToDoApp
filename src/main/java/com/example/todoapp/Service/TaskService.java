package com.example.todoapp.Service;

import com.example.todoapp.Entities.Task;
import com.example.todoapp.Exceptions.TaskNotFoundException;
import com.example.todoapp.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(Task task){
        taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(long id){
        if(id <= 0 || id > getAllTasks().size()) throw new TaskNotFoundException();
        return taskRepository.findById(id)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList()).get(0);
    }

    public Task updateTask(long id){
        Task task = getTaskById(id);
        task.setDone(true);
        taskRepository.save(task);
        return task;
    }

    public Task updateTaskToFalse(long id) {
        Task task = getTaskById(id);
        task.setDone(false);
        taskRepository.save(task);
        return task;
    }
}
