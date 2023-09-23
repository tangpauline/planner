package model;

import java.sql.SQLException;
import java.util.List;

/* Interface handling CRUD operations for TASKS with the mySQL database. */
public interface TaskDaoInterface {
    /* Tasks */
    void addTask(Task task, String userTable) throws SQLException;
    void deleteTask(long id, String userTable) throws SQLException;
    void editTask(Task task, String userTable) throws SQLException;
    Task getTask(long id, String userTable) throws SQLException;
    List<Task> listAllTasksFromWeekday(String weekday, String userTable) throws SQLException;
    List<Task> listAllTasksFromWeekdayCurrWeek(String weekday, String userTable) throws SQLException;
    List<Task> listAllUpcomingTasksFromWeekday(String weekday, String userTable) throws SQLException;
}
