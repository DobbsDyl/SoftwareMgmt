package ca.sheridan;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String title;
    private String description;
    private boolean done;
    private LocalDateTime dueDate;

    public Task(int id, String title, String description, boolean done, LocalDateTime dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
        this.dueDate = dueDate;
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    
}
