<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	</div>
	
	<c:import url="includes/footer.jsp"/>
</body>
</html>