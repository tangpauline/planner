# planner
## A Java-based Planner web application

### Introduction:

As a big planner myself, I’ve gone through a variety of task management services, from a physical bullet journal to creating my own Notion template for tracking my upcoming tasks. Inspired by the current layout I have created in Notion, I wanted to replicate the week view that I found works best for me, while also making it easier to operate the CRUD functions and look visually appealing.

### Technologies used:

- Java 17.0.4.1
- JSP (HTML/CSS)
- Jakarta Servlet API (HttpServlet)
- Bootstrap 4.3.1
- MySQL
- JDBC
- Tomcat 10.1.11
- IntelliJ IDEA (+ Smart Tomcat plugin)

This is a full-stack web project created using the Maven webapp archetype and programmed using Java. This project implements CRUD (create, read, update, delete) operations to allow users to interact with their tasks. The JSP pages are styled with CSS with the help of Bootstrap 4.3.1.. The Jakarta Servlet API is used to handle HTTP requests/responses to and from the server. Information about the tasks are stored in a MySQL database containing 7 tables (one for each day of the week) and communicates with the Java code using JDBC to form a connection and execute appropriate queries in the DAO layer. To run the web application, configure and start a Tomcat server and access it with: [http://localhost:8080/weekly-tasks/](http://localhost:8080/weekly-tasks/show) (here the context path is ‘weekly-tasks’).
