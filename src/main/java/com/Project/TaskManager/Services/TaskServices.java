package com.Project.TaskManager.Services;

import com.Project.TaskManager.Dto.TasksDto;
import com.Project.TaskManager.Entity.Tasks;

import java.util.List;

public interface TaskServices {
    public String createTask(TasksDto tasksDto);
    public String UpdateTask(int id , TasksDto tasksDto);
    public List<Tasks> getAllTasks();
    public Tasks getTaskById(int id);
    public String deleteTask(int id);

}
