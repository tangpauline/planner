package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    long id;
    String name;
    String description;
    LocalDate dueDate;
    LocalDate createdAt;
    String status;
    Boolean isDone;

    String weekday;
    String dueDateString;

    /* Initialize task. */
    public Task(String name, String description, LocalDate dueDate) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.createdAt = LocalDate.now();
        this.status = "created";
        this.isDone = false;

        this.weekday = getDayOfWeek();
        this.dueDateString = reformattedDate(dueDate);
    }

    /* Returns the day of the week of the due date, represented as a lowercase string. ex: "monday", "tuesday" */
    public String getDayOfWeek() {
        LocalDate date = this.dueDate;
        return date.getDayOfWeek().toString().toLowerCase();
    }

    /* Formats the due date from standard LocalDate format to MM/dd/yyyy. */
    public String reformattedDate(LocalDate date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String reformatted = date.format(df);
        return reformatted;
    }

    /********** Getter methods **********/
    /* Return task id. */
    public long getId() {
        return this.id;
    }

    /* Return task name. */
    public String getName() {
        return this.name;
    }

    /* Return task description. */
    public String getDescription() {
        return this.description;
    }

    /* Return task due date. */
    public LocalDate getDueDate() {
        return this.dueDate;
    }

    /* Return task creation date. */
    public LocalDate getCreatedAt() {
        return this.createdAt;
    }

    /* Return task completion status. */
    public Boolean getIsDone() {
        return this.isDone;
    }

    /* Return task status. */
    public String getStatus() {
        return this.status;
    }

    /* Return weekday of task. */
    public String getWeekday() {
        return this.weekday;
    }

    /* Return due date reformatted. */
    public String getDueDateString() { return this.dueDateString; }

    /********** Setter methods **********/
    /* Set task id. */
    public void setId(long id) {
        this.id = id;
    }

    /* Set task name. */
    public void setName(String name) {
        this.name = name;
    }

    /* Set task description. */
    public void setDescription(String description) {
        this.description = description;
    }

    /* Set task due date. */
    public void setDueDate(LocalDate date) {
        this.dueDate = date;
    }

    /* Set task creation date. */
    public void setCreatedAt(LocalDate date) {
        this.createdAt = date;
    }

    /* Set task completion status. */
    public void setIsDone(boolean done) {
        this.isDone = done;
    }

    /* Set task status. */
    public void setStatus(String status) {
        this.status = status;
    }
}