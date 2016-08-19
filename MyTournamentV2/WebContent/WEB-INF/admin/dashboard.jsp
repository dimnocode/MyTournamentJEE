<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<c:import url="../includes/head.jsp"/>

<body data-spy="scroll" data-target=".navbar" data-offset="50">
	<c:import url="../includes/header.jsp"/>
	
	<div class="container">
		<h1>Dashboard</h1>
		<c:import url="../includes/msg.jsp"/>
		
		<div>
		<br>
		
		  <!-- Nav tabs -->
		  <ul class="nav nav-tabs" role="tablist">
		    <li role="presentation" class="active"><a href="#platforms" aria-controls="home" role="tab" data-toggle="tab">Platforms</a></li>
		    <li role="presentation"><a href="#games" aria-controls="profile" role="tab" data-toggle="tab">Games</a></li>
		    <li role="presentation"><a href="#typeoftournament" aria-controls="messages" role="tab" data-toggle="tab">Type of Tournament</a></li>
		    <li role="presentation"><a href="#formatoftournament" aria-controls="settings" role="tab" data-toggle="tab">Format of Tournament</a></li>
		  </ul>
		
		  <!-- Tab panes -->
		  <div class="tab-content">
		    <div role="tabpanel" class="tab-pane active" id="platforms">
				<h3>Platforms</h3><br>
				<form action="dashboard" method="POST" class="form-inline" data-toggle="validator" id="formAdminPlatforms">
					<fieldset>
						<div class="form-group">
			                <label class="control-label" for="namePlatforms" >Name: </label>
			                <input class="form-control" type="text" id="namePlatforms" name="namePlatforms" placeholder="Name">
			            </div>
						<div class="form-group">
			                 <button type="submit" class="btn btn-info" name="btnPlatforms" id="btnPlatforms">Create</button>
			            </div>
			            <div class="form-group">
			                 <button type="button" class="btn btn-primary" name="btnPlatformsRemoved" id="btnPlatformsRemoved">Platforms not active</button>
			            </div>
			            </fieldset>
			        </form>
			        <br>
			        
			        <table class="table table-striped">
						<tr>
							<th>Name</th>
							<th class="action">Delete</th>
						</tr>
						<tr>
						<c:forEach items="${listPlatforms }" var="item">
							<c:if test="${item.active }">
								<tr class="platformsActive">
							  			<td><c:out value="${item.name }"/></td>
							  			<td><form method="POST" action="dashboard"><input type="hidden" name="idPlatforms" value="<c:out value='${item.idPlatforms }'/>"><button type="submit" name="btnRemovePlatforms" class="btn btn-danger btn-sm "><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></form></td>
							  	</tr>
						  	</c:if>
						  	<c:if test="${item.active eq false}">
								<tr class="platformsNotActive">
							  			<td><c:out value="${item.name }"/></td>
							  			<td><form method="POST" action="dashboard"><input type="hidden" name="idPlatforms" value="<c:out value='${item.idPlatforms }'/>"><button type="submit" name="btnActivePlatforms" class="btn btn-success btn-sm "><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></button></form></td>
							  	</tr>
						  	</c:if>
					    </c:forEach>
						</tr>
					</table>
			</div>
			
			
		    <div role="tabpanel" class="tab-pane" id="games">
		    	<h3>Games</h3><br>
				<form action="dashboard" method="POST" class="form-inline" data-toggle="validator" id="formAdminGames">
					<fieldset>
						<div class="form-group">
			                <label class="control-label" for="nameGames" >Name: </label>
			                <input class="form-control" type="text" id="nameGames" name="nameGames" placeholder="Name">
			            </div>
			            <div class="form-group">
		  					<label class="control-label" for="namePlateforms">Platform:</label>
		  						<select class="form-control" name="namePlateforms" id="namePlateforms">
		  							<c:forEach items="${listPlatforms }" var="item">
		  								<option value="${item.idPlatforms }">${item.name }</option>
		  							</c:forEach>
			  					</select>
						</div>
						<div class="form-group">
			                 <button type="submit" class="btn btn-info" name="btnGames" id="btnGames">Create</button>
			            </div>
			            </fieldset>
			        </form>
			        <br>
		    </div>
		    <div role="tabpanel" class="tab-pane" id="typeoftournament">
		    	<h3>Type of Tournament</h3><br>
				<form action="dashboard" method="POST" class="form-inline" data-toggle="validator" id="formAdminTypeoftournament">
					<fieldset>
						<div class="form-group">
			                <label class="control-label" for="nameTypeoftournament" >Name: </label>
			                <input class="form-control" type="text" id="nameTypeoftournament" name="nameTypeoftournament" placeholder="Name">
			            </div>
						<div class="form-group">
			                 <button type="submit" class="btn btn-info" name="btnTypeoftournament" id="btnTypeoftournament">Create</button>
			            </div>
			            <div class="form-group">
			                 <button type="button" class="btn btn-primary" name="btnTypeoftournamentRemoved" id="btnTypeoftournamentRemoved">Type of tournament not active</button>
			            </div>
			            </fieldset>
			        </form>
			        <br>
			        <table class="table table-striped">
						<tr>
							<th>Name</th>
							<th class="action">Delete</th>
						</tr>
						<tr>
						<c:forEach items="${listTypeOfTournament }" var="item">
							<c:if test="${item.active }">
								<tr class="typeoftourmanetActive">
							  			<td><c:out value="${item.name }"/></td>
							  			<td><form method="POST" action="dashboard"><input type="hidden" name="idTypeoftournament" value="<c:out value='${item.idTypeOfTournaments }'/>"><button type="submit" name="btnRemoveTypeoftournament" class="btn btn-danger btn-sm "><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></form></td>
							  	</tr>
						  	</c:if>
						  	<c:if test="${item.active eq false}">
								<tr class="typeoftourmanetNotActive">
							  			<td><c:out value="${item.name }"/></td>
							  			<td><form method="POST" action="dashboard"><input type="hidden" name="idTypeoftournament" value="<c:out value='${item.idTypeOfTournaments }'/>"><button type="submit" name="btnActiveTypeoftournament" class="btn btn-success btn-sm "><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></button></form></td>
							  	</tr>
						  	</c:if>
					    </c:forEach>
						</tr>
					</table>
		    </div>
		    <div role="tabpanel" class="tab-pane" id="formatoftournament">
		    	<h3>Format of Tournament</h3><br>
				<form action="dashboard" method="POST" class="form-inline" data-toggle="validator" id="formAdminFormatoftournament">
					<fieldset>
						<div class="form-group">
			                <label class="control-label" for="nameFormatoftournament" >Name: </label>
			                <input class="form-control" type="text" id="nameFormatoftournament" name="nameFormatoftournament" placeholder="Name">
			            </div>
						<div class="form-group">
			                 <button type="submit" class="btn btn-info" name="btnFormatoftournament" id="btnFormatoftournament">Create</button>
			            </div>
			            <div class="form-group">
			                 <button type="button" class="btn btn-primary" name="btnFormatoftournamentRemoved" id="btnFormatoftournamentRemoved">Format of tournament not active</button>
			            </div>
			            </fieldset>
			        </form>
			        <br>
			        <table class="table table-striped">
						<tr>
							<th>Name</th>
							<th class="action">Delete</th>
						</tr>
						<tr>
						<c:forEach items="${listFormatOfTournament }" var="item">
							<c:if test="${item.active }">
								<tr class="formatoftourmanetActive">
							  			<td><c:out value="${item.name }"/></td>
							  			<td><form method="POST" action="dashboard"><input type="hidden" name="idFormatoftournament" value="<c:out value='${item.idFormatTournaments }'/>"><button type="submit" name="btnRemoveFormatoftournament" class="btn btn-danger btn-sm "><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></form></td>
							  	</tr>
						  	</c:if>
						  	<c:if test="${item.active eq false}">
								<tr class="formatoftourmanetNotActive">
							  			<td><c:out value="${item.name }"/></td>
							  			<td><form method="POST" action="dashboard"><input type="hidden" name="idFormatoftournament" value="<c:out value='${item.idFormatTournaments }'/>"><button type="submit" name="btnActiveFormatoftournament" class="btn btn-success btn-sm "><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></button></form></td>
							  	</tr>
						  	</c:if>
					    </c:forEach>
						</tr>
					</table>
		    </div>
		  </div>
		
		</div>
		
	</div>
	
	<c:import url="../includes/footer.jsp"/>
</body>
</html>