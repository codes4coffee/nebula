<%--
  Created by IntelliJ IDEA.
  User: williamsmith
  Date: 2/21/19
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.nebula.db.DbManager" %>
<%@page import="java.sql.Connection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Login - Nebula</title>
    <link rel="stylesheet" href="bsdarkly.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="script.js"></script>
    <style type="text/css">
        .container-fluid {
            margin-right: auto;
            margin-left: auto;
            max-width: 500px;
            min-width: 250px;
            min-height: 80vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <h1><b>Nebula</b></h1>
    <%
        DbManager db = new DbManager();
        Connection conn = db.getConnection();
        if (conn == null)
            out.print("<div class=\"alert alert-danger\" role=\"alert\">" +
                    "The system was unable to communicate with the database server. Login will not be available." +
                    "</div>");
        else
            out.print("<div class=\"alert alert-success\" role=\"alert\">" +
                    "MySQL Connection was successful!" +
                    "</div>");

    %>
    <form name="loginform" action="LoginController" method="post" onsubmit="return loginValidate()">
        <div class="form-group">
            <label for="username">Username</label>
            <div class="input-group">
                <div class="input-group-prepend">
                    <div class="input-group-text">@</div>
                </div>
                <input type="text" class="form-control" name="username" id="username" placeholder="Username">
            </div>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary" name="submit" value="login">Log In</button>
        <button type="button" class="btn btn-secondary" onclick="location.href='/register.jsp';">Register</button>
    </form>

</div>
</body>
</html>