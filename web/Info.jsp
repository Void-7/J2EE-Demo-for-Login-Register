<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录用户信息</title>
    <link rel="stylesheet" href="style/style.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
</head>
<body>

<div class="login-form">
    <h1>Welcome!🎉 </h1>
    <%--    <div class="txtb">--%>
    <%--        Name: <p>${sessionScope.userName}</p>--%>
    <%--    </div>--%>
    <div class="txtb">
        Id: <p>${sessionScope.userId}</p>
    </div>
    <div class="txtb">
        Pas: <p>${sessionScope.userPas}</p>
    </div>
    <div class="bottom-text">wanna retry？
        <a href="index.jsp#jump">Login in</a>
    </div>
</div>
</body>
</html>
