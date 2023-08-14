package model;

import java.sql.SQLException;
import java.util.List;

/* Interface handling CRUD operations with the mySQL database. */
public interface Dao {
    void addTaskToWeekday(Task task) throws SQLException;

    void deleteTask(long id) throws SQLException;

    void editTask(Task task) throws SQLException;

    Task getTask(long id) throws SQLException;

    List<Task> listAllTasksFromWeekday(String weekday) throws SQLException;

    List<Task> listAllTasksFromWeekdayCurrWeek(String weekday) throws SQLException;
}
