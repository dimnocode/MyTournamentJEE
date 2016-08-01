<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<c:import url="includes/head.jsp"/>
<body>
 	<c:import url="includes/header.jsp"/>
 	<div class="container">
 		<h2>Welcome <c:out value="${sessionScope.loggedUser.pseudo}"></c:out></h2>
 		<br>
 		
 		<dl class="dl-horizontal">
 		  <dt>Firstname</dt>
		  <dd><c:out value="${sessionScope.loggedUser.firstname}"></c:out></dd>
		  <dt>Name</dt>
		  <dd><c:out value="${sessionScope.loggedUser.name}"></c:out></dd>
		  <dt>Date of birth</dt>
		  <dd><c:out value="${sessionScope.loggedUser.dob}"></c:out></dd>
		  <dt>Email</dt>
		  <dd><c:out value="${sessionScope.loggedUser.email}"></c:out></dd>
		  <dt>Pseudo</dt>
		  <dd><c:out value="${sessionScope.loggedUser.pseudo}"></c:out></dd>
		  <dt>Phone</dt>
		  <dd><c:out value="${sessionScope.loggedUser.phoneNumber}"></c:out></dd>
		  
		  <br>
		   
		</dl>
		<h3>Game accounts</h3><br>
		<form action="gameAccount" method="POST" class="form-inline" data-toggle="validator" id="formGameAccount">
			<fieldset>
				<div class="form-group">
	                <label class="control-label" for="nameGameAccount" >Name: </label>
	                <input class="form-control" type="text" id="nameGameAccount" name="nameGameAccount" placeholder="Name">
	            </div>
	            <div class="form-group">
  					<label class="control-label" for="namePlateform">Platform:</label>
  						<select class="form-control" name="namePlateform" id="namePlateform">
  							<c:forEach items="${listPlatforms }" var="item">
  								<option value="${item.idPlatforms }">${item.name }</option>
  							</c:forEach>
	  					</select>
				</div>
				<div class="form-group">
	                 <button type="submit" class="btn btn-info" name="btnGameAccout" id="btnGameAccout">Create</button>
	            </div>
	            </fieldset>
	        </form>
	        <br>
		<table class="table table-striped table-hover">
			<tr>
				<th>Name</th>
				<th>Platform</th>
				<th>Add game</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<tr>
			<c:forEach items="${listGameAccount }" var="item">
				<c:if test="${item.active }">
					<tr id="gameAccount-${item.idGameAccounts }">
				  			<td><c:out value="${item.name }"/></td>
				  			<td><c:out value="${item.platform.name }"/></td>
				  			<td><form method="POST" action="game"><input type="hidden" name="idGameAccounts" value="<c:out value='${item.idGameAccounts }'/>"><button type="submit" class="btn btn-info btn-sm "><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button></form></td>
				  			<td><form method="POST" action="game"><input type="hidden" name="idGameAccounts" value="<c:out value='${item.idGameAccounts }'/>"><button type="button" class="btn btn-primary btn-sm "><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button></form></td>
				  			<td><form method="POST" action="game"><input type="hidden" name="idGameAccounts" value="<c:out value='${item.idGameAccounts }'/>"><button type="button" class="btn btn-danger btn-sm "><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></form></td>
				  	</tr>
			  	</c:if>
		    </c:forEach>
			</tr>
		</table>
 	</div>
 	
 	
	<c:import url="includes/footer.jsp"/>
</body>
</html>