<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html">
<html>
<c:import url="includes/head.jsp"/>

<body>
	<c:import url="includes/header.jsp"/>
	
	<div class="container">
		<h1>List of Tournament</h1>
		
		<h3><a href="tournamentcreation">New tournament</a> </h3>
		
		<table id="tl" class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Game</th>
					<th>Type</th>
					<th>Format</th>
					<th>Start</th>
					<th>End</th>
					<th>Players</th>
				</tr>
			</thead>
			
			<tfoot>
				<tr>
					<th>Name</th>
					<th>Game</th>
					<th>Type</th>
					<th>Format</th>
					<th>Start</th>
					<th>End</th>
					<th>Players</th>
				</tr>
			</tfoot>
			
			<tbody>
			<c:forEach items="${tournaments}" var="item">				
					<tr>
				  			<td><c:out value="${item.name}"/><form method="post" action="${pageContext.request.contextPath}/tournament"> <button type="submit" class="btn btn-primary">See <span class="glyphicon glyphicon-align-left" aria-hidden="true"></span></button> <input type="hidden" name="tournamentId" value="<c:out value="${item.idTournaments}"/>"> </form></td>
				  			<td><c:out value="${item.game.name}"/></td>
				  			<td><c:out value="${item.typeoftournament.name}"/></td>
				  			<td><c:out value="${item.formatoftournament.name}"/></td>
				  			<td><c:out value="${item.startDate}"/></td>
				  			<td><c:out value="${item.endDate}"/></td>
				  			<td><c:out value="${fn:length(item.registrations)}"/>/<c:out value="${item.maxPlayers}"/></td>
				  	</tr>
		    </c:forEach>
			</tbody>
		</table>
		
	</div>
	
	<c:import url="includes/footer.jsp"/>
	<script>
		$(document).ready(function() {
	    $('#tl').DataTable();
	} );
	</script>
</body>
</html>