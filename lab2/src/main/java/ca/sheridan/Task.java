package ca.sheridan;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Task {
    private int id;
    private String title;
    private String description;
    private boolean done;
    private LocalDateTime dueDate;

    public Task(int id, String title, String description, boolean done, LocalDateTime dueDate) {
        this.id = id;
        this.done = done;

        if (title != null && !title.trim().isEmpty()) 
            this.title = title;
        else
            this.title = "Task";
        
        if (description != null && !description.trim().isEmpty()) 
            this.description = description;
        else
            this.description = "Description";

        if (dueDate != null) 
            this.dueDate = dueDate;
        else
            this.dueDate = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS); 
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
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null && !description.trim().isEmpty()) {
            this.description = description;
        }
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
        if (dueDate != null) {
            this.dueDate = dueDate;
        }
    }
}
