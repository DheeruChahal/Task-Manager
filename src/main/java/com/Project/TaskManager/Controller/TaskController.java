package com.Project.TaskManager.Controller;

import com.Project.TaskManager.Dto.TasksDto;
import com.Project.TaskManager.Entity.Tasks;
import com.Project.TaskManager.Services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    TaskServices service;
    @PostMapping("/create")
    public String createTask(@RequestBody TasksDto tasksDto){
        return service.createTask(tasksDto);
    }
    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable int id , @RequestBody TasksDto tasksDto){
        return service.UpdateTask(id, tasksDto);
    }
    @GetMapping("/get")
    public List<Tasks> getAllTasks(){
        return service.getAllTasks();
    }
    @GetMapping("/getById/{id}")
    public Tasks getTaskById(@PathVariable int id){
        return service.getTaskById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteTaskById(@PathVariable int id){
        return service.deleteTask(id);
    }
}
