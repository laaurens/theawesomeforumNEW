

<c:forEach items="${profanities}" var="profanity">
	<div class="col12 tablecontent headingbar">
		<div class="col6 headingbar tablecontentLeft hide5">
			<c:out value="${profanity.getContent() }" />
		</div>
		<div class="col6  headingbar tablecontentLeft hide5">
			<form action="deleteProfanity" method="GET">
				<button type="submit" name="profanity" value="<c:out value="${profanity.getContent() }" />">Delete</button>
			</form>
		</div>

	</div>
</c:forEach>


<div class="col12  tablecontent  headingbar">
	<h3>New Profanitiy</h3>
	<div class="col6 tablecontentLeft hide4">
		<input type="text" name="newProfanity" form="profanityForm" placeholder="new profanity">
	</div>
	<div class="col6  tablecontentLeft hide4">
	<form method="GET" action="addProfanity" id="profanityForm">
		<button type="submit" value="submit">Add</button>
	</form>
	</div>
</div>