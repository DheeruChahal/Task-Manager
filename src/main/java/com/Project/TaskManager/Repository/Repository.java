package com.Project.TaskManager.Repository;

import com.Project.TaskManager.Entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Tasks,Integer> {

}
