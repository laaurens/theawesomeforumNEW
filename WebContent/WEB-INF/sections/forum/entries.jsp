<div class="row">
	<p>
	<h2>
		<c:out value="${discussion.getTitle()}" />
	</h2>
	</p>

	<c:forEach items="${discussion.getEntries()}" var="entry">
		<div class="col12 tablecontent">
			<div class="col2 tablecontentLeft">
				<c:if test="${not empty username}">
					<a
						href='userpage?linkUserName=<c:out value="${userToIdMap.get(entry.getUserId()).getUserName()}" />'>
				</c:if>
				<c:out value="${userToIdMap.get(entry.getUserId()).getUserName()}" />

				</a> DateOfEntry:
				<c:out value="${entry.getDateOfEntry()}" />

			</div>
			<div class="col10 tablecontentLeft">
				<c:out value="${entry.getContent()}" />
			</div>
		</div>
		<hr>
	</c:forEach>
	<c:if test="${empty username}">
		<p>... for posting comments and seeing more than 10 Posts please
			login!</p>
	</c:if>
	<c:if test="${not empty username}">
		<h3>New Entry...</h3>
		<textarea name="entry" form="entryform">Enter text here...</textarea>
		<form method="POST"
			action="newentry?discussionId=<c:out value="${discussion.getId()}" />"
			id="entryform">
			<input type="submit">
		</form>
	</c:if>
</div>