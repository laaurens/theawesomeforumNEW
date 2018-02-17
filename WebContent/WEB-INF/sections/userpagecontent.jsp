
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserPageContent</title>
</head>
<body>
<div class="row">
	<div class="col12 headingbar">
		<div class="col2 tablecontentLeft">Username:</div>
		<div class="col8 tablecontentLeft"><c:out value="${user.getUserName()}" /></div>
	</div>
	<div class="col12 headingbar">
		<div class="col2 tablecontentLeft">Firstname:</div>
		<div class="col8 tablecontentLeft "><c:out value="${user.getFirstName()}" /></div>
	</div>
	<div class="col12 headingbar">
		<div class="col2 tablecontentLeft">Lastname:</div>
		<div class="col8 tablecontentLeft"><c:out value="${user.getLastName()}" /></div>
	</div>
	<div class="col12 headingbar">
		<div class="col2 tablecontentLeft">Email:</div>
		<div class="col8 tablecontentLeft"><c:out value="${user.getEmail()}" /></div>
	</div>
	<div class="col12 headingbar">
		<div class="col2 tablecontentLeft">Birthday:</div>
		<div class="col8 tablecontentLeft"><c:out value="${user.getBirthday()}" /></div>
	</div>
	<div class="col12 headingbar ">
		<div class="col2 tablecontentLeft ">Bio:</div>
		<div class="col8 tablecontentLeft"><c:out value="${user.getBio()}" /></div>
	</div>
	<div class="col12 headingbar">
		<div class="col2 tablecontentLeft">Homage:</div>
		<div class="col8 tablecontentLeft"><c:out value="${user.getHomepage()}" /></div>
	</div>
		<div class="col12 headingbar">
		<div class="col2 tablecontentLeft">Location:</div>
		<div class="col8 tablecontentLeft"><c:out value="${user.getLocation()}" /></div>
	</div>
<br>
	<div class="col12 headingbar">
		<div class="col12 "> Last (5) Entries:</div>
	</div>	
	
	<c:forEach items="${restrictedListOfEntries}" var="entry">
		<div class="col12 tablecontent">
			<div class="col2 tablecontentLeft">
				<c:out value="${entry.getDateOfEntry()}" />
			</div>
			<div class="col10 tablecontentLeft">
				<c:out value="${entry.getContent()}" />
			</div>
		</div>

	</c:forEach>
</div>

</body>
</html>
