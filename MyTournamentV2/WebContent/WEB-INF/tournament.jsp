<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html">
<html>
<c:import url="includes/head.jsp" />

<body>
	<c:import url="includes/header.jsp" />

	<div class="container">
		<h1><c:out value="${tournament.name}" /></h1>
			<c:if test="${loggedUser.idUsers eq tournament.user.idUsers}">
					<form method="post">
								<input type="hidden" name="tournamentId" value="<c:out value="${tournament.idTournaments}"/>"> 
								<input type="submit" name="creatorAction" value="Edit" class="btn btn-info"> 
								<input type="submit" name="creatorAction" value="Cancel" class="btn btn-danger">				
					</form>
				</c:if>
		<br><br>
		<c:import url="includes/msg.jsp" />
		<div class="row">
			<div class="col-md-6">
				<h2>Infos</h2>
					
					<dl class="dl-horizontal">
					<dt>Game</dt> <dd> <c:out value="${tournament.game.name}" /> </dd>
					<dt>Type</dt> <dd> <c:out value="${tournament.typeoftournament.name}" /> </dd>
					<dt>Format</dt> <dd> <c:out value="${tournament.formatoftournament.name}" /> </dd>
					<dt>Starts</dt> <dd> <c:out value="${tournament.startDate}" /> </dd>
					<dt>Ends</dt> <dd> <c:out value="${tournament.endDate}" /> </dd>
					</dl>
			</div>
			<div class="col-md-6">
				<c:if test="${!tournament.online}">
					<h2>Location</h2>
					<dl class="dl-horizontal">
					<dt>Street</dt> <dd> <c:out value="${tournament.location.street}" /> </dd>
					<dt>Town</dt>	<dd> <c:out value="${tournament.location.town}" /> </dd>
					<dt>ZipCode</dt> <dd> <c:out value="${tournament.location.zipCode}" /> </dd>
					<dt>Country</dt> <dd> <c:out value="${tournament.location.country}" /> </dd>
					</dl>
				</c:if>
			</div>
		</div>
		
		<br><br>
		<div class="row">
			<div class="col-md-6">

				<c:if test="${tournament.typeoftournament.idTypeOfTournaments eq 1}">
					<h2>
						Registered players <span class="label label-default"> <c:out
								value="${fn:length(tournament.registrations)}" /> / 
								<c:out value="${tournament.maxPlayers}" />
						</span>
					</h2>
					<form method="post">
					
						<input type="hidden" name="tournamentId" value="<c:out value="${tournament.idTournaments}"/>">
						
						<c:if test="${loggedUserHasGame == true}">
							<c:if test="${empty pRegistration}">
								<input type="submit" name="pRegister" value="Register">						
							</c:if>
							
							<c:if test="${!empty pRegistration}">
								<input type="submit" name="pUnregister" value="Unregister">
							</c:if>
							
						</c:if>
						
											
					</form>
					
					<c:if test="${not loggedUserHasGame}">You must have the game in one of your game accounts to register</c:if>

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
						Registered clans 
						<span class="label label-default"> 
						<c:out value="${fn:length(tournament.registrations)}" /> / 
						<c:out value="${tournament.maxPlayers}" />
						</span>
					</h2>
					<c:if test="${not empty pRegistration}">
						You're alreday registered for this tournament through <c:out value="${pRegistration.clan.name}"></c:out>
					</c:if>
					
					<c:if test="${fn:length(tournament.registrations) gt 0}">

						<table class="table table-striped">
							<tr>
								<th>Nickname</th>
								<th>Clan</th>
								<th>Registered on</th>
							</tr>

							<c:forEach items="${tournament.registrations}" var="item">
								<tr>
									<td><c:out value="${item.user.pseudo}" /></td>
									<td><c:out value="${item.clan.name}" /></td>
									<td><c:out value="${item.creationDate}" /></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
					
				</c:if>

			</div>
			
			<div class="col-md-6">
				
				<c:if test="${tournament.typeoftournament.idTypeOfTournaments eq 2}">
					<h2>Add a clan</h2>
					
					<c:if test="${not empty leaderClans}">		
						<div class="panel-group" id="accordionClans" role="tablist" aria-multiselectable="true" style="padding-left: 3%;">
							<c:forEach items="${leaderClans}" var="item">
									
	                			<!-- Clan name                   -->
	                			<div class="panel panel-default">
	                    			<div class="panel-heading" role="tab" id="heading<c:out value="${item.idClan}"/>">
	                        			<h4 class="panel-title">
	                            		<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordionClans" href="#collapse<c:out value="${item.idClan}"/>" aria-expanded="false" aria-controls="collapse<c:out value="${item.idClan}"/>">
	                                		<c:out value="${item.name}"/>
	                            		</a>
	                        			</h4>
	                    			</div>
	                    		
	                    			<div id="collapse<c:out value="${item.idClan}"/>" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading<c:out value="${item.idClan}"/>">
	                        			<div class="panel-body">
											<form action="" method="post">
												<input type="hidden" name="tournamentId" value="<c:out value="${tournament.idTournaments}"/>">
												<input type="hidden" name="clanId" value="<c:out value="${item.idClan}"/>">
												
												<c:forEach items="${item.usersclans}" var="uc">											
													<label class="checkbox-inline">
			  										<input type="checkbox" name="<c:out value="${uc.user.idUsers}"/>" value="<c:out value="${uc.user.idUsers}"/>"><c:out value="${uc.user.pseudo}"/><br>
													</label>											
												</c:forEach>
												<br><br>												
												<input type="submit" name="cRegister" class="btn btn-info" value="Register selection">
											</form>
	                        			</div>
	                    			</div>                    		
	                			</div>					
							</c:forEach>
						</div>					
					</c:if>	
					
					<c:if test="${empty leaderClans}">None of the clan you're leading has enough players that have the game</c:if>
				</c:if>			
			</div>
		</div>
	</div>


	<c:import url="includes/footer.jsp" />
	  <script>
            $(document).ready(function () {

                $('.panel-group > .panel').on('show.bs.collapse', function (e) {
                    $(this).removeClass("panel-default");
                    $(this).addClass("panel-primary");
                });

                $('.panel-group > .panel').on('hide.bs.collapse', function (e) {
                    $(this).removeClass("panel-primary");
                    $(this).addClass("panel-default");
                });
            });
        </script>
</body>
</html>