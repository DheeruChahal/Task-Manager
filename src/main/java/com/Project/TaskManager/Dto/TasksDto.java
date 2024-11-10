package com.Project.TaskManager.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TasksDto {
    private String taskName;
    private String taskDescription;
    private LocalDate deadLine;
    private String assignedTo;
    private String status;
}
