<!--Menue and Searchbar!---------------------------------------------------------------------->
<div class="row">
	<div class="col12 topnav">
		<ul>

			<c:if test="${empty username}">
				<li><a href="login">Login</a></li>
			</c:if>
			<c:if test="${not empty username}">

				<li><a href="logout">Logout</a></li>
			</c:if>

			<c:if test="${not empty username}">
				<c:if test="${not empty isAdmin}">
					<li><a href="admin">AdminPage</a></li>
				</c:if>
			</c:if>
			<li><a class="active" href="forum">Home</a></li>

			<c:if test="${not empty username}">



				<li><a
					href='userpage?linkUserName=<c:out value="${username}" />'> <c:out
							value="${username}'S " />Profile
				</a></li>


			</c:if>

			<li>
				<div class="search-container">
					<form action="searchForm" method="POST">
						<button type="submit">
							<i class="fa fa-search"></i>
						</button>
					</form>
				</div>
			</li>
		</ul>
	</div>
</div>

















