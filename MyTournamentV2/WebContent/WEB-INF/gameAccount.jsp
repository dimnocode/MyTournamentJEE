<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="includes/head.jsp"/>
<body>
	<c:import url="includes/header.jsp"/>
	
	<div class="container spacer">
		<h1>Game account</h1>
		<br>
		<div class="form">
			<form action="gameAccount" method="POST" class="form-horizontal" data-toggle="validator" id="formGameAccount">
			<fieldset>
				<div class="form-group">
	                <label class="col-sm-2 control-label" for="nameGameAccount" >Name: </label>
	                <div class="col-sm-10">
	                    <input class="form-control" type="text" id="nameGameAccount" name="nameGameAccount" placeholder="Name">
	                </div>
	            </div>
	            
	            <div class="form-group">
  					<label class="col-sm-2 control-label" for="namePlateform">Plateform:</label>
  					<div class="col-sm-10">
  						<select class="form-control" name="namePlateform" id="namePlateform">
  							<c:forEach items="${listGameAccountPlatforms }" var="item">
  								<option value="${item.idGameAccountPlatforms }">${item.nom }</option>
  							</c:forEach>
	    					
	  					</select>
  					</div>
				</div>
				<div class="form-group">
	                <div class="col-sm-offset-2 col-sm-10">
	                    <button type="submit" class="btn btn-info" name="btnGameAccout" id="btnGameAccout">Create</button>
	                </div>
	            </div>
	            
	            </fieldset>
	        </form>
	        <div id="gameAccountAccepted"></div>
        </div>
        <br>
        <a href="/MyTournamentV2">back to index page</a>
	</div>
	
	<c:import url="includes/footer.jsp"/>
</body>
</html>