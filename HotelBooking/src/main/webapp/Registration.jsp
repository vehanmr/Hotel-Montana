<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Account</title>
<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei"
rel="stylesheet">
<link href="logincss/style3.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="container">
<div class="regbox box">
<img class="avatar" src="images/avatar.png">
<h1>Register Account</h1>
<form action="RegisterServlet" method="post">
<p>Full Name</p>
<input type="text" placeholder="Full Name" name="name" required>
<p>User email</p>
<input type="text" placeholder="User Email" name="email" required>
<p>Contact Number</p>
<input type= "text" placeholder="Contact Number" name = "Contact Number" required>
<p>Gender</p>
<select name="gender" class="gender">
<option value="male">Male</option>
<option value="female">Female</option>
</select>
<p>Password</p>
<input type="password" placeholder="Password" name="password"
required>
<p>Confirm Password</p>
<input type="password" placeholder="confirm Password"
name="cpassword" required>

<%
String message = (String) request.getAttribute("RegError");
%>
<%
if (message == null) {
%>
<div class="besideemailbox" style="color: red"></div>
<%
} else if (message.equals("User Available")) {
%>
<div class="besideemailbox" style="color: red">Email Already
Exists</div>
<%
} else if (message.equals("Passwords")) {
%>
<div class="besideemailbox" style="color: green">Passwords
Doesn't Match</div>
<%
}
%>
<input type="submit"
value="Register">
<% String msg=(String)request.getAttribute("sent");
							  if(msg==null)
							  {
								  
							  }
							  else
							  {%>
							<div class="besideemailbox" style="color: red">Passwords Doesn't Match !! </div>
							  <%}
							  
							  %>


</form>

</div>
</div>
</body>
</html>