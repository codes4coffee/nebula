var commentTemplate = document.getElementById('comment-template');
var postTemplate = document.getElementById('post-template');

function testPost(){
  document.body.appendChild(postTemplate.content.cloneNode(true));
}
function testComment(){
  document.body.appendChild(commentTemplate.content.cloneNode(true));
}
