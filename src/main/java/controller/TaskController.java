package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;
import model.Dao;
import model.Task;
import model.TaskDao;
import model.UserDao;
import model.User;
import utils.Utils;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/* Handles communication between the server and appropriate responses from the backend.*/
@WebServlet("/")
public class TaskController extends HttpServlet {
    private Dao taskDao;
    private UserDao userDao;

    /* Initialize servlet. */
    @Override
    public void init() {
        taskDao = new TaskDao();
        userDao = new UserDao();
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
                case "/register":
                    registerUser(request, response);
                    break;
                case "/login":
                    loginUser(request, response);
                    break;
                default:
//                    System.out.println("defaulted in post");
                    homeAll(request, response);
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
                case "/home":
                    homeAll(request, response);
                    break;
                case "/home-week":
                    homeWeek(request, response);
                    break;
                case "/home-upcoming":
                    homeUpcoming(request, response);
                    break;
                case "/delete":
                    deleteTask(request, response);
                    break;
                case "/login-page":
                    loginPage(request, response);
                    break;
                case "/logout":
                    logoutUser(request, response);
                    break;
                case "/display":
                    display(request, response);
                    break;
                default:
//                    System.out.println("defaulted in get");
                    homeAll(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }

    }

    /* Display all tasks. */
    private void homeAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession(false);

