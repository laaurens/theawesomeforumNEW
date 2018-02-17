<div class="row">
<div>
	<c:if test = "${not empty usernameError}">
		<font color=red size=4px><c:out value="${usernameError}" /></font>	
	</c:if>
	<c:if test = "${not empty passwordError}">
		<font color=red size=4px><c:out value="${passwordError}" /></font>	
	</c:if>
	<c:if test = "${not empty emailError}">
		<font color=red size=4px><c:out value="${emailError}" /></font>	
	</c:if>
<form method="POST" action="register">
  First name:<br>
  <input type="text" name="firstname" value="">
  <br>
  Last name:<br>
  <input type="text" name="lastname" value="">
  <br><br>
   Username:<br>
  <input type="text" name="username" value="">
  <br>
  Password:<br>
  <input type="password" name="password" value="">
  <br><br>
   Email:<br>
  <input type="email" name="Email" value="">
   <br>
   Birthday:<br>
   <input type="text" name="birthday" placeholder="YYYY-MM-DD" required pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))" title="Enter a date in this format YYYY-MM-DD"/>
 
   </input>
   <br>
   Bio:<br>
   <textarea name ="bio" rows="4" cols="50">
   Tell me about yourself...
   </textarea>
   <br>
   Homepage:<br>
   <input type="homepage" name="homepage" value="">
   <br>
   Location:<br>
  <input type="Location" name="location" value="">
   
  <br>
  <input type="submit" value="Register">
</form>
</div> 
</div>