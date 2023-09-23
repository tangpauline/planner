# planner
## A Java-based Planner web application

### Introduction:
As a big planner myself, I’ve gone through a variety of task management services, from a physical bullet journal 
to creating my own Notion template for tracking my upcoming tasks. Inspired by the current layout I have created 
in Notion, I wanted to replicate the week view that I found works best for me, while also making it easier 
to operate the CRUD functions and look visually appealing.

### Technologies used:
- Java 17.0.4.1
- JSP (HTML/CSS)
- Jakarta Servlet API (HttpServlet)
- JBCrypt
- Bootstrap 4.3.1
- MySQL
- JDBC
- Tomcat 10.1.11
- IntelliJ IDEA (+ Smart Tomcat plugin)

This is a full-stack web project created using the Maven webapp archetype and programmed using Java. 
This project features user authentication allowing users to register an account, as well as log in. 
Passwords are hashed using JBCrypt. The planner implements CRUD (create, read, update, delete) operations 
to allow users to interact with their tasks. The JSP pages are styled with CSS with the help of Bootstrap 4.3.1. to
create an intuitive and visually pleasing UI. The Jakarta Servlet API is used to handle HTTP requests/responses 
to and from the server. Information about the tasks are stored in a MySQL database containing a table "tasks" 
and communicates with the Java code using JDBC to form a connection and execute appropriate queries in the DAO layer. 
To run the web application, configure and start a Tomcat server and access it with:
[http://localhost:8080/weekly-tasks/] (http://localhost:8080/weekly-tasks/show) (here the context path is ‘weekly-tasks’).

### Data:
Data for this project is stored in a mySQL database "planner".

User data is stored in a table "users" with the following fields (example entry shown):

id | first_name | last_name | username | password |
--- | --- | --- | --- | --- |
1 | john | smith | john_smith | $2a$10$qS6aAEPGcUZX9JI4jE6y.O8DcLNSVlXk..3mp19yeaFDm91aU332O |

Each user has its own table, created upon registration, containing the following fields (example entry shown):

id | task_name | task_description | weekday | due_date | created_at | is_done | task_status |
--- | --- | --- | --- | --- |--- |--- |--- |
1 | walk dog | meet up with Coco at the dog park @4:30pm instead | saturday | 2023-09-23 00:00:00.000000 | 2023-09-23 00:00:00.000000 | 0 | created |


### Demo screenshots:
Registration page:
![Alt text](images/registration-img.png?raw=true "Home")

Login page:
![Alt text](images/login-img.png?raw=true "Home")

Home page:
![Alt text](images/home-img.png?raw=true "Home")

Display options:
![Alt text](images/display-options-img.png?raw=true "Home")

Add Task:
![Alt text](images/add-task-img.png?raw=true "Home")

Edit task:
![Alt text](images/edit-task-img.png?raw=true "Edit")