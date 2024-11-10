package com.Project.TaskManager.Services;

import com.Project.TaskManager.Dto.TasksDto;
import com.Project.TaskManager.Entity.Tasks;
import com.Project.TaskManager.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class TaskServicesImpl implements TaskServices{

    @Autowired
    Repository taskRepository;
    @Override
    public String createTask(TasksDto tasksDto) {
        Tasks newTask= Tasks.builder()
                .taskName(tasksDto.getTaskName())
                .taskDescription(tasksDto.getTaskDescription())
                .deadLine(tasksDto.getDeadLine())
                .assignedTo(tasksDto.getAssignedTo())
                .status(tasksDto.getStatus())
                .build();
        taskRepository.save(newTask);
        return "Task Created Successfully";
    }

    @Override
    public String UpdateTask(int id, TasksDto tasksDto) {
        Tasks updateTask = taskRepository.findById(id).orElse(null);
        Objects.requireNonNull(updateTask).setDeadLine(tasksDto.getDeadLine());
        updateTask.setAssignedTo(tasksDto.getAssignedTo());
        updateTask.setStatus(tasksDto.getStatus());
        taskRepository.save(updateTask);
        return "Task Updated Successfully";
    }

    @Override
    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Tasks getTaskById(int id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteTask(int id) {
        taskRepository.deleteById(id);
        return "Task Deleted Successfully";
    }
}
