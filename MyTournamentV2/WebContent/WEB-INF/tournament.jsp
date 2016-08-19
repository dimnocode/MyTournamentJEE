<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html">
<html>
<c:import url="includes/head.jsp" />

<body>
	<c:import url="includes/header.jsp" />

	<div class="container">
		<h1>
			<c:out value="${tournament.name}" />
		</h1>
		<c:if test="${loggedUser.idUsers eq tournament.user.idUsers}">
			<form  method="post">
				<div class="alert alert-danger" role="alert">
					<input type="hidden" name="tournamentId" value="<c:out value="${tournament.idTournaments}"/>">
					You are the creator of the tournament You can &nbsp;
					<input type="hidden" name="tournamentId"> 
					<input type="submit" name="creatorAction" value="Edit">
					&nbsp;and&nbsp; 
					<input type="submit" name="creatorAction" value="Cancel">
				</div>

			</form>
		</c:if>
		<div class="row">
			<div class="col-md-6">
				<h2>Infos</h2>
				<p>
					Game :
					<c:out value="${tournament.game.name}" />
					<br> Type :
					<c:out value="${tournament.typeoftournament.name}" />
					<br> Format :
					<c:out value="${tournament.formatoftournament.name}" />
					<br> Starts :
					<c:out value="${tournament.startDate}" />
					<br> Ends :
					<c:out value="${tournament.endDate}" />
				</p>
			</div>
			<div class="col-md-6">
				<c:if test="${!tournament.online}">
					<h2>Location</h2>
					Street : <c:out value="${tournament.location.street}" />
					<br>Town : 	<c:out value="${tournament.location.town}" />
					<br>ZipCode : <c:out value="${tournament.location.zipCode}" />
					<br>Country : <c:out value="${tournament.location.country}" />
				</c:if>
			</div>
		</div>


		<c:if test="${tournament.typeoftournament.idTypeOfTournaments eq 1}">
			<h2>
				Registered players <span class="label label-default"> <c:out
						value="${fn:length(tournament.registrations)}" /> / <c:out
						value="${tournament.maxPlayers}" />
				</span>
			</h2>
			<form method="post">
				<input type="hidden" name="tournamentId"
					value="<c:out value="${tournament.idTournaments}"/>"> 
					<c:if test="${isUserRegistered eq 0}"> <input type="submit" name="pRegister" value="Register"> </c:if>
					<c:if test="${isUserRegistered eq 1}"> <input type="submit" name="pUnregister" value="Unregister"> </c:if>
			</form>

			<c:if test="${fn:length(tournament.registrations) gt 0}">

				<table class="table table-striped">
				<tr>
					<th>Nickname</th>
					<th>Registered on</th>
				</tr>

					<c:forEach items="${tournament.registrations}" var="item">
						<tr>
							<td><c:out value="${item.user.pseudo}" /></td>
							<td><c:out value="${item.creationDate}" /></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</c:if>

		<c:if test="${tournament.typeoftournament.idTypeOfTournaments eq 2}">
			<h2>
				Registered clans <span class="label label-default"> <c:out
						value="${fn:length(tournament.registrations)}" /> / <c:out
						value="${tournament.maxPlayers}" />
				</span>
			</h2>
			<form method="post">
				<input type="hidden" name="tournamentId"
					value="<c:out value="${tournament.idTournaments}"/>"> <input
					type="submit" name="cRegister" value="Register">
			</form>
		</c:if>



	</div>

	<c:import url="includes/footer.jsp" />
</body>
</html>