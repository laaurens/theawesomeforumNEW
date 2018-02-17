<div class="row">
	<header>Results for search "<c:out value="${searchText}"/>" in entries</header>
	<c:out value="${errorString}"/>
	<c:forEach items="${entries}" var="entry">
		<div class="col12 tablecontent">
			<div class="col2 tablecontentLeft">
				Entry by: <c:out value="${entry.getUserName()}" /><br>
				Date: <c:out value="${entry.getDateOfEntry()}" />
			</div>
			<div class="col10 tablecontentLeft">
				<c:out value="${entry.getContent()}" />
			</div>
		</div>
		<hr>
	</c:forEach>
</div>