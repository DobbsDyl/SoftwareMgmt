package ca.sheridan;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;

public class TaskManager {
    
    public Map<Integer, Task> tasks = new HashMap<Integer, Task>();

    public boolean addTask(Task task) {
        if (task == null) {
            return false;
        } else {
            tasks.put(task.getTitle(), task);
            return true;
        }
    }


    public Task getTask(String title) {
        return tasks.get(title);
    }

    public Map<Integer, Task> getTasks() {
        return tasks;
    }
}
