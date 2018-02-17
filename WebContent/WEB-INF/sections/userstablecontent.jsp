<c:forEach items="${users}" var="user">
	<div class="col12 tablecontent">
		<div class="col2 tablecontentLeft">
			<c:out value="${user.getId()}" />
		</div>

		<div class="col3 tablecontentLeft hide4">
			<a
				href='userpage?linkUserName=<c:out value="${user.getUserName()}" />'>
				<c:out value="${user.getUserName()}" />
			</a>
		</div>
		<div class="col3 tablecontentLeft  hide4">
			<c:out value="${user.isAdmin()}" />
		</div>
		<div class="col3 tablecontentLeft hide4">
			<c:out value="13" />
		</div>
		<div class="col2 tablecontentLeft hide4">
			<c:out value="321" />
		</div>

	</div>
</c:forEach>

<!-- ausprobieren Linda 

<c:forEach items="${listUsersNumberOfEntries}" var="user">
<div class="col12 tablecontent">
		<div class="col2 tablecontentLeft hide4">
			<c:out value="${listUsersNumberOfEntries}" />
		</div>
</div>		
</c:forEach>

-->