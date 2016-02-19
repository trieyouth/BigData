<%--
  User: youth
  Date: 16-2-1
  Time: 下午9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
  <meta charset="UTF-8">
      <title>登录</title>
      <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css' />">
      <link href="<c:url value='/css/app.css' />" rel="stylesheet">
  <style type="text/css">
           body,html
           {
               background-image:url("<c:url value='/images/login/login-bg.jpg' />");
               background-repeat:no-repeat;
               position: center;
               background-size: 100% 100%;
               -o-background-size: 100% 100%;
               -moz-background-size: 100% 100%;
               -webkit-background-size: 100% 100%;
               width: 1600px;
               height: 900px;
               margin:0 auto;
               padding:0px;
               border:0px;
               /*选择一个和你的背景图融合的比较好的颜色, 这样做有时候会省去不少图片*/
               /*background-color: #E1F3Fd;*/
               overflow:hidden
           }
       </style>
  </head>

  <body>
   <form method="POST" name="frmLogin">
              <div id="container">
                    <div id="login-bg" >
                     <div class="user">   <input id="name" type="text" name="username" style="width:350px;height: 36px;background: #040a20"  onfocus="if (this.value=='Your name')  this.value='';" />    </div>
                     <div class="password">  <input id="password" type="password" name="password" style="width:350px;height: 36px;background-color: #040a20" onfocus="if (this.value=='Your password')  this.value='';" /> </div>
                        <div class="row" >
                        <div  class="login-row ">
                                <button class="buttonClass" type="submit" name="Submit" onClick="return validateLogin()">登录</button>
                        </div>
                        <div class="login-col ">
                            <button class="buttonClass1" type="reset" name="Reset"  >重置</button>
                      </div>
                        </div>
             </div>
            </div>
            </form>
  <script language="javascript">
   function validateLogin(){
    var sUserName = document.frmLogin.username.value ;
    var sPassword = document.frmLogin.password.value ;
    if ((sUserName =="") || (sUserName=="Your name")){
     alert("请输入用户名!");
     return false ;
    }
    if ((sPassword =="") || (sPassword=="Your password")){
     alert("请输入密码!");
     return false ;
    }
   }
  </script>

  </body>
</html>