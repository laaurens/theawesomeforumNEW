<div class="row">
	<header>
		Results for search "
		<c:out value="${searchText}" />
		" in users
	</header>
	<c:forEach items="${users}" var="user">
		<div class="col12 tablecontent">
			<div class="col2 tablecontentLeft">
				<div>
					<a href="userpage?linkUserName=<c:out value="${user.getUserName()}" />">
						<c:out value="${user.getUserName()}" />
					</a>
				</div>
				<div>
					<c:out value="${user.getId()}" />
				</div>
			</div>
			<div class="col10 tablecontentLeft">
				<div>...</div>
				<div>...</div>
			</div>
		</div>
		<hr>
	</c:forEach>
</div>