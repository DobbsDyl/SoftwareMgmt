package ca.sheridan;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    
    public Map<Integer, Task> tasks = new HashMap<Integer, Task>();

    public boolean addTask(Task task) {
        if (task == null || tasks.containsKey(task.getId())) {
            return false;
        } 

        tasks.put(task.getId(), task);
        return true;
    }

    public boolean removeTask(Task task) {
        if (task == null || !tasks.containsKey(task.getId())) {
            return false;
        } else {
            tasks.remove(task.getId());
            return true;
        }
    }

    public void updateTask(int id, String title, String description, LocalDateTime dueDate) {
        if (tasks.containsKey(id)) {
            Task task = tasks.get(1);
            task.setTitle(title);
            task.setDescription(description);
            task.setDueDate(dueDate);
        }
    }

    public void toggleCompletion(Task task) {
        if (task != null) {
            task.setDone(!task.isDone());
        }
    }

    public Task getTask(Integer id) {
        return tasks.get(id);
    }

    public Map<Integer, Task> getTasks() {
        return tasks;
    }


}
