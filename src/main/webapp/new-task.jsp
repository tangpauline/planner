<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
    <title>Planner - New Task</title>

    <link rel="stylesheet"
     href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
     integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
     crossorigin="anonymous">

    <link rel="stylesheet"
     href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <style><%@include file="style/form.css"%></style>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;600&display=swap" rel="stylesheet">

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

        <section id="content">
            <div class="card">
                <div class="card-body">
                    <!-- Determine whether we are adding a new task, or editing an existing task. -->
                    <c:if test="${task != null}">
                        <form action="edit" method="post">
                        <h2>Edit Task</h2>
                    </c:if>
                    <c:if test="${task == null}">
                        <form action="add" method="post">
                        <h2>Add Task</h2>
                    </c:if>

                    <!-- Edit form: obtain Id of existing task -->
                    <c:if test="${task != null}">
                        <input type="hidden" name="id" value="<c:out value='${task.id}'/>"/>
                    </c:if>

                    <!-- Name of task -->
                    <fieldset class="form-group">
                        <label>Task</label>
                        <input type="text" value="<c:out value='${task.name}'/>" class="form-control" name="name" required="required" minlength="1">
                    </fieldset>

                    <!-- Due date of task -->
                    <fieldset class="form-group">
                        <label>Due Date</label>
                        <input type="date" value="<c:out value='${task.dueDate}'/>" class="form-control" name="dueDate" required="required">
                    </fieldset>

                    <!-- Description of task -->
                    <fieldset class="form-group">
                        <label>Description</label>
                        <textarea class="form-control" name="description" minlength="5" rows="4" cols="50"><c:out value='${task.description}'/></textarea>
                    </fieldset>

                    <!-- Set status of task -->
                    <fieldset class="form-group">
                        <label>Status</label>
                            <select class="form-control" name="status">
                                <option value="created">created</option>
                                <option value="in progress">in progress</option>
                                <option value="completed">completed</option>
                                <option value="cancelled">cancelled</option>
                            </select>
                    </fieldset>

                    <div class="buttons">
                        <button id="back-btn" type="button" class="btn btn-secondary" name="back" onclick="history.back()">Back</button>
                        <button id="sub-btn" type="submit" class="btn btn-success">Save</button>
                    </div>

                    </form>
                </div>
            </div>
        </section>
    </body>
</html>