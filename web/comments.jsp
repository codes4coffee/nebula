<%@ page import="com.nebula.domain.Thread" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.nebula.domain.Message" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Nebula - Comments</title>
    <link rel="stylesheet" href="bsdarkly.css">
    <link rel="stylesheet" href="bsdarkly-mods.css">
    <style type="text/css">
      .container-fluid {
        margin-top: 8px;
      }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  <body>
    <nav class="navbar navbar-expand-g navbar-dark bg-light">
      <!-- The line below will probably be replaced with a logo eventually -->
      <a class="navbar-brand" href="/feed">Nebula</a>

      <!-- Add new navbar items as list elements below -->
      <ul class="navbar-nav mr-auto">
        ${sessionScope.name}
      </ul>
      <button class="btn btn-secondary my-2 my-sm-0" onclick="window.location.replace('postComment.jsp')">Post</button>
    </nav>

      <div class="card text-white bg-primary mb-3">
        <%Thread thread = (Thread) request.getAttribute("thread");%>
        <div class="card-header"><%=thread.getOpeningPost().getCustomerId()%></div>
        <div class="card-body">
          <h3 class="card-title"><%= thread.getOpeningPost().getTitle()%></h3>
          <p class="card-text">
            <%= thread.getOpeningPost().getBody()%>
          </p>
        </div>
      </div>
      <%
        if(!thread.getComments().isEmpty()) {
          ArrayList<Message> comments = (ArrayList<Message>) thread.getComments();
          for(Message comment : comments){
      %>
      <div class="card text-white bg-secondary mb-3">
        <div class="card-header"><%=comment.getCustomerId()%></div>
        <div class="card-body">
          <p class="card-text">
            <%=comment.getBody()%>
          </p>
        </div>
      </div>
    <%}}%>

    <div class="container-fluid" id="post-body">
    </div>
    <script type="text/javascript">

      testPost();
      testComment();
    </script>
  </body>
</html>
