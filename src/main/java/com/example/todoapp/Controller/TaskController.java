package com.example.todoapp.Controller;

import com.example.todoapp.Entities.Task;
import com.example.todoapp.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @RequestMapping(value = "/todos", method = RequestMethod.POST, consumes = "application/json")
    public void postTask(@RequestBody Task task){
        taskService.addTask(task);
    }

    @RequestMapping(value = "/todos", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Task> getTasks(){
        return taskService.getAllTasks();
    }

    @RequestMapping(value = "/todos/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Task getTaskById(@PathVariable String id){
        return taskService.getTaskById(Long.parseLong(id));
    }

    @RequestMapping(value = "/todos/{id}/done", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Task updateTaskStatus(@PathVariable String id){
        return taskService.updateTask(Long.parseLong(id));
    }

    @RequestMapping(value = "/todos/{id}/done", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public Task updateTaskStatusToFalse(@PathVariable String id){
        return taskService.updateTaskToFalse(Long.parseLong(id));
    }
}
