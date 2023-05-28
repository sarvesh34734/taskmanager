package com.scaler.taskmanager.repositories;

import com.scaler.taskmanager.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<TaskEntity,Integer> {
    // for basic where clauses we can define methods definitions like findAllBy followed by where clause attribute. in this case it will pick up completed as where clause
    List<TaskEntity> findAllByCompleted(boolean completed);

    // writing custom queries
    // Ideally this is business logic terminology ("overdue") so shouldn't be here
    @Query("SELECT t FROM tasks t WHERE t.completed = false AND t.dueDate < CURRENT_DATE")
    List<TaskEntity> findAllOverdue();

    // passing params to query
    @Query("SELECT t FROM tasks t WHERE t.title LIKE %?1%") // for first argument use ?1, for second ?2 and so on...
    List<TaskEntity> findAllByTitle(String title);

    // same as above method
    List<TaskEntity> findAllByTitleContainingIgnoreCase(String titleFragment);
}
