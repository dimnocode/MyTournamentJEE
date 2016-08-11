<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html">
<html>
<c:import url="includes/head.jsp"/>

<body data-spy="scroll" data-target=".navbar" data-offset="50">
	<c:import url="includes/header.jsp"/>
	
	<div class="container">
		<h1>List of clan</h1>
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
		</div>
		<c:forEach items="${listClan}" var="item">
		<form method="POST" action="clans" class="form-inline">
			<div class="form-group">
				<h3><c:out value="${item.name }"/></h3>
			</div>&nbsp;&nbsp;
			<c:if test="${listUserClan == null}">
				<input type="hidden" name="idClan" value="<c:out value='${item.idClan }'/>"><button type="submit" name="btnShowClan" class="btn btn-primary btn-sm "><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
			</c:if>
			<c:if test="${listUserClan != null}">
				<input type="hidden" name="idClan" value="<c:out value='${item.idClan }'/>"><button type="submit" name="btnHideClan" class="btn btn-success btn-sm "><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button>
			</c:if>
		</form>
		</c:forEach>
		
		<c:if test="${listUserClan != null}">
			<table class="table table-striped">
					<tr>
						<th>Pseudo</th>
						<th>Email</th>
						<th>Name</th>
						<th>Firstname</th>
					</tr>
					<tr>
					<c:forEach items="${listUserClan }" var="item">
							<tr id="userClan-${item.idUsers }">
						  			<td><c:out value="${item.pseudo }"/></td>
						  			<td><c:out value="${item.email }"/></td>
						  			<td><c:out value="${item.name }"/></td>
						  			<td><c:out value="${item.firstname }"/></td>
						  	</tr>
				    </c:forEach>
					</tr>
				</table>
		</c:if>
	</div>
	
	<c:import url="includes/footer.jsp"/>
</body>
</html>