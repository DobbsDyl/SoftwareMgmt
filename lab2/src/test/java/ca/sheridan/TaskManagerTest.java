package ca.sheridan;

import org.junit.jupiter.api.Test;

public class TaskManagerTest {
    
    @Test
    public void testAddTask() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task(1, "Task 1", "Description 1", false, null);
        taskManager.addTask(task);
        assertEquals(1, taskManager.getTasks().size());
    }
}
