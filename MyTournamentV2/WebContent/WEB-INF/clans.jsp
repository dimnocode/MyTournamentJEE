<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html">
<html>
<c:import url="includes/head.jsp"/>

<body data-spy="scroll" data-target=".navbar" data-offset="50">
	<c:import url="includes/header.jsp"/>
	
	<div class="container">
		<h1>Your clans</h1>
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
			<c:forEach items="${listClanLeader}" var="items" >
			<div class="jumbotron">
			<div class="row">
				<div class="col-md-9">
					<h3 class="table-hover nameClan">Clan <c:out value="${items.name }"/></h3>
				</div>
				<div class="col-md-3">
					<h4 class="table-hover nameClan">Members <c:out value="${fn:length(items.users)}"></c:out></h4>
				</div>
			</div>
				
				<div class="userClan">
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
							<th>Delete</th>
						</tr>
						<tr>
						<c:forEach items="${items.users }" var="item">
								<tr id="userClan-${item.idUsers }">
							  			<td><c:out value="${item.pseudo }"/></td>
							  			<td><c:out value="${item.email }"/></td>
							  			<td><c:out value="${item.name }"/></td>
							  			<td><c:out value="${item.firstname }"/></td>
							  			<td><form method="POST" action=clans><input type="hidden" name="idClan" value="<c:out value='${items.idClan }'/>"><input type="hidden" name="idUser" value="<c:out value='${item.idUsers }'/>"><button type="submit" name="btnRemoveUserClan" class="btn btn-danger btn-sm "><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></form></td>
	
							  	</tr>
					    </c:forEach>
						</tr>
					</table>
				</div>
				</div>
				</c:forEach>
			</c:if>
			<c:if test="${listClan != null }">
			<c:forEach items="${listClan}" var="items" >
			<div class="jumbotron">
				<div class="row">
				<div class="col-md-9">
					<h3 class="table-hover nameClan">Clan <c:out value="${items.name }"/></h3>
				</div>
				<div class="col-md-3">
					<h4 class="table-hover nameClan">Members <c:out value="${fn:length(items.users)}"></c:out></h4>
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
						<c:forEach items="${items.users }" var="item">
								<tr id="userClan-${item.idUsers }">
							  			<td><c:out value="${item.pseudo }"/></td>
							  			<td><c:out value="${item.email }"/></td>
							  			<td><c:out value="${item.name }"/></td>
							  			<td><c:out value="${item.firstname }"/></td>
							  	</tr>
					    </c:forEach>
						</tr>
					</table>
				</div>
				</div>
				</c:forEach>
			</c:if>
	</div>
	
	<c:import url="includes/footer.jsp"/>
</body>
</html>