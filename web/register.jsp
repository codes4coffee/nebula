<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <script type="text/javascript" src="script.js"></script>
    <link rel="stylesheet" href="bsdarkly.css">
    <link rel="stylesheet" href="bsdarkly-mods.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Registration - Nebula</title>

</head>
<body>

<div class="container-fluid">
    <h2><b>Registration</b></h2>
    <form name="regform" action="/RegisterValidationController" method="post" onsubmit="return regValidate()">
        <div class="form-group">
            <label for="username">Username</label>
            <div class="input-group">
                <div class="input-group-prepend">
                    <div class="input-group-text">@</div>
                </div>
                <input type="text" class="form-control" name="username" id="username" placeholder="JohnDoeRocks">
            </div>
        </div>

        <div class="form-group">
            <label for="name">Full Name</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="John Doe">
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="password1">
        </div>

        <div class="form-group">
            <label for="retry-password">Confirm Password</label>
            <input type="password" class="form-control" name="retry-password" id="retry-password" placeholder="password1">
        </div>

        <button type="submit" name="submit" class="btn btn-primary">Register</button>
        <button type="reset" name="reset" class="btn btn-secondary">Reset</button>
        <button type="button" class="btn btn-secondary" onclick="location.href='./LoginController';">Return to Login</button>

    </form>
</div>

</body>
</html>