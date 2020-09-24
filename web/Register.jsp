<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册一下吧~！</title>
    <link rel="stylesheet" href="style/style.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script type="text/javascript">
        $(function(){
            $('#id').blur(function(){
                const id = $("#id").val();
                $.ajax({
                    url:'AjaxServlet',
                    type:'POST',
                    data: {id: id},
                    dataType:'text',
                    success:function(data){
                        if(data==0){
                            $("#span01").html("<font color='red'>用户名已被注册</font>");
                        }else{
                            $("#span01").html("<font color='green'>用户名可以使用</font>");
                        }
                    },
                    error:function(){
                        alert('ajax请求失败')
                    }
                })
            })
        })
    </script>

</head>
<body>
<form action="RegisterServlet" method="post" class="reg-form">
    <h1>Sign Up🍦 </h1>
    <div class="txtb">
        <span id="span01"></span><br/>
        <input id="id" type="text" name="userId">
        <span data-placeholder="User Id"></span>
    </div>
    <div class="txtb">
        <input type="password" name="userPas">
        <span data-placeholder="Password"></span>
    </div>
    <div class="txtb">
        <input type="password" name="userPas2">
        <span data-placeholder="Password Again"></span>
    </div>
    <input type="submit" class="logbtn" value="Sign Up">
    <br>
    <input type="reset" class="resbtn" value="Reset">
    <div class="bottom-text2">signed up ok？
        <a href="index.jsp">Login in</a>
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
