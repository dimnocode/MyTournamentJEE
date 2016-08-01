<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<c:import url="includes/head.jsp"/>
<body>
	<c:import url="includes/header.jsp"/>
	
	<div class="container spacer">
		
		<c:import url="includes/msg.jsp"/>
		
		<h1>Login</h1>
		<br>
		<div class="form">
			<form action="" method="POST" class="form-horizontal" data-toggle="validator" id="formLogin">
			<fieldset>
	            <div class="form-group">
	                <label class="col-sm-2 control-label" for="emailLogin" >Email: </label>
	                <div class="col-sm-10">
	                    <input class="form-control" type="email" id="emailLogin" name="emailLogin" placeholder="Email">
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label" for="passLogin">Password: </label>
	                <div class="col-sm-10">
	                    <input class="form-control" type="password" id="passLogin" name="passLogin" placeholder="Password">
	                </div>
	            </div>
	            <div class="form-group">
	                <div class="col-sm-offset-2 col-sm-10">
	                    <button type="submit" class="btn btn-info" name="btnLogin" id="btnLogin">Login</button>
	                </div>
	            </div>
	            </fieldset>
	        </form>
        </div>
        <br>
        <a href="/MyTournamentV2">back to index page</a>
	</div>
	
	<c:import url="includes/footer.jsp"/>
</body>
</html>