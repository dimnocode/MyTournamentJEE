<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<c:import url="includes/head.jsp"/>

<body>
	<c:import url="includes/header.jsp"/>
	
	<div class="container spacer">
		<h1>New tournament</h1>
		<br>
		<div class="form">
			<form action="tournament" method="POST" class="form-horizontal" data-toggle="validator" id="formTournament">
			<fieldset>
				<div class="form-group">
	                <label class="col-sm-2 control-label" for="nameTournament" >Name: </label>
	                <div class="col-sm-5">
	                    <input class="form-control" type="text" id="nameTournament" name="nameTournament" placeholder="Name">
	                </div>
	            </div>
	            <div class="form-group">
	                <label class="col-sm-2 control-label">Online: </label>
	                <div class="col-sm-10">
	                <label style="margin-top:6px;">
		                 <input type="checkbox" id="onlineTournament" name="onlineTournament" value="1">
	                </label>
	                </div>
	            </div>
	            
	            <div class="form-group">
  					<label class="col-sm-2 control-label" for="typeTournament">Type:</label>
  					<div class="col-sm-4">
			            <select class="form-control" name="typeTournament" id="typeTournament">	
			            	<c:forEach items="${listTypeOfTournament }" var="item">		
		  						<option value="${item.name }">${item.name}</option>
		  					</c:forEach>
			  			</select>
		  			</div>
		  		</div>
	            <div class="form-group">
  					<label class="col-sm-2 control-label" for="formatTournament">Format:</label>
  					<div class="col-sm-3">
			            <select class="form-control" name="formatTournament" id="formatTournament">	
			            	<c:forEach items="${listFormatOfTournament }" var="item">		
		  						<option value="${item.name }">${item.name}</option>
		  					</c:forEach>
			  			</select>
		  			</div>
		  		</div>
	            <div class="form-group">
  					<label class="col-sm-2 control-label" for="maxPlayerTournament">Max players:</label>
  					<div class="col-sm-2">
			            <select class="form-control" name="maxPlayerTournament" id="maxPlayerTournament">		
		  					<option value="2">2</option>
		  					<option value="4">4</option>
		  					<option value="6">6</option>
		  					<option value="8">8</option>
		  					<option value="10">10</option>
		  					<option value="12">12</option>
		  					<option value="14">14</option>
		  					<option value="16">16</option>
		  					<option value="18">18</option>
		  					<option value="20">20</option>
			  			</select>
		  			</div>
		  		</div>
	            <div class="form-group">
	                <div class="col-sm-offset-2 col-sm-10">
	                    <button id="submitTournament" type="submit" class="btn btn-info">Create</button>
	                </div>
	            </div>
	            </fieldset>
	        </form>
	        <div id="registerAccepted"></div>
        </div>
		
		
	</div>
	
	<c:import url="includes/footer.jsp"/>
</body>
</html>