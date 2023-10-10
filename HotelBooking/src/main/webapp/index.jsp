<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login to Your Account</title>
<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
<link href="logincss/style2.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
<div class="regbox box">
<img class="avatar" src="images/avatar.png">
<h1>
Login</h1>
<form action="LoginServlet" method="post">



<p>
User email</p>
<input type="text" placeholder="Enter your E-Mail" name="email" required>
<p>
Password</p>
<input type="password" placeholder="Enter your Password" name="password" required>
<% 
String message = (String) request.getAttribute("ErrorMsg");
%>
<%
if (message == null) {
%>
<div class="besideemailbox" style="color: red"></div>
<%
} else if (message.equals("Username Or Password Incorrect")) {
%>
<div class="besideemailbox" style="color: red">Incorrect Email or Password</div>
<%
} else if (message.equals("Passwords")) {
%>
<div class="besideemailbox" style="color: green">Passwords
Doesn't Match</div>
<%
}
%>
<input type="submit" value="Login">
<a href="Registration.jsp">No Account? Register here.</a>
</form>


</div>
</div>
</body>
</html>