package ru.Tanya.spingMVCapp.models;

import javax.validation.constraints.NotEmpty;


public class Task {

    private String Id;
    private int Priority;
    @NotEmpty(message = "Name shouldn`t be empty")
    private String Name;
    private String Description;
    private boolean Done;
    public Task()
    {

    }

    public Task(String id, int priority, String name, String description, boolean done) {
        this.Id = id;
        this.Priority = priority;
        Name = name;
        Description = description;
        Done = done;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int priority) {
        this.Priority = priority;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isDone() {
        return Done;
    }

    public void setDone(boolean done) {
        Done = done;
    }
}
