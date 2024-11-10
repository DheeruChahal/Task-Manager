package com.Project.TaskManager.Services;

import com.Project.TaskManager.Entity.Tasks;
import com.Project.TaskManager.Repository.Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class ChangeStatus {
    @Autowired
    Repository taskRepo;
    //@Scheduled(cron = "1 0 * * * *")
    @Scheduled(cron = "0 1 0 * * *")
    public void changeStatus(){
        LocalDate currentDate = LocalDate.now();

        List<Tasks> expiredTask = taskRepo.findAll().stream().filter(tasks -> tasks.getDeadLine().isBefore(currentDate)).toList();

        for (int i=0;i< expiredTask.size();i++){
            int id = expiredTask.get(i).getTaskId();
            Tasks task = taskRepo.findById(id).orElse(null);
            Objects.requireNonNull(task).setStatus("Expired");
            taskRepo.save(task);
        }
    }
//    @Scheduled(cron = "0 */1 * * * *")//this will run every minute
//    public void checkCron(){
//        LocalDateTime current=LocalDateTime.now();
//        DateTimeFormatter format =DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        String formattedDate= current.format(format);
//        System.out.println("checking cron  " + formattedDate);
//    }

}
