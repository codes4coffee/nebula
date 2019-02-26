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
    <template id="post-template">
      <div class="card text-white bg-primary mb-3" onclick="alert('hi')">
        <div class="card-header">Header</div>
        <div class="card-body">
          <h3 class="card-title">Title</h3>
          <p class="card-text">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
          </p>
        </div>
      </div>
    </template>

    <template id="comment-template">
      <div class="card text-white bg-secondary mb-3">
        <div class="card-header">Header</div>
        <div class="card-body">
          <h3 class="card-title">Title</h3>
          <p class="card-text">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
          </p>
        </div>
      </div>
    </template>

    <nav class="navbar navbar-expand-g navbar-dark bg-light">
      <!-- The line below will probably be replaced with a logo eventually -->
      <a class="navbar-brand" href="#">Nebula</a>

      <!-- Add new navbar items as list elements below -->
      <ul class="navbar-nav mr-auto">
        <a class="nav-link" href="feedlink">Feed</a>
      </ul>
      <button class="btn btn-secondary my-2 my-sm-0">Post</button>
    </nav>

    <div class="container-fluid" id="post-body">
    </div>
    <script type="text/javascript">
      var commentTemplate = document.getElementById('comment-template');
      var postTemplate = document.getElementById('post-template');

      function testPost(){
        document.getElementById('post-body').appendChild(postTemplate.content.cloneNode(true));
      }
      function testComment(){
        document.getElementById('post-body').appendChild(commentTemplate.content.cloneNode(true));
      }
      testPost();
      testComment();
    </script>
  </body>
</html>
