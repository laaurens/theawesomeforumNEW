<div class="row">
	<header>Results for search "<c:out value="${searchText}"/>" in discussions</header>
	<c:forEach items="${discussions}" var="discussion">
		<div class="col12 tablecontent">
			<div class="col2 tablecontentLeft">
			
			</div>
			<div class="col10 tablecontentLeft">
				<a href="discussion?discussionId=${discussion.getId()}"><c:out value="${discussion.getTitle()}" /></a>
			</div>
		</div>
		<hr>
	</c:forEach>
</div>