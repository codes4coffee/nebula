<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Nebula - Feed</title>
    <link rel="stylesheet" href="bsdarkly.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        .container-fluid {
            margin-right: auto;
            margin-left: auto;
            margin-top:8px;
            max-width: 300px;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }
    </style>
  </head>
  <body>
    <template id="post-template">
      <div class="card text-white bg-primary mb-3" onclick="alert('hi')">
        <div class="card-header">Posted by @USER 122 feet away.</div>
        <div class="card-body">
          <h3 class="card-title">Post Title</h3>
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
      var postTemplate = document.getElementById('post-template');

      function testPost(){
        document.getElementById('post-body').appendChild(postTemplate.content.cloneNode(true));
      }

      testPost();
      testPost();
      testPost();
    </script>
  </body>
</html>
