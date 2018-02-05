package com.jim.modbplayground;

import org.springframework.data.annotation.Id;

public class TodoItems {


    @Id
    public String _id;

    public String title;
    public String description;
    public Boolean completed;
    public String completedAt;

    public TodoItems(String title, String description, Boolean completed, String completedAt) {
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.completedAt = completedAt;
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

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(String completedAt) {
        this.completedAt = completedAt;
    }
}
