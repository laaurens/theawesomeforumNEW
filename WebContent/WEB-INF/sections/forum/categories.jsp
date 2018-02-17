<div class="row">
<!--rumprobieren Linda forum design---------------------------------------------------------------------->
<c:forEach items="${categories}" var="category">
	<div class="col12 headingbar">
		<div class="col12 headingbarLeft">
			<h2><c:out value="${category.getTitle()}" /><h2>
		</div>
		<%@ include file="subcategories.jsp"%>


	</div>
</c:forEach>
</div>