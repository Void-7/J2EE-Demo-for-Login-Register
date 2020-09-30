<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  session.removeAttribute("id");
%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>热烈欢迎您莅临登录！</title>
  <link rel="stylesheet" href="style/style.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
</head>
<body>
<form action="LoginServlet" method="post" class="login-form">
  <h1>Login🍉 </h1>
  <div class="txtb">
    <input type="text" name="userId">
    <span data-placeholder="UserId"></span>
  </div>
  <div class="txtb">
    <input type="password" name="userPas">
    <span data-placeholder="Password"></span>
  </div>
  <input type="submit" class="logbtn" value="Login">
  <br>
  <input type="reset" class="resbtn" value="Reset">
  <div class="bottom-text">no account？
    <a href="Register.jsp" target="window">click me</a>
  </div>

</form>
<script type="text/javascript">
  $(".txtb input").on("focus", function() {
    $(this).addClass("focus");
  });
</script>
<script type="text/javascript">
  $(".txtb input").on("blur", function() {
    if ($(this).val() == "")
      $(this).removeClass("focus");
  });
</script>
</body>
</html>
