<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<c:import url="includes/head.jsp"/>
<body>
	<c:import url="includes/header.jsp"/>
	
	<div class="container">
		
		<h1>Register</h1>
		<br>
		<c:import url="includes/msg.jsp"/>
		<div class="form">
			<form action="register" method="POST" class="form-horizontal" data-toggle="validator" id="formUser">
			<fieldset>
				<div class="form-group">
	                <label class="col-sm-2 control-label" for="nameUser" >Name: </label>
	                <div class="col-sm-10">
	                    <input class="form-control" type="text" id="nameUser" name="nameUser" placeholder="Name">
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label" for="firstnameUser" >Firstname: </label>
	                <div class="col-sm-10">
	                    <input class="form-control" type="text" id="firstnameUser" name="firstnameUser" placeholder="Firstname">
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label" for="emailUser" >Email: </label>
	                <div class="col-sm-10">
	                    <input class="form-control" type="email" id="emailUser" name="emailUser" placeholder="Email">
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label" for="phoneUser" >Phone number: </label>
	                <div class="col-sm-10">
	                    <input class="form-control" pattern="^\d{4}/\d{3}-\d{3}$" type="text" id="phoneUser" name="phoneUser" placeholder="0000/000-000">
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label" for="pseudoUser" >Pseudo: </label>
	                <div class="col-sm-10">
	                    <input class="form-control" type="text" id="pseudoUser" name="pseudoUser" placeholder="Pseudo">
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label" for="dobUser" >Date of birth: </label>
	                <div class="col-sm-10">
	                    <input class="datepicker form-control" readonly type="text" id="dobUser" name="dobUser" placeholder="Date of birth">
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label" for="passUser">Password: </label>
	                <div class="col-sm-10">
	                    <input class="form-control" type="password" id="passUser" name="passUser" placeholder="Password">
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label" for="confirmUser">Confirm: </label>
	                <div class="col-sm-10">
	                    <input class="form-control" type="password" id="confirmUser" name="confirmUser" placeholder="Confirm your password">
	                </div>
	            </div>
	            <div class="form-group">
	                <div class="col-sm-offset-2 col-sm-10">
	                    <button id="submitUser" type="submit" class="btn btn-info">Register</button>
	                </div>
	            </div>
	            </fieldset>
	        </form>
	        <div id="registerAccepted"></div>
        </div>
        <br>
        <a href="/MyTournamentV2">back to index page</a>
	</div>
	
	<c:import url="includes/footer.jsp"/>
</body>
</html>