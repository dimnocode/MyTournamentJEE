<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		  
		  <dt>Game account</dt>
		  <c:forEach items="${listGameAccount }" var="item">
		  		<c:if test="${item.active }">
		  			<dd>${item.name }</dd>
		  			
		  		</c:if>
		  	
		  </c:forEach>
		  <dd><hr></dd>
		  <dd><a href="gameAccount"><input type="submit" value="new" class="btn btn-info"></a></dd>
		  
		  
		</dl>
		
		<table class="table table-striped table-hover">
			<tr>
				<th>Name</th>
				<th>Plateform</th>
				<th>Add game</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<tr>
			<c:forEach items="${listGameAccount }" var="item">
				<c:if test="${item.active }">
					<tr id="gameAccount-${item.idGameAccounts }">
				  			<td><c:out value="${item.name }"/></td>
				  			<td><c:out value="${item.gameaccountplatform.name }"/></td>
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