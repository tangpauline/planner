package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Dao;
import model.Task;
import model.TaskDao;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/* Handles communication between the server and appropriate responses from the backend.*/
@WebServlet("/")
public class TaskController extends HttpServlet {
    private Dao taskDao;

    /* Initialize servlet. */
    @Override
    public void init() {
        taskDao = new TaskDao();
    }

    /* Handle POST requests (server->backend). */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/add":
                    addTask(request, response);
                    break;
                case "/delete":
                    deleteTask(request, response);
                    break;
                case "/edit":
                    editTask(request, response);
                    break;
                default:
//                    System.out.println("defaulted in post");
                    showAll(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    /* Handle GET requests (backend->server). */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    newForm(request, response);
                    break;
                case "/edit-form":
                    editForm(request, response);
                    break;
                case "/show":
                    showAll(request, response);
                    break;
                case "/show-week":
                    showWeek(request, response);
                    break;
                case "/delete":
                    deleteTask(request, response);
                    break;
                default:
//                    System.out.println("defaulted in get");
                    showAll(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }

    }

    /* Display all tasks. */
    private void showAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        List<Task> listTasksSunday = taskDao.listAllTasksFromWeekday("sunday");
        request.setAttribute("listTasksSunday", listTasksSunday);
        List<Task> listTasksMonday = taskDao.listAllTasksFromWeekday("monday");
        request.setAttribute("listTasksMonday", listTasksMonday);
        List<Task> listTasksTuesday = taskDao.listAllTasksFromWeekday("tuesday");
        request.setAttribute("listTasksTuesday", listTasksTuesday);
        List<Task> listTasksWednesday = taskDao.listAllTasksFromWeekday("wednesday");
        request.setAttribute("listTasksWednesday", listTasksWednesday);
        List<Task> listTasksThursday = taskDao.listAllTasksFromWeekday("thursday");
        request.setAttribute("listTasksThursday", listTasksThursday);
        List<Task> listTasksFriday = taskDao.listAllTasksFromWeekday("friday");
        request.setAttribute("listTasksFriday", listTasksFriday);
        List<Task> listTasksSaturday = taskDao.listAllTasksFromWeekday("saturday");
        request.setAttribute("listTasksSaturday", listTasksSaturday);

        RequestDispatcher dispatcher = request.getRequestDispatcher("week.jsp");
        dispatcher.forward(request, response);
    }

    /* Display all tasks for the current week only. */
    private void showWeek(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Task> listTasksSunday = taskDao.listAllTasksFromWeekdayCurrWeek("sunday");
        request.setAttribute("listTasksSunday", listTasksSunday);
        List<Task> listTasksMonday = taskDao.listAllTasksFromWeekdayCurrWeek("monday");
        request.setAttribute("listTasksMonday", listTasksMonday);
        List<Task> listTasksTuesday = taskDao.listAllTasksFromWeekdayCurrWeek("tuesday");
        request.setAttribute("listTasksTuesday", listTasksTuesday);
        List<Task> listTasksWednesday = taskDao.listAllTasksFromWeekdayCurrWeek("wednesday");
        request.setAttribute("listTasksWednesday", listTasksWednesday);
        List<Task> listTasksThursday = taskDao.listAllTasksFromWeekdayCurrWeek("thursday");
        request.setAttribute("listTasksThursday", listTasksThursday);
        List<Task> listTasksFriday = taskDao.listAllTasksFromWeekdayCurrWeek("friday");
        request.setAttribute("listTasksFriday", listTasksFriday);
        List<Task> listTasksSaturday = taskDao.listAllTasksFromWeekdayCurrWeek("saturday");
        request.setAttribute("listTasksSaturday", listTasksSaturday);

        RequestDispatcher dispatcher = request.getRequestDispatcher("week.jsp");
        dispatcher.forward(request, response);
    }

    /* Add a new task based on what was submitted from the form into our sql database. */
    private void addTask(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dueDate = LocalDate.parse(request.getParameter("dueDate"), df);

        Task newTask = new Task(name, description, dueDate);

        String status = request.getParameter("status");
        newTask.setStatus(status);

        if (status.equals("completed")) {
            newTask.setIsDone(true);
        }

        taskDao.addTaskToWeekday(newTask);

        response.sendRedirect("show");
    }

    /* Remove the appropriate task from the sql database. */
    private void deleteTask(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String weekday = request.getParameter("weekday");

        taskDao.deleteTask(weekday, id);

        response.sendRedirect("show");
    }

    /* Edit and update the details of an existing task. */
    private void editTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        long id = Long.parseLong(request.getParameter("id"));

        String name = request.getParameter("name");
        String description = request.getParameter("description");

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dueDate = LocalDate.parse(request.getParameter("dueDate"), df);

        Task newTask = new Task(name, description, dueDate);

        newTask.setId(id);

        String status = request.getParameter("status");
        newTask.setStatus(status);

        if (status.equals("completed")) {
            newTask.setIsDone(true);
        }

        taskDao.editTask(newTask);

        response.sendRedirect("show");
    }

    /* Display the form to add a new task. */
    private void newForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("new-task.jsp");
        dispatcher.forward(request, response);
    }

    /* Display the form to edit an existing task. */
    private void editForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        long id = Long.parseLong(request.getParameter("id"));
        String weekday = request.getParameter("weekday");

        Task task = taskDao.getTask(weekday, id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("new-task.jsp");
        request.setAttribute("task", task);
        dispatcher.forward(request, response);
    }
}
