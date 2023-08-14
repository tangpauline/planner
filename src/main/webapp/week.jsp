<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Planner - Week</title>

        <style><%@include file="style/style.css"%></style>

        <link rel="stylesheet"
         href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Bakbak+One&family=Poppins:wght@300;600&display=swap" rel="stylesheet">
    </head>

    <body>
        <!-- Home icon. -->
        <nav>
            <div class="home">
                <a href="<%=request.getContextPath()%>"><i class="fa fa-home" aria-hidden="true"></i></a>
            </div>
        </nav>

        <!-- Content -->
        <div class="view">
            <h1 class="title">Plan my week</h1>

            <!-- Task display options -->
            <div class="top-buttons">
                <div class="show-current-week">
                    <a href="<%=request.getContextPath()%>/show-week">Show current<br>week</a>
                </div>
                <div class="show-all">
                    <a href="<%=request.getContextPath()%>/show">Show all<br>tasks</a>
                </div>
            </div>

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

                    <div class="container">
                        <c:forEach var="task" items="${listTasksSunday}">
                            <div class="box">
                                <h3><c:out value="${task.name}"/></h3>
                                <p class="small-text"><b>due:</b> <c:out value="${task.dueDateString}"/></p>
                                <p class="small-text"><b>status:</b> <c:out value="${task.status}"/></p>
                                <p class="desc"><c:out value="${task.description}"/></p>
                                <div class="buttons">
                                    <div class="delete-button">
                                        <a href="delete?id=<c:out value='${task.id}'/>" method="post"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                                    </div>
                                    <div class="edit-button">
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

                    <div class="container">
                        <c:forEach var="task" items="${listTasksMonday}">
                            <div class="box">
                                <h3><c:out value="${task.name}"/></h3>
                                <p class="small-text"><b>due:</b> <c:out value="${task.dueDateString}"/></p>
                                <p class="small-text"><b>status:</b> <c:out value="${task.status}"/></p>
                                <p class="desc"><c:out value="${task.description}"/></p>
                                <div class="buttons">
                                    <div class="delete-button">
                                        <a href="delete?id=<c:out value='${task.id}'/>" method="post"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                                    </div>
                                    <div class="edit-button">
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
                    <div class="container">
                        <c:forEach var="task" items="${listTasksTuesday}">
                            <div class="box">
                                <h3><c:out value="${task.name}"/></h3>
                                <p class="small-text"><b>due:</b> <c:out value="${task.dueDateString}"/></p>
                                <p class="small-text"><b>status:</b> <c:out value="${task.status}"/></p>
                                <p class="desc"><c:out value="${task.description}"/></p>
                                <div class="buttons">
                                    <div class="delete-button">
                                        <a href="delete?id=<c:out value='${task.id}'/>" method="post"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                                    </div>
                                    <div class="edit-button">
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
                    <div class="container">
                        <c:forEach var="task" items="${listTasksWednesday}">
                            <div class="box">
                                <h3><c:out value="${task.name}"/></h3>
                                <p class="small-text"><b>due:</b> <c:out value="${task.dueDateString}"/></p>
                                <p class="small-text"><b>status:</b> <c:out value="${task.status}"/></p>
                                <p class="desc"><c:out value="${task.description}"/></p>
                                <div class="buttons">
                                    <div class="delete-button">
                                        <a href="delete?id=<c:out value='${task.id}'/>" method="post"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                                    </div>
                                    <div class="edit-button">
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
                    <div class="container">
                        <c:forEach var="task" items="${listTasksThursday}">
                            <div class="box">
                                <h3><c:out value="${task.name}"/></h3>
                                <p class="small-text"><b>due:</b> <c:out value="${task.dueDateString}"/></p>
                                <p class="small-text"><b>status:</b> <c:out value="${task.status}"/></p>
                                <p class="desc"><c:out value="${task.description}"/></p>
                                <div class="buttons">
                                    <div class="delete-button">
                                        <a href="delete?id=<c:out value='${task.id}'/>" method="post"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                                    </div>
                                    <div class="edit-button">
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
                    <div class="container">
                        <c:forEach var="task" items="${listTasksFriday}">
                            <div class="box">
                                <h3><c:out value="${task.name}"/></h3>
                                <p class="small-text"><b>due:</b> <c:out value="${task.dueDateString}"/></p>
                                <p class="small-text"><b>status:</b> <c:out value="${task.status}"/></p>
                                <p class="desc"><c:out value="${task.description}"/></p>
                                <div class="buttons">
                                    <div class="delete-button">
                                        <a href="delete?id=<c:out value='${task.id}'/>" method="post"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                                    </div>
                                    <div class="edit-button">
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
                    <div class="container">
                        <c:forEach var="task" items="${listTasksSaturday}">
                            <div class="box">
                                <h3><c:out value="${task.name}"/></h3>
                                <p class="small-text"><b>due:</b> <c:out value="${task.dueDateString}"/></p>
                                <p class="small-text"><b>status:</b> <c:out value="${task.status}"/></p>
                                <p class="desc"><c:out value="${task.description}"/></p>
                                <div class="buttons">
                                    <div class="delete-button">
                                        <a href="delete?id=<c:out value='${task.id}'/>" method="post"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                                    </div>
                                    <div class="edit-button">
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
