<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Planner</title>

        <link rel="stylesheet"
         href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <style><%@include file="file/style.css"%></style>

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

            <div class="select">
                <p>Select an option above<br>to get started!</p>
            </div>

        </div>
    </body>
</html>