<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Planner</title>

        <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">

        <link rel="stylesheet"
         href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <style><%@include file="style/index.css"%></style>

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Bakbak+One&family=Poppins:wght@300;600&display=swap" rel="stylesheet">
    </head>

    <body>
        <!-- Nav bar icon. -->
        <nav>
            <div class="nav-items">
                <div class="home">
                    <a href="<%=request.getContextPath()%>" class="home-item"><i class="fa fa-home" aria-hidden="true"></i></a>
                </div>

                <div class="nav-log-reg">
                    <a href="<%=request.getContextPath()%>/login-page">Login</a>
                    <a href="<%=request.getContextPath()%>">Register</a>
                </div>
            </div>
        </nav>

        <!-- Content -->
        <div class="view">
            <h1 class="title">My planner</h1>

            <div class="body">
                <!-- Login/Register -->
                <p>Log in to an existing account or register one now to begin!</p>

                <form action="register" method="post">
                    <h2>Register now</h2>

                    <!-- First name -->
                    <div id="form-first-name" class="form-element">
                        <label>First name</label>
                        <input type="text" class="form-control" name="firstName" required="required" minlength="1" value="${firstName}">
                    </div>

                    <br>

                    <!-- Last name -->
                    <div id="form-last-name" class="form-element">
                        <label>Last name</label>
                        <input type="text" class="form-control" name="lastName" required="required" minlength="1" value="${lastName}">
                    </div>

                    <br>

                    <!-- Username -->
                    <div id="form-username" class="form-element">
                        <label>Username</label>
                        <input type="text" class="form-control" name="username" required="required" minlength="3">
                    </div>

                    <br>

                    <!-- Password -->
                    <div id="form-password" class="form-element">
                        <label>Password</label>
                        <input type="password" class="form-control" name="password" required="required" minlength="8">
                    </div>

                    <br>

                    <div class="buttons">
                        <button id="reg-button" type="submit" class="btn btn-success">Register</button>
                        <a href="<%=request.getContextPath()%>/login-page">Login to an existing account</a>
                    </div>

                    <p id="error-msg"><c:out value="${error_message}"/></p>
                </form>
            </div>
        </div>
    </body>
</html>