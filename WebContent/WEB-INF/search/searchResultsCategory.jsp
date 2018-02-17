<div class="row">
	<header>Results for search "<c:out value="${searchText}"/>" in categories</header>
	<c:forEach items="${categories}" var="category">
		<div class="col12 tablecontent">
			<div class="col2 tablecontentLeft">
			
			</div>
			<div class="col10 tablecontentLeft">
				<c:out value="${category.getTitle()}" />
			</div>
		</div>
		<hr>
	</c:forEach>
</div>