package ca.sheridan;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class TaskManagerTest {
    
    @Test
    public void testAddTask() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task(1, "Task 1", "Description 1", false, null);
        taskManager.addTask(task);
        assertEquals(1, taskManager.getTasks().size());
    }

    @Test
    public void testRemoveTask() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task(1, "Task 1", "Description 1", false, null);
        taskManager.addTask(task);
        taskManager.removeTask(task);
        assertEquals(0, taskManager.getTasks().size());
    }

    @Test
    public void testUpdateTask() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task(1, "Task 1", "Description 1", false, null);
        taskManager.addTask(task);
        Task updatedTask = new Task(1, "Task 1", "Description 1", true, null);
        taskManager.addTask(updatedTask);
        assertEquals(true, taskManager.getTask(task.getTitle()).isDone());
    }
}
