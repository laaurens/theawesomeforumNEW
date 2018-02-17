<script>
	function showDateFormatString() {
		var dateFormatString = "";
		var selection = document.getElementById("searchTypeSelect").value;
		
		if (selection == "searchDates") {
			dateFormatString = "Date searches must be in DD/MM/YYYY format"
		} else {
			dateFormatString = ""
		}
		
		document.getElementById("dateFormatText").innerHTML = dateFormatString;
	}
</script>

<div class="row">
	<form action="distributionServlet" method="POST">
		<input type="text" name="searchText"/>
		<select name="searchType" id="searchTypeSelect" onchange="showDateFormatString()">
			<option value="searchDiscussions" selected>Discussions</option>
			<option value="searchEntries">Entries</option>
			<option value="searchUsers">Users</option>
			<option value="searchDates">Dates</option>
			<option value="searchCategories">Categories</option>
		</select>
		<button>Search</button>
		<div id="dateFormatText"></div>
		
		<script>
			var searchType = "${searchType}";
			var dropdown = document.getElementById("searchTypeSelect");

			if (searchType != "") {
				dropdown.value = searchType;
			}
 		</script> 
	</form>
</div>