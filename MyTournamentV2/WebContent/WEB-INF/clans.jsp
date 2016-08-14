<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html">
<html>
<c:import url="includes/head.jsp"/>

<body data-spy="scroll" data-target=".navbar" data-offset="50">
	<c:import url="includes/header.jsp"/>
	
	<div class="container">
		<h1>List of clans</h1>
		<c:import url="includes/msg.jsp"/>
		<br>
		<hr>
		<div class="row">
			<form action="" method="POST" class="form-inline" data-toggle="validator" id="formClan">
			<fieldset>
				<div class="form-group">
	                <label class="control-label" for="nameClan" >Name: </label>
	                <input class="form-control" type="text" id="nameClan" name="nameClan" placeholder="Name">
	            </div>
				<div class="form-group">
	                 <button type="submit" class="btn btn-info" name="btnClan" id="btnClan">Create</button>
	            </div>
	            </fieldset>
	        </form>
		</div><br>
		<c:if test="${listClanLeader != null }">
		<div class="form-inline">
				<div class="form-group">
					<h3 class="table-hover" id="titleYourClan">Your clans</h3>
				</div>
				<div class="form-group">
					<button id="btnYourClan" type="button" class="btn btn-primary"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
				</div>
			</div><br>
		<div id="yourClan">
			<c:forEach items="${listClanLeader}" var="items" >
			<c:if test="${items.active }">
			<div class="jumbotron">
			<div class="row">
				<div class="col-md-9 ">
					
					<form action="clans" method="POST" class="form-inline">
						<div class="form-group ">
							<h3 class="table-hover nameClan">Clan <c:out value="${items.name }"/></h3>
						</div>
						<div class="form-group">
							<input type="hidden" name="idClan" value="${items.idClan }"><button type="submit" name="btnRemoveClan" class="btn btn-danger" ><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
						</div>
					</form>
				</div>
				<div class="col-md-3">
					<button id="playersActive" class="btn btn-primary playerActive">Players active</button>
				</div>
			</div>
				
				<div class="userClan">
				<br>
					<form action="clans" method="POST" class="form-inline" data-toggle="validator" class="formUserClan">
					<fieldset>
					<input type="hidden" name="idClan" value="<c:out value='${items.idClan }'/>">
						<div class="form-group">
			                <label class="control-label" for="pseudoUserClan" >Pseudo: </label>
			                <input class="form-control pseudoUserClan" type="text"  name="pseudoUserClan" placeholder="Pseudo">
			            </div>
			            <div class="form-group">
			                <label class="control-label" for="emailUserClan" >Email: </label>
			                <input class="form-control emailUserClan" type="text" name="emailUserClan" placeholder="Email">
			            </div>
						<div class="form-group">
			                 <button type="submit" class="btn btn-info" name="btnUserClan" id="btnUserClan">Invite</button>
			            </div>
			            </fieldset>
			        </form>
					<br>
					<table class="table table-striped">
						<tr>
							<th>Pseudo</th>
							<th>Email</th>
							<th>Name</th>
							<th>Firstname</th>
							<th id="action">Delete</th>
						</tr>
						<c:forEach items="${items.usersclans }" var="item">
						<c:if test="${empty item.removedDateTime}">
								<tr class="userActive">
										<c:if test="${loggedUser.idUsers == item.user.idUsers }">
							  				<td><span class="glyphicon glyphicon-star" aria-hidden="true"></span>&nbsp;&nbsp;<span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;&nbsp;<c:out value="${item.user.pseudo }"/></td>
							  			</c:if>
							  			<c:if test="${loggedUser.idUsers != item.user.idUsers }">
							  				<td><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;&nbsp;<c:out value="${item.user.pseudo }"/></td>
							  			</c:if>
							  			<td><c:out value="${item.user.email }"/></td>
							  			<td><c:out value="${item.user.name }"/></td>
							  			<td><c:out value="${item.user.firstname }"/></td>
							  			<td><form method="POST" action=clans><input type="hidden" name="idClan" value="<c:out value='${items.idClan }'/>"><input type="hidden" name="idUser" value="<c:out value='${item.user.idUsers }'/>"><button type="submit" name="btnRemoveUserClan" class="btn btn-danger btn-sm "><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></form></td>
	
							  	</tr>
						</c:if>
						<c:if test="${!empty item.removedDateTime}">
								<tr class="userNotActive">
										<c:if test="${loggedUser.idUsers == item.user.idUsers }">
							  				<td><span class="glyphicon glyphicon-star" aria-hidden="true"></span>&nbsp;&nbsp;<span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;&nbsp;<c:out value="${item.user.pseudo }"/></td>
							  			</c:if>
							  			<c:if test="${loggedUser.idUsers != item.user.idUsers }">
							  				<td><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;&nbsp;<c:out value="${item.user.pseudo }"/></td>
							  			</c:if>
							  			<td><c:out value="${item.user.email }"/></td>
							  			<td><c:out value="${item.user.name }"/></td>
							  			<td><c:out value="${item.user.firstname }"/></td>
							  			<td><form method="POST" action=clans><input type="hidden" name="idClan" value="<c:out value='${items.idClan }'/>"><input type="hidden" name="idUser" value="<c:out value='${item.user.idUsers }'/>"><button type="submit" name="btnReaddUserClan" class="btn btn-success btn-sm "><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></button></form></td>
	
							  	</tr>
						</c:if>
					    </c:forEach>
					</table>
				</div>
				</div>
				</c:if>
				</c:forEach>
				</div>
			</c:if>
			
			<c:if test="${listClan != null }">
			<div class="form-inline">
				<div class="form-group">
					<h3 class="table-hover" id="titleClanRegister">Clans register</h3>
				</div>
				<div class="form-group">
					<button id="btnClanRegister" type="button" class="btn btn-primary"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
				</div>
			</div><br>
			
			<div id="clanRegister">
			<c:forEach items="${listClan}" var="items" >
			<div class="jumbotron">
				<div class="row">
				<div class="col-md-9">
					<h3 class="table-hover clanRegister">Clan <c:out value="${items.name }"/></h3>
				</div>
				<div class="col-md-3">
					
				</div>
			</div>
				<div class="userClan">
					<br>
					<table class="table table-striped">
						<tr>
							<th>Pseudo</th>
							<th>Email</th>
							<th>Name</th>
							<th>Firstname</th>
						</tr>
						<tr>
						<c:forEach items="${items.usersclans }" var="item">
								<tr id="userClan-${item.user.idUsers }">
									<c:if test="${item.clanLeader }">
										<td><span class="glyphicon glyphicon-star" aria-hidden="true"></span>&nbsp;&nbsp;<span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;&nbsp;<c:out value="${item.user.pseudo }"/></td>
										
									</c:if>
									<c:if test="${item.clanLeader == false}" >
										<td><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;&nbsp;<c:out value="${item.user.pseudo }"/></td>
										
									</c:if>
								<td><c:out value="${item.user.email }"/></td>
							  			<td><c:out value="${item.user.name }"/></td>
							  			<td><c:out value="${item.user.firstname }"/></td>
							  	</tr>
					    </c:forEach>
						</tr>
					</table>
				</div>
				</div>
				</c:forEach>
				</div></c:if>
	</div>
	
	<c:import url="includes/footer.jsp"/>
</body>
</html>