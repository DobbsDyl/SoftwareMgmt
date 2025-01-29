package ca.sheridan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TaskManagerTest {

    /*
     * Tests task constructor works when null or empty values inputted
     * title = "Task", description = "Description"
     * dueDate = current time (.now()), without milliseconds
     */
    @Test
    public void testTaskConstructorDefaultValues() {
        Task task = new Task(1, null, "", 
                false, null);

        assertEquals("Task", task.getTitle());
        assertEquals("Description", task.getDescription());
        assertEquals(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), task.getDueDate());
    }
    
    /*
     * testAddTask: tests successful adding of task to map
     * testAddDuplicateBook: tests that adding a duplicate task will not work
     * testAddNullTask: tests that adding a null task will not work
     */
    @Nested
    class AddBookTests {

        @Test
        public void testAddTask() {
            TaskManager taskManager = new TaskManager();
            Task task = new Task(1, "Task 1", "Description 1", 
                false, LocalDateTime.of(2025, 1, 1, 12, 0));
            taskManager.addTask(task);
    
            assertEquals(1, taskManager.getTasks().size());   
            assertEquals(task, taskManager.getTask(task.getId()));      
        }
    
        @Test
        public void testAddDuplicateBook() {
            TaskManager taskManager = new TaskManager();
            Task task = new Task(1, "Task 1", "Description 1", 
                false, LocalDateTime.of(2025, 1, 1, 12, 0));
            taskManager.addTask(task);

            assertFalse(taskManager.addTask(task));
            assertEquals(1, taskManager.getTasks().size());  
        }

        @Test void testAddNullTask() {
            TaskManager taskManager = new TaskManager();
            Task task = null;
            
            assertFalse(taskManager.addTask(task));
        }
    }

    /*
     * testRemoveTask: tests successful removal of a task from map
     * testRemoveNonExistentTask: tests that removing a non-existent task is handled
     */
    @Nested
    class RemoveBookTests{

        @Test
        public void testRemoveTask() {
            TaskManager taskManager = new TaskManager();
            Task task = new Task(1, "Task 1", "Description 1", 
                false, LocalDateTime.of(2025, 1, 1, 12, 0));
            taskManager.addTask(task);
    
            assertTrue(taskManager.removeTask(task));                   
            assertEquals(0, taskManager.getTasks().size());             
        }
    
        @Test
        public void testRemoveNonExistentTask() {
            TaskManager taskManager = new TaskManager();
            Task task = new Task(1, "Task 1", "Description 1", 
                false, LocalDateTime.of(2025, 1, 1, 12, 0));
    
            assertFalse(taskManager.removeTask(task));
        }
    }

    /*
     * testUpdateTask: tests successful update of an existing task
     * testUpdateTaskNull: tests updateTask with null values will not change the values
     * testUpdateTaskEmpty: tests updateTask with empty title, desc will not change values
     */
    @Nested
    class UpdateBookTests {

        @Test
        public void testUpdateTask() {
            TaskManager taskManager = new TaskManager();
            Task task = new Task(1, "Task 1", "Description 1", 
                false, LocalDateTime.of(2025, 1, 1, 12, 0));
            taskManager.addTask(task);
    
            taskManager.updateTask(1, "Task 2", "Description 2", LocalDateTime.of(2025, 2, 2, 12, 0));
            assertEquals("Task 2", taskManager.getTask(1).getTitle());
            assertEquals("Description 2", taskManager.getTask(1).getDescription());
            assertEquals(LocalDateTime.of(2025, 2, 2, 12, 0), taskManager.getTask(1).getDueDate());
        }
    
        @Test
        public void testUpdateTaskNull() {
            TaskManager taskManager = new TaskManager();
            Task task = new Task(1, "Task 1", "Description 1", 
                false, LocalDateTime.of(2025, 1, 1, 12, 0));
            taskManager.addTask(task);
    
            taskManager.updateTask(1, null, null, null);
            assertEquals(task.toString(), taskManager.getTask(1).toString());
        }
    
        @Test
        public void testUpdateTaskEmpty() {
            TaskManager taskManager = new TaskManager();
            Task task = new Task(1, "Task 1", "Description 1", 
                false, LocalDateTime.of(2025, 1, 1, 12, 0));
            taskManager.addTask(task);
    
            taskManager.updateTask(1, "  ", "", null);
            assertEquals(task.toString(), taskManager.getTask(1).toString());
        }
    }

    /*
     * testMarkComplete: tests toggleCompletion, false to true
     * testMarkIncomplete: tests toggleCompletion, true to false
     */
    @Nested
    class MarkCompletionTests {

        @Test
        public void testMarkComplete() {
            TaskManager taskManager = new TaskManager();
            Task task = new Task(1, "Task 1", "Description 1", 
                false, LocalDateTime.of(2025, 1, 1, 12, 0));
            taskManager.addTask(task);

            taskManager.toggleCompletion(task);
            assertTrue(taskManager.getTask(1).isDone());
        }

        @Test
        public void testMarkIncomplete() {
            TaskManager taskManager = new TaskManager();
            Task task = new Task(1, "Task 1", "Description 1", 
                true, LocalDateTime.of(2025, 1, 1, 12, 0));
            taskManager.addTask(task);

            taskManager.toggleCompletion(task);
            assertFalse(taskManager.getTask(1).isDone());
        }
    }
}
