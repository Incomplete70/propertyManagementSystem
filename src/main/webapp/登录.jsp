<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/23 0023
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="登录.css" type="text/css" rel="stylesheet" />
    <title>登录</title>
</head>
<body>

<div id="box1">
    <div id="dl"><br />
        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登录</span><br />
    </div>
    <div id="box2">
        <br /><br />
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>账号</span><br />
        <br />
        <center>
            <input class="number" name="uname" type="text" id="useName" size="11" placeholder="" width="80%" ></input>
        </center>
        <br /><br />
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>密码</span><br />
        <br />
        <center>
            <input class="number" name="upwd type="password" id="pas1" size="13"  ></input>
            <br /><br /><br /><br />
        </center>
        <center>
            <input  class="submit" id="submit" name="Submit" type="submit"  value="登录"></input>
        </center>
        <br /><br /><br /><br />
    </div>

</div>
</body>
<script type="text/javascript">



    window.onload=function(){
        var submit=document.getElementById("submit");
        var kong="";
        submit.onclick=function(){
            // var reg=/^[0-9]{11}$/;
            var usename=document.getElementById("useName").value;
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