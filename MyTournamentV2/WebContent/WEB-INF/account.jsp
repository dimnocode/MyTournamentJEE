<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html">
<html>
<c:import url="includes/head.jsp"/>
<body>
 	<c:import url="includes/header.jsp"/>
 	<div class="container">
 		<h2>Welcome <c:out value="${sessionScope.loggedUser.pseudo}"></c:out></h2>
 		<br>
 		<c:import url="includes/msg.jsp"/>
 		<form class="form-inline" method="POST" action="">
 			<div class="form-group">
 				<h3>Account info </h3>
 			</div>&nbsp;&nbsp;
 			<c:if test="${!flagUpdate }">
 				<button type="submit" id="btnEditUser" name="btnEditUser" class="btn btn-primary btn-sm "><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button>
 			</c:if>
 			<c:if test="${flagUpdate }">
 				<button type="submit" id="btnSaveUser" name="btnSaveUser" class="btn btn-success btn-sm "><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button>
 			</c:if>
 		</form><br>
 		
 		<c:if test="${!flagUpdate }">
 			<dl class="dl-horizontal">
 		  	<dt>Firstname</dt>
			  <dd><c:out value="${sessionScope.loggedUser.firstname}"></c:out></dd>
			  <dt>Name</dt>
			  <dd><c:out value="${sessionScope.loggedUser.name}"></c:out></dd>
			  <dt>Date of birth</dt>
			  <dd> <fmt:formatDate value="${sessionScope.loggedUser.dob}" pattern="yyyy-MM-dd"/></dd>
			  <dt>Email</dt>
			  <dd><c:out value="${sessionScope.loggedUser.email}"></c:out></dd>
			  <dt>Pseudo</dt>
			  <dd><c:out value="${sessionScope.loggedUser.pseudo}"></c:out></dd>
			  <dt>Phone</dt>
			  <dd><c:out value="${sessionScope.loggedUser.phoneNumber}"></c:out></dd>
			</dl>
 		</c:if>
 		<c:if test="${flagUpdate }">
 			<div class="row">
 				<div class="col-sm-6">
 					<form action="" method="POST" class="form-horizontal" data-toggle="validator" id="formUser">
						<fieldset>
						<div class="form-group">
				            <label class="col-sm-2 control-label" for="nameUser" >Name: </label>
				            <div class="col-sm-7">
				                <input class="form-control" type="text" id="nameUser" name="nameUser" placeholder="Name" value="<c:out value="${sessionScope.loggedUser.firstname}"></c:out>">
				            </div>
				        </div>
				        <div class="form-group">
				           <label class="col-sm-2 control-label" for="firstnameUser" >Firstname: </label>
				                <div class="col-sm-7">
				                    <input class="form-control" type="text" id="firstnameUser" name="firstnameUser" placeholder="Firstname" value="<c:out value="${sessionScope.loggedUser.name}"/>">
				                </div>
				            </div>
				            <div class="form-group">
				                <label class="col-sm-2 control-label" for="emailUser" >Email: </label>
				                <div class="col-sm-7">
				                    <input class="form-control" disabled type="email" id="emailUser" name="emailUser" placeholder="Email" value="<c:out value="${sessionScope.loggedUser.email}"></c:out>">
				                </div>
				            </div>
				            <div class="form-group">
				                <label class="col-sm-2 control-label" for="phoneUser" >Phone number: </label>
				                <div class="col-sm-7">
				                    <input class="form-control" pattern="^\d{4}/\d{3}-\d{3}$" type="text" id="phoneUser" name="phoneUser" placeholder="0000/000-000" value="<c:out value="${sessionScope.loggedUser.phoneNumber}"></c:out>">
				                </div>
				            </div>
				            <div class="form-group">
				                <label class="col-sm-2 control-label" for="pseudoUser" >Pseudo: </label>
				                <div class="col-sm-7">
				                    <input class="form-control" disabled type="text" id="pseudoUser" name="pseudoUser" placeholder="Pseudo" value="<c:out value="${sessionScope.loggedUser.pseudo}"></c:out>">
				                </div>
				            </div>
				            <div class="form-group">
				                <label class="col-sm-2 control-label" for="dobUser" >Date of birth: </label>
				                <div class="col-sm-7">
				                    <input class="datepicker form-control" readonly type="text" id="dobUser" name="dobUser" placeholder="Date of birth" value="<fmt:formatDate value="${sessionScope.loggedUser.dob}" pattern="yyyy-MM-dd"/>">
				                </div>
				            </div>
				            <div class="form-group">
				                <div class="col-sm-offset-2 col-sm-4">
				                    <button id="btnChangeUser" name="btnChangeUser" type="submit" class="btn btn-info">Change</button>
				                    <button id="changePassword" type="button" class="btn btn-primary">Password</button>
				                </div>
				            </div>
				        </fieldset>
	        		</form>
 				</div>
 				<div id="divPassword" class="col-sm-6">
 					<form action="" method="POST" class="form-horizontal" data-toggle="validator" id="formUserPasswordEdit">
						<fieldset>
						<div class="form-group">
			                <label class="col-sm-2 control-label" for="passUserEdit">Password: </label>
			                <div class="col-sm-7">
			                    <input class="form-control" disabled type="password" id="passUserEdit" name="passUserEdit" placeholder="Password">
			                </div>
			            </div>
						<div class="form-group">
			                <label class="col-sm-2 control-label" for="newPassUserEdit">New password: </label>
			                <div class="col-sm-7">
			                    <input class="form-control" disabled type="password" id="newPassUserEdit" name="newPassUserEdit" placeholder="Password">
			                </div>
			            </div>
			            <div class="form-group">
			                <label class="col-sm-2 control-label" for="confirmUserEdit">Confirm: </label>
			                <div class="col-sm-7">
			                    <input class="form-control" disabled type="password" id="confirmUserEdit" name="confirmUserEdit" placeholder="Confirm your password">
			                </div>
			            </div>
			            <div class="form-group">
			                <div class="col-sm-offset-2 col-sm-4">
			                    <button id="btnEditPasswordUser" name="btnEditPasswordUser" type="submit" class="btn btn-info">Change</button>
			                </div>
			            </div>
			            </fieldset>
			        </form>
 				</div>
 			</div>
 		  	
 		</c:if>
 		
		<h3>Game accounts</h3><br>
		<form action="" method="POST" class="form-inline" data-toggle="validator" id="formGameAccount">
			<fieldset>
				<div class="form-group">
	                <label class="control-label" for="nameGameAccount" >Name: </label>
	                <input class="form-control" type="text" id="nameGameAccount" name="nameGameAccount" placeholder="Name">
	            </div>
	            <div class="form-group">
  					<label class="control-label" for="namePlateform">Platform:</label>
  						<select class="form-control" name="namePlateform" id="namePlateform">
  							<c:forEach items="${listPlatforms }" var="item">
	  							<c:if test="${item.active }">
	  								<option value="${item.idPlatforms }">${item.name }</option>
	  							</c:if>
  							</c:forEach>
	  					</select>
				</div>
				<div class="form-group">
	                 <button type="submit" class="btn btn-info" name="btnGameAccount" id="btnGameAccount">Create</button>
	            </div>
	            <div class="form-group">
	                 <button type="button" class="btn btn-primary" name="btnGameAccountRemoved" id="btnGameAccountRemoved">Game accounts not active</button>
	            </div>
	            </fieldset>
	        </form>
	        <br>
		<table class="table table-striped">
			<tr>
				<th>Name</th>
				<th>Platform</th>
				<th>Add game</th>
				<th id="action">Delete</th>
			</tr>
			<tr>
			<c:forEach items="${listGameAccount }" var="item">
				<c:if test="${item.active }">
					<tr id="gameAccountActive">
				  			<td><c:out value="${item.name }"/></td>
				  			<td><c:out value="${item.platform.name }"/></td>
				  			<td><form method="POST" action="game"><input type="hidden" name="idGameAccounts" value="<c:out value='${item.idGameAccounts }'/>"><button type="submit" class="btn btn-info btn-sm "><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button></form></td>
				  			<td><form method="POST" action="account"><input type="hidden" name="idGameAccounts" value="<c:out value='${item.idGameAccounts }'/>"><button type="submit" name="btnRemoveGameAccount" class="btn btn-danger btn-sm "><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></form></td>
				  	</tr>
			  	</c:if>
			  	<c:if test="${item.active == false}">
					<tr id="gameAccountNotActive">
				  			<td><c:out value="${item.name }"/></td>
				  			<td><c:out value="${item.platform.name }"/></td>
				  			<td><form method="POST" action="game"><input type="hidden" name="idGameAccounts" value="<c:out value='${item.idGameAccounts }'/>"><button type="submit" class="btn btn-info btn-sm "><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button></form></td>
				  			<td><form method="POST" action="account"><input type="hidden" name="idGameAccounts" value="<c:out value='${item.idGameAccounts }'/>"><button type="submit" name="btnActiveGameAccount" class="btn btn-success btn-sm "><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></button></form></td>
				  	</tr>
			  	</c:if>
		    </c:forEach>
			</tr>
		</table>
		
		
			
		
 	</div>
 	
 	
	<c:import url="includes/footer.jsp"/>
</body>
</html>