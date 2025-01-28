package ca.sheridan;

import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    
    public Map<String, Task> tasks = new HashMap<String, Task>();

    public boolean addTask(Task task) {
        if (task == null) {
            return false;
        } else {
            tasks.put(task.getTitle(), task);
            return true;
        }
    }

    public boolean removeTask(Task task) {
        if (task == null) {
            return false;
        } else {
            tasks.remove(task.getTitle());
            return true;
        }
    }

    public Task getTask(String title) {
        return tasks.get(title);
    }

    public Map<String, Task> getTasks() {
        return tasks;
    }
}
