package com.scaler.taskmanager.repositories;

import com.scaler.taskmanager.entities.TaskEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest // with this annotation spring automatically creates a temp db in memory and run tests on that, main db is not affected
public class TasksRepositoryTest {
    @Autowired
    private TasksRepository tasksRepository;

    @Test
    public void testCreateTask(){
        TaskEntity task = new TaskEntity();
        task.setTitle("my first task");
        task.setDescription("unit test to create a task");
        task.setCompleted(false);
        var savedTask = tasksRepository.save(task);
        assertNotNull(savedTask);
    }

    @Test
    public void findAllByCompleted(){
        TaskEntity task = new TaskEntity();
        task.setTitle("test task1");
        task.setCompleted(true);
        TaskEntity task1 = new TaskEntity();
        task1.setTitle("test task 2");
        task1.setCompleted(false);
        tasksRepository.save(task);
        tasksRepository.save(task1);
        var tasks = tasksRepository.findAllByCompleted(false);
        assertEquals(tasks.size(),1);
    }
}
