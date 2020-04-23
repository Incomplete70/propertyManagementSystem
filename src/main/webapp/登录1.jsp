<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/23 0023
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <meta charset="UTF-8" />
    <link href="css/注册.css" type="text/css" rel="stylesheet" />
    <title>小区管路系统登录界面</title>

</head>
<body>
<div class="kuang">
    <form action="" method="post" name="myform">
        <br />
        <h3>xx小区</h3>
        <h3>物业管理系统</h3>
        <br />

        用户名：<input class="yh" name="usename" type="text" id="UsernName1" size="13">
        <br /><br />
        密 &nbsp;&nbsp;&nbsp;码：<input class="yh" name="pwd" type="password" id=   "pas1"  size="13">

        <br /><br /><br />

        <!--
        确认密码：<input name="pwd" type="password" id="pas2" size="20"maxlength="20"></body><br /><br />
        验证码：<input name="yz" type="text" id="yzform1" maxlength="6"><br /><br />
         -->
        <center>
            <input  class="sub" name="Submit" type="submit" class="btn_grey" value="登录">
            <input class="sub" name="Submit" type="submit" class="btn_grey" value="重置">
        </center>
    </form>

</div>
</body>
<script type="text/javascript">
    window.onload=function(){
        var submit=document.getElementById("submit");
        var kong="";
        submit.onclick=function(){
            // var reg=/^[0-9]{11}$/;
            var usename=document.getElementById("UsernName1").value;
            var pas1=document.getElementById("pas1").value;
            if(usename==kong){
                alert("未输入账号");
            }
            if(pas1==kong){
                alert("未输入密码");
            }


        };
    };
</script>
</html>