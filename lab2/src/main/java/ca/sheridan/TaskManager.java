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

}
