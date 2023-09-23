<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Planner - Week</title>

        <style><%@include file="style/style.css"%></style>
        <link rel="stylesheet"
         href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
         integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
         crossorigin="anonymous">

        <link rel="stylesheet"
         href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Bakbak+One&family=Poppins:wght@300;600&display=swap" rel="stylesheet">
    </head>

    <body>
        <!-- Navigation bar. -->
        <nav>
            <div class="nav-items">
                <div class="home">
                    <a href="<%=request.getContextPath()%>/home" class="home-item"><i class="fa fa-home" aria-hidden="true"></i></a>
                </div>

                <div class="logout">
                    <a href="<%=request.getContextPath()%>/logout">Logout</a>
                </div>
            </div>
        </nav>

        <!-- Content -->
        <div class="view">

            <!-- Headings -->
            <div id="heading">
                <h1 class="title">My planner</h1>
                <!-- <p>Welcome back, <c:out value="${user.getFirstName()}"/>!</p> -->
                <h2 id="welcome-msg">Welcome back, <c:out value="${user.getFirstName()}"/>!</h2>
            </div>

            <br>

            <form action="display" method="get">
                <div id="display-options-div">
                    <label for="display-options">Display:&nbsp;&nbsp;</label>
                    <select name="display-options" class="form-control" id="display-options">
                        <option value="" disabled selected><c:out value="${optionSelected}"/></option>
                        <option value="All tasks">All tasks</option>
                        <option value="Current week tasks">Current week tasks</option>
                        <option value="Upcoming tasks">Upcoming tasks</option>
                    </select>
                </div>

                <div id="display-sub-btn-div">
                    <button id="display-sub-btn" type="submit" class="btn btn-success">Show</button>
                </div>

            </form>

            <div class="line"></div>

            <!-- Redirects to the form to add a new task. -->
            <div class="add-button">
                <a href="<%=request.getContextPath()%>/new">+ Add Task</a>
            </div>

            <!-- Week spread -->
            <div class="week">
                <div id="sunday" class="weekday">
                    <div id="sunday-heading" class="weekday-heading">
                        <p>Sunday</p>
                    </div>

                    <div class="weekday-column">
                        <c:forEach var="task" items="${listTasksSunday}">
                            <div class="box">
                                <h3><c:out value="${task.name}"/></h3>
                                <p class="small-text"><b>due:</b> <c:out value="${task.dueDateString}"/></p>
                                <p class="small-text"><b>status:</b> <c:out value="${task.status}"/></p>
                                <p class="desc"><c:out value="${task.description}"/></p>
                                <div class="buttons">
                                    <div class="task-button" id="delete-button">
                                        <a href="delete?id=<c:out value='${task.id}'/>" method="post"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                                    </div>
                                    <div class="task-button" id="edit-button">
                                        <a href="edit-form?id=<c:out value='${task.id}'/>"><i class="fa fa-pencil" aria-hidden="true"></i></a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>

                <div id="monday" class="weekday">
                    <div id="monday-heading" class="weekday-heading">
                        <p>Monday</p>
                    </div>

                    <div class="weekday-column">
                        <c:forEach var="task" items="${listTasksMonday}">
                            <div class="box">
                                <h3><c:out value="${task.name}"/></h3>
                                <p class="small-text"><b>due:</b> <c:out value="${task.dueDateString}"/></p>
                                <p class="small-text"><b>status:</b> <c:out value="${task.status}"/></p>
                                <p class="desc"><c:out value="${task.description}"/></p>
                                <div class="buttons">
                                    <div class="task-button" id="delete-button">
                                        <a href="delete?id=<c:out value='${task.id}'/>" method="post"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                                    </div>
                                    <div class="task-button" id="edit-button">
                                        <a href="edit-form?id=<c:out value='${task.id}'/>"><i class="fa fa-pencil" aria-hidden="true"></i></a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div id="tuesday" class="weekday">
                    <div id="tuesday-heading" class="weekday-heading">
                        <p>Tuesday</p>
                    </div>
                    <div class="weekday-column">
                        <c:forEach var="task" items="${listTasksTuesday}">
                            <div class="box">
                                <h3><c:out value="${task.name}"/></h3>
                                <p class="small-text"><b>due:</b> <c:out value="${task.dueDateString}"/></p>
                                <p class="small-text"><b>status:</b> <c:out value="${task.status}"/></p>
                                <p class="desc"><c:out value="${task.description}"/></p>
                                <div class="buttons">
                                    <div class="task-button" id="delete-button">
                                        <a href="delete?id=<c:out value='${task.id}'/>" method="post"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                                    </div>
                                    <div class="task-button" id="edit-button">
                                        <a href="edit-form?id=<c:out value='${task.id}'/>"><i class="fa fa-pencil" aria-hidden="true"></i></a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div id="wednesday" class="weekday">
                    <div id="wednesday-heading" class="weekday-heading">
                        <p>Wednesday</p>
                    </div>
                    <div class="weekday-column">
                        <c:forEach var="task" items="${listTasksWednesday}">
                            <div class="box">
                                <h3><c:out value="${task.name}"/></h3>
                                <p class="small-text"><b>due:</b> <c:out value="${task.dueDateString}"/></p>
                                <p class="small-text"><b>status:</b> <c:out value="${task.status}"/></p>
                                <p class="desc"><c:out value="${task.description}"/></p>
                                <div class="buttons">
                                    <div class="task-button" id="delete-button">
                                        <a href="delete?id=<c:out value='${task.id}'/>" method="post"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                                    </div>
                                    <div class="task-button" id="edit-button">
                                        <a href="edit-form?id=<c:out value='${task.id}'/>"><i class="fa fa-pencil" aria-hidden="true"></i></a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div id="thursday" class="weekday">
                    <div id="thursday-heading" class="weekday-heading">
                        <p>Thursday</p>
                    </div>
                    <div class="weekday-column">
                        <c:forEach var="task" items="${listTasksThursday}">
                            <div class="box">
                                <h3><c:out value="${task.name}"/></h3>
                                <p class="small-text"><b>due:</b> <c:out value="${task.dueDateString}"/></p>
                                <p class="small-text"><b>status:</b> <c:out value="${task.status}"/></p>
                                <p class="desc"><c:out value="${task.description}"/></p>
                                <div class="buttons">
                                    <div class="task-button" id="delete-button">
                                        <a href="delete?id=<c:out value='${task.id}'/>" method="post"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                                    </div>
                                    <div class="task-button" id="edit-button">
                                        <a href="edit-form?id=<c:out value='${task.id}'/>"><i class="fa fa-pencil" aria-hidden="true"></i></a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div id="friday" class="weekday">
                    <div id="friday-heading" class="weekday-heading">
                        <p>Friday</p>
                    </div>
                    <div class="weekday-column">
                        <c:forEach var="task" items="${listTasksFriday}">
                            <div class="box">
                                <h3><c:out value="${task.name}"/></h3>
                                <p class="small-text"><b>due:</b> <c:out value="${task.dueDateString}"/></p>
                                <p class="small-text"><b>status:</b> <c:out value="${task.status}"/></p>
                                <p class="desc"><c:out value="${task.description}"/></p>
                                <div class="buttons">
                                    <div class="task-button" id="delete-button">
                                        <a href="delete?id=<c:out value='${task.id}'/>" method="post"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                                    </div>
                                    <div class="task-button" id="edit-button">
                                        <a href="edit-form?id=<c:out value='${task.id}'/>"><i class="fa fa-pencil" aria-hidden="true"></i></a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div id="saturday" class="weekday">
                    <div id="saturday-heading" class="weekday-heading">
                        <p>Saturday</p>
                    </div>
                    <div class="weekday-column">
                        <c:forEach var="task" items="${listTasksSaturday}">
                            <div class="box">
                                <h3><c:out value="${task.name}"/></h3>
                                <p class="small-text"><b>due:</b> <c:out value="${task.dueDateString}"/></p>
                                <p class="small-text"><b>status:</b> <c:out value="${task.status}"/></p>
                                <p class="desc"><c:out value="${task.description}"/></p>
                                <div class="buttons">
                                    <div class="task-button" id="delete-button">
                                        <a href="delete?id=<c:out value='${task.id}'/>" method="post"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                                    </div>
                                    <div class="task-button" id="edit-button">
                                        <a href="edit-form?id=<c:out value='${task.id}'/>"><i class="fa fa-pencil" aria-hidden="true"></i></a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
