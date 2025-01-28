package ca.sheridan.dobbsd;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private boolean isComplete;

    public Task(int id, String title, String description, LocalDateTime dueDate, boolean isComplete) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDateTime getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
    public boolean isComplete() {
        return isComplete;
    }
    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    
}