        // check to see if user is logged in, else redirect to login page
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login-page");
        } else {
            User user = (User) session.getAttribute("user");

            String firstName = user.getFirstName();
            request.setAttribute("firstName", firstName);

            String userTable = user.getTableName();

            List<Task> listTasksSunday = taskDao.listAllTasksFromWeekday("sunday", userTable);
            request.setAttribute("listTasksSunday", listTasksSunday);
            List<Task> listTasksMonday = taskDao.listAllTasksFromWeekday("monday", userTable);
            request.setAttribute("listTasksMonday", listTasksMonday);
            List<Task> listTasksTuesday = taskDao.listAllTasksFromWeekday("tuesday", userTable);
            request.setAttribute("listTasksTuesday", listTasksTuesday);
            List<Task> listTasksWednesday = taskDao.listAllTasksFromWeekday("wednesday", userTable);
            request.setAttribute("listTasksWednesday", listTasksWednesday);
            List<Task> listTasksThursday = taskDao.listAllTasksFromWeekday("thursday", userTable);
            request.setAttribute("listTasksThursday", listTasksThursday);
            List<Task> listTasksFriday = taskDao.listAllTasksFromWeekday("friday", userTable);
            request.setAttribute("listTasksFriday", listTasksFriday);
            List<Task> listTasksSaturday = taskDao.listAllTasksFromWeekday("saturday", userTable);
            request.setAttribute("listTasksSaturday", listTasksSaturday);

            RequestDispatcher dispatcher = request.getRequestDispatcher("week.jsp");
            dispatcher.forward(request, response);
        }
    }

    /* Display all tasks for the current week only. */
    private void homeWeek(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession(false);

        // check to see if user is logged in, else redirect to login page
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login-page");
        } else {
            User user = (User) session.getAttribute("user");

            String firstName = user.getFirstName();
            request.setAttribute("firstName", firstName);

            String userTable = user.getTableName();

            List<Task> listTasksSunday = taskDao.listAllTasksFromWeekdayCurrWeek("sunday", userTable);
            request.setAttribute("listTasksSunday", listTasksSunday);
            List<Task> listTasksMonday = taskDao.listAllTasksFromWeekdayCurrWeek("monday", userTable);
            request.setAttribute("listTasksMonday", listTasksMonday);
            List<Task> listTasksTuesday = taskDao.listAllTasksFromWeekdayCurrWeek("tuesday", userTable);
            request.setAttribute("listTasksTuesday", listTasksTuesday);
            List<Task> listTasksWednesday = taskDao.listAllTasksFromWeekdayCurrWeek("wednesday", userTable);
            request.setAttribute("listTasksWednesday", listTasksWednesday);
            List<Task> listTasksThursday = taskDao.listAllTasksFromWeekdayCurrWeek("thursday", userTable);
            request.setAttribute("listTasksThursday", listTasksThursday);
            List<Task> listTasksFriday = taskDao.listAllTasksFromWeekdayCurrWeek("friday", userTable);
            request.setAttribute("listTasksFriday", listTasksFriday);
            List<Task> listTasksSaturday = taskDao.listAllTasksFromWeekdayCurrWeek("saturday", userTable);
            request.setAttribute("listTasksSaturday", listTasksSaturday);

            RequestDispatcher dispatcher = request.getRequestDispatcher("week.jsp");
            dispatcher.forward(request, response);
        }
    }

    /* Display all tasks for the current week only. */
    private void homeUpcoming(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession(false);

        // check to see if user is logged in, else redirect to login page
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login-page");
        } else {
            User user = (User) session.getAttribute("user");

            String firstName = user.getFirstName();
            request.setAttribute("firstName", firstName);

            String userTable = user.getTableName();

            List<Task> listTasksSunday = taskDao.listAllUpcomingTasksFromWeekday("sunday", userTable);
            request.setAttribute("listTasksSunday", listTasksSunday);
            List<Task> listTasksMonday = taskDao.listAllUpcomingTasksFromWeekday("monday", userTable);
            request.setAttribute("listTasksMonday", listTasksMonday);
            List<Task> listTasksTuesday = taskDao.listAllUpcomingTasksFromWeekday("tuesday", userTable);
            request.setAttribute("listTasksTuesday", listTasksTuesday);
            List<Task> listTasksWednesday = taskDao.listAllUpcomingTasksFromWeekday("wednesday", userTable);
            request.setAttribute("listTasksWednesday", listTasksWednesday);
            List<Task> listTasksThursday = taskDao.listAllUpcomingTasksFromWeekday("thursday", userTable);
            request.setAttribute("listTasksThursday", listTasksThursday);
            List<Task> listTasksFriday = taskDao.listAllUpcomingTasksFromWeekday("friday", userTable);
            request.setAttribute("listTasksFriday", listTasksFriday);
            List<Task> listTasksSaturday = taskDao.listAllUpcomingTasksFromWeekday("saturday", userTable);
            request.setAttribute("listTasksSaturday", listTasksSaturday);

            RequestDispatcher dispatcher = request.getRequestDispatcher("week.jsp");
            dispatcher.forward(request, response);
        }
    }

    /* Add a new task based on what was submitted from the form into our sql database. */
    private void addTask(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        HttpSession session = request.getSession(false);

        // check to see if user is logged in, else redirect to login page
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login-page");
        } else {
            User user = (User) session.getAttribute("user");

            String userTable = user.getTableName();

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

            taskDao.addTask(newTask, userTable);

            response.sendRedirect("home");
        }


    }

    /* Remove the appropriate task from the sql database. */
    private void deleteTask(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        String userTable = user.getTableName();

        taskDao.deleteTask(id, userTable);

        response.sendRedirect("home");
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

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        String userTable = user.getTableName();

        taskDao.editTask(newTask, userTable);

        response.sendRedirect("home");
    }

    /* Display the form to add a new task. */
    private void newForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // check to see if user is logged in, else redirect to login page
        if (session == null && session.getAttribute("user") == null) {
            response.sendRedirect("login-page");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("new-task.jsp");
            dispatcher.forward(request, response);
        }
    }

    /* Display the form to edit an existing task. */
    private void editForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        long id = Long.parseLong(request.getParameter("id"));

        HttpSession session = request.getSession(false);

        // check to see if user is logged in, else redirect to login page
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login-page");
        } else {
            User user = (User) session.getAttribute("user");

            String userTable = user.getTableName();

            Task task = taskDao.getTask(id, userTable);

            RequestDispatcher dispatcher = request.getRequestDispatcher("new-task.jsp");
            request.setAttribute("task", task);
            dispatcher.forward(request, response);
        }
    }

    /* Register a new user. */
    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // if username exists, message pop up to try a diff username:
        if (userDao.userExists(username)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            request.setAttribute("firstName", request.getParameter("firstName"));
            request.setAttribute("lastName", request.getParameter("lastName"));
            request.setAttribute("error_message", "Username already exists, try another one!");
            dispatcher.forward(request, response);
        } else {
            // otherwise, add new user to users table and redirect to homepage
            User newUser = new User(firstName, lastName, username);
            newUser.setPassword(Utils.generatePassword(password));

            userDao.addUser(newUser);
            userDao.createUserTasksTable(newUser);

            HttpSession session = request.getSession(true);
            System.out.println("reg session id:");
            System.out.println(session.getId());
            session.setAttribute("user", newUser);

            response.sendRedirect("home");
        }
    }

    /* Log in a user. */
    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userDao.userExists(username)) {
            User user = userDao.getUser(username);
            String encryptedPass = user.getPassword();

            if (Utils.checkPassword(password, encryptedPass)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);
                response.sendRedirect("home");
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                request.setAttribute("username", username);
                request.setAttribute("error_message", "Password entered is incorrect, please try again");
                dispatcher.forward(request, response);
            }
        } else {
            // username is incorrect, or password does not match.
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            request.setAttribute("error_message", "Username does not exists");
            dispatcher.forward(request, response);
        }
    }

    /* Redirect to login page. */
    private void loginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    /* Log out user. */
    private void logoutUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.invalidate();

        response.sendRedirect("login-page");
    }

    /* Display options for tasks. */
    private void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // check to see if user is logged in, else redirect to login page
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login-page");
        } else {
            String displayType = request.getParameter("display-options");

            if (displayType.equals("All tasks")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("home");
                request.setAttribute("optionSelected", displayType);
                dispatcher.forward(request, response);
            } else if (displayType.equals("Current week tasks")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("home-week");
                request.setAttribute("optionSelected", displayType);
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("home-upcoming");
                request.setAttribute("optionSelected", displayType);
                dispatcher.forward(request, response);
            }

        }
    }
}
