<div class="row">
	<h2>
		<c:out value="${subcategory.getTitle()}" />
	</h2>
	<c:forEach items="${subcategory.getDiscussions()}" var="discussion">
		<div class="col12 tablecontent">
			<div class="col4 tablecontentLeft">
				<a
					href="discussion?discussionId=<c:out value='${discussion.getId()}' />">
					<c:out value="${discussion.getTitle()}" />
				</a>
			</div>
			<div class="col8 tablecontentLeft last-col hide4">lastentry</div>
		</div>
	</c:forEach>
	<c:if test = "${not empty username}">
		<h3>New Discussion...</h3>
		<input type="text" name="title" form="discussionform"/><br />
		<textarea name="discussion" form="discussionform">Enter text here...</textarea>
		<form method="POST" action="newdiscussion?subcategoryId=<c:out value="${subcategory.getId()}" />" id="discussionform">
			<input type="submit">
		</form>
	</c:if>
</div>