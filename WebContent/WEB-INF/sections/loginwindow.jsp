<div>
	<form method="POST" action="login">
		username:<br> <input type="text" name="username"> <br>
		Password:<br> <input type="password" name="password"> <br>
		<br> <input type="submit" value="Login">
	</form>
	<br>
	<p>
		If not registered yet please register <a href="register"> here </a>
	</p>
	
	<c:if test = "${not empty error}">
		<font color=red size=4px><c:out value="${error}" /></font>	
	</c:if>
	
</div>