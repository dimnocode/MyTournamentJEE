<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="includes/head.jsp"/>
<body>
	<c:import url="includes/header.jsp"/>
	
	<div class="container spacer">
		<h1>Register</h1>
		<br>
		<div class="form">
			<form action="register" method="POST" class="form-horizontal" data-toggle="validator" id="formRegister">
			<fieldset>
				<div class="form-group">
	                <label class="col-sm-2 control-label" for="nameRegister" >Name: </label>
	                <div class="col-sm-10">
	                    <input class="form-control" type="text" id="nameRegister" name="nameRegister" placeholder="Name">
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label" for="firstnameRegister" >Firstname: </label>
	                <div class="col-sm-10">
	                    <input class="form-control" type="text" id="firstnameRegister" name="firstnameRegister" placeholder="Firstname">
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label" for="emailRegister" >Email: </label>
	                <div class="col-sm-10">
	                    <input class="form-control" type="email" id="emailRegister" name="emailRegister" placeholder="Email">
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label" for="phoneRegister" >Phone number: </label>
	                <div class="col-sm-10">
	                    <input class="form-control" pattern="^\d{4}/\d{3}-\d{3}$" type="text" id="phoneRegister" name="phoneRegister" placeholder="0000/000-000">
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label" for="pseudoRegister" >Pseudo: </label>
	                <div class="col-sm-10">
	                    <input class="form-control" type="text" id="pseudoRegister" name="pseudoRegister" placeholder="Pseudo">
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label" for="dobRegister" >Date of birth: </label>
	                <div class="col-sm-10">
	                    <input class="datepicker form-control" type="text" id="dobRegister" name="dobRegister" placeholder="Date of birth">
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label" for="passRegister">Password: </label>
	                <div class="col-sm-10">
	                    <input class="form-control" type="password" id="passRegister" name="passRegister" placeholder="Password">
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label" for="confirmeRegister">Confirme: </label>
	                <div class="col-sm-10">
	                    <input class="form-control" type="password" id="confirmeRegister" name="confirmeRegister" placeholder="Confirme your password">
	                </div>
	            </div>
	            <div class="form-group">
	                <div class="col-sm-offset-2 col-sm-10">
	                    <button id="submitRegister" type="submit" class="btn btn-info">Register</button>
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