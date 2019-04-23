<!DOCTYPE html>
<%@page import="com.nebula.domain.dao.DbThreadDao" %>
<%@page import="com.nebula.domain.Thread" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Nebula - Feed</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
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
      <a class="navbar-brand" href="#">Nebula</a>
      <!-- Add new navbar items as list elements below -->
      <ul class="navbar-nav mr-auto">
        <a class="nav-link" href="feedlink">${sessionScope.name}</a>
      </ul>
      <button class="btn btn-secondary my-2 my-sm-0" onclick="window.location.replace('post.jsp');">Post</button>
    </nav>
    <%
      if(request.getAttribute("threads")!=null) {
        System.out.println("Hello!");
        ArrayList<Thread> threads = (ArrayList<Thread>) request.getAttribute("threads");
        for(Thread t : threads) {
    %>
    <a>
      <div class="card text-white bg-primary mb-3" onclick="window.location.replace('/post?id='+<%=t.getId()%>)">
        <div class="card-header"><%=t.getCustomerId()%> - <%=t.getLocation().getCity()%></div>
        <div class="card-body">
          <h3 class="card-title"><%=t.getOpeningPost().getTitle()%></h3>
          <p class="card-text"><%=t.getOpeningPost().getBody()%></p>
        </div>
      </div>
    </a>
    <%}}else{System.out.println("nuthin;");}%>
    <script type="text/javascript">
      var postTemplate = document.getElementById('post-template');

      function testPost(){
        //document.getElementById('post-body').appendChild(postTemplate.content.cloneNode(true));
      }

      testPost();
      testPost();
      testPost();
    </script>
  </body>
</html>
