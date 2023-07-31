package model;

import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/* CRUD operations for the SQL database tables. */
public class TaskDao implements Dao {

    public TaskDao() {}

    /* Add new task into appropriate weekday table. */
    @Override
    public void addTaskToWeekday(Task task) throws SQLException {
        String weekday = task.getDayOfWeek();
        String add_query =
                "INSERT INTO " +
                        weekday +
                        " (task_name, task_description, due_date, created_at, is_done, task_status) VALUES " +
                        " (?, ?, ?, ?, ?, ?);";

        try (Connection connection = Utils.getConnection(); PreparedStatement statement = connection.prepareStatement(add_query)) {
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setDate(3, Utils.getSqlDate(task.getDueDate()));
            statement.setDate(4, Utils.getSqlDate(task.getCreatedAt()));
            statement.setBoolean(5, task.getIsDone());
            statement.setString(6, task.getStatus());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /* Selects all tasks for the given weekday, sorted by closest due date. */
    @Override
    public List<Task> listAllTasksFromWeekday(String weekday) throws SQLException {
        List<Task> tasks = new ArrayList<>();
        String select_query =
                "select * from " +
                        weekday +
                        " order by due_date ASC;";

        try (Connection connection = Utils.getConnection(); PreparedStatement statement = connection.prepareStatement(select_query)) {
            ResultSet res = statement.executeQuery();

            // go through each row in the table and retrieve their values
            while (res.next()) {
                String name = res.getString("task_name");
                String description = res.getString("task_description");
                LocalDate dueDate = Utils.getLocalDate(res.getDate("due_date"));

                Task newTask = new Task(name, description, dueDate);

                long id = res.getLong("id");
                newTask.setId(id);
                boolean isDone = res.getBoolean("is_done");
                newTask.setIsDone(isDone);
                LocalDate createdAt = Utils.getLocalDate(res.getDate("created_at"));
                newTask.setCreatedAt(createdAt);
                String status = res.getString("task_status");
                newTask.setStatus(status);

                tasks.add(newTask);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tasks;
    }

    /* Selects all tasks for the given weekday for the current week only, sorted by closest due date. */
    @Override
    public List<Task> listAllTasksFromWeekdayCurrWeek(String weekday) throws SQLException {
        List<Task> tasks = new ArrayList<>();
        LocalDate[] dates = Utils.getDatesCurrWeek();

        LocalDate sunday = dates[0];
        LocalDate saturday = dates[1];

        String sundayString = Utils.getSqlDate(sunday).toString();
        String saturdayString = Utils.getSqlDate(saturday).toString();

        String select_query =
                "select * from " +
                        weekday +
                        " where due_date between '" +
                        sundayString +
                        "' and '" +
                        saturdayString +
                        "' order by due_date ASC;";

        try (Connection connection = Utils.getConnection(); PreparedStatement statement = connection.prepareStatement(select_query)) {
            ResultSet res = statement.executeQuery();

            // go through each row in the table and retrieve their values
            while (res.next()) {
                String name = res.getString("task_name");
                String description = res.getString("task_description");
                LocalDate dueDate = Utils.getLocalDate(res.getDate("due_date"));

                Task newTask = new Task(name, description, dueDate);

                long id = res.getLong("id");
                newTask.setId(id);
                boolean isDone = res.getBoolean("is_done");
                newTask.setIsDone(isDone);
                LocalDate createdAt = Utils.getLocalDate(res.getDate("created_at"));
                newTask.setCreatedAt(createdAt);
                String status = res.getString("task_status");
                newTask.setStatus(status);

                tasks.add(newTask);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tasks;
    }

    /* Given the id and weekday, delete the task from the appropriate weekday table. Returns successful or not. */
    @Override
    public void deleteTask(String weekday, long id) throws SQLException {
        String delete_query =
                "delete from " +
                        weekday +
                        " where id = ?";
        try (Connection connection = Utils.getConnection(); PreparedStatement statement = connection.prepareStatement(delete_query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /* Update the task in the database. Return if successful. */
    @Override
    public void editTask(Task task) throws SQLException {
        String weekday = task.getWeekday();
        String update_query =
                "update " +
                        weekday +
                        " set task_name = ?, task_description = ?, due_date = ?, is_done = ?, task_status = ? where id = ?;";
        try (Connection connection = Utils.getConnection(); PreparedStatement statement = connection.prepareStatement(update_query)) {
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setDate(3, Utils.getSqlDate(task.getDueDate()));
            statement.setBoolean(4, task.getIsDone());
            statement.setString(5, task.getStatus());
            statement.setLong(6, task.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /* Select a particular task, given the weekday it belongs to and its id. */
    @Override
    public Task getTask(String weekday, long TaskId) throws SQLException {
        Task task = null;
        String get_query =
                "select id, task_name, task_description, due_date, created_at, is_done, task_status from " +
                    weekday +
                    " where id =?;";
        try (Connection connection = Utils.getConnection(); PreparedStatement statement = connection.prepareStatement(get_query)) {
            statement.setLong(1, TaskId);

            ResultSet res = statement.executeQuery();

            while (res.next()) {
                String name = res.getString("task_name");
                String description = res.getString("task_description");
                LocalDate dueDate = Utils.getLocalDate(res.getDate("due_date"));

                task = new Task(name, description, dueDate);

                task.setId(TaskId);
                boolean isDone = res.getBoolean("is_done");
                task.setIsDone(isDone);
                LocalDate createdAt = Utils.getLocalDate(res.getDate("created_at"));
                task.setCreatedAt(createdAt);
                String status = res.getString("task_status");
                task.setStatus(status);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return task;
    }
}
