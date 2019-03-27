<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Post Comment - Nebula</title>
    <link rel="stylesheet" href="bsdarkly.css">
    <link rel="stylesheet" href="bsdarkly-mods.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="script.js"></script>
</head>
<body>
    <div class="container-fluid">
        <h1><b>Nebula</b></h1>
        <form name="postform" action="create-thread" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <div class="input-group">
                    <input type="text" class="form-control" name="title" id="title" placeholder="Frog Legs" />
                </div>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <div class="input-group">
                    <textarea class="form-control" rows="5" id="description" placeholder="I found a box of frog legs."></textarea>
                </div>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-primary" onclick="alert('Not implemented yet.');">Upload Image</button>
            </div>
            <button type="submit" name="submit" class="btn btn-primary">Post</button>
            <a class="btn btn-secondary" onclick="window.location.replace('/feed');">Cancel</a>
        </form>
    </div>
</body>
</html>
