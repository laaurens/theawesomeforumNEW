<div class="row">
<c:forEach items="${category.getSubcategories()}" var="subcategory">
	<div class="col12 tablecontent">
		<div class="col4 tablecontentLeft">
		<a href="category?subcategoryId=<c:out value='${subcategory.getId()}' />">	<c:out value="${subcategory.getTitle()}" /> </a>
		</div>
		<div class="col4 headingbarRight">Last Comment</div>
		<div class="col2 headingbarRight">Number of Posts</div>
		<div class="col2 headingbarRight hide4">Username</div>
	</div>
</c:forEach>
</div>