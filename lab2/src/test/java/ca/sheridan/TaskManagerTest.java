package ca.sheridan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class TaskManagerTest {
    
    @Test
    public void testAddTask() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task(1, "Task 1", "Description 1", false, LocalDateTime.of(2021, 9, 1, 12, 0));
        assertTrue(taskManager.addTask(task));
        assertEquals(1, taskManager.getTasks().size());
    }

    @Test
    public void testRemoveTask() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task(1, "Task 1", "Description 1", false, LocalDateTime.of(2021, 9, 1, 12, 0));
        taskManager.addTask(task);
        assertTrue(taskManager.removeTask(task));
        assertEquals(0, taskManager.getTasks().size());
    }



}
