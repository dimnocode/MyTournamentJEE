<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<c:import url="includes/head.jsp"/>
<body>
	<c:import url="includes/header.jsp"/>
	
	<div class="container spacer">
		<h1>Games by <c:out value="${gameaccount.name }"/></h1><br>
		<table class="table table-striped">
			<tr>
				<th>Game</th>
				<th>Delete</th>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
		</table>
	
		<h1>Add new games</h1><br>
		<form method="POST" action="game">
			<div class="row">
				<c:forEach items="${listGame}" var="item">
			  		<div class="col-md-3">
			  			<label class="checkbox-inline">
	  						<input type="checkbox" id="game-${item.idGames }" name="${item.idGames }" value="${item.idGames }"> ${item.name }
						</label>
			  		</div>
				</c:forEach>
			</div>
			<br>
			<input type="submit" class="btn btn-info" value="Add"> 
		</form>
        <br>
        <a href="/MyTournamentV2">back to index page</a>
	</div>
	
	<c:import url="includes/footer.jsp"/>
</body>
</html>