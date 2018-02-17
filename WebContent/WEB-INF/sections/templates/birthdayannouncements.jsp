<c:if test="${not empty username}">
	<div class="row">
		<ul class="shadowless col12">
			<li><a class="active" href=#>Birthdays</a></li>
			<li class="col12"><marquee>
					<ul class="shadowless">
						<c:forEach items="${usersWithBirthday}" var="userWithBirthday">
							<li><div class="col12">
									<a href='userpage?linkUserName=<c:out value="${userWithBirthday.getUserName()}" />'>
										<c:out value="${userWithBirthday.getUserName()}" />
									</a>
								</div></li>
						</c:forEach>
					</ul>
				</marquee></li>
		</ul>
	</div>
</c:if>