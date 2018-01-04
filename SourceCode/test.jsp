<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Login Form</title>
  
  
  
      <link rel="stylesheet" href="css1/style.css">

  
</head>


  <body background="uploads/LOGON.jpg">
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
 <br>
 <center>
<div class="container">
	<section id="content">
		<form
		action="<%=request.getContextPath()%>/Controller" method="post">
			<input type="hidden" name="action" value="doLogin" />
			<h1>Login Form</h1>
			<font color="red"><c:out value="${msg }"></c:out></font>
		
			<div>
				<input type="text" placeholder="Username" name="username" />
			</div>
			<div>
				<input type="password" placeholder="Password" name="password" />
			</div>
			<div>
				<input type="submit" value="Log in" />
				
				
			</div>
		</form><!-- form -->
		
	</section><!-- content -->
</div></center><!-- container -->
</body>
  
   


</html>
