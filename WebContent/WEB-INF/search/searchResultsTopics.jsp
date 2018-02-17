<div class="row">
	<header>Results for search in topics</header>
	<c:forEach items="${discussions}" var="discussion">
		<div class="col12 tablecontent">
			<div class="col2 tablecontentLeft">
			
			</div>
			<div class="col10 tablecontentLeft">
				<c:out value="${discussion.getTitle()}" />
			</div>
		</div>
		<hr>
	</c:forEach>
</div>