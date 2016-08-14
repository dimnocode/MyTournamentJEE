s<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<c:import url="includes/head.jsp" />

<body>
	<c:import url="includes/header.jsp" />

	<div class="container">
		<h1>New tournament</h1>
		<br>
		<form action="tournamentcreation" method="POST" class="form-horizontal"
			data-toggle="validator" id="formTournament">
			<div class="row">
				<div class="col-md-6">
					<div class="form">

						<div class="form-group">
							<label class="col-sm-2 control-label" for="nameTournament">Name:
							</label>
							<div class="col-sm-5">
								<input class="form-control" type="text" id="nameTournament"
									name="nameTournament" placeholder="Name">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="gameTournament">Game:</label>
							<div class="col-sm-5">
								<select class="form-control" name="gameTournament"
									id="gameTournament">
									<c:forEach items="${listGames }" var="item" varStatus="pos">
										<option value="${pos.index}">${item.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">Online: </label>
							<div class="col-sm-5">
								<label style="margin-top: 6px;"> <input type="checkbox"
									checked id="onlineTournament" name="onlineTournament" value="1">
								</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="typeTournament">Type:</label>
							<div class="col-sm-5">
								<select class="form-control" name="typeTournament"
									id="typeTournament">
									<c:forEach items="${listTypeOfTournament }" var="item" varStatus="pos">
										<option value="${pos.index}">${item.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="formatTournament">Format:</label>
							<div class="col-sm-5">
								<select class="form-control" name="formatTournament"
									id="formatTournament">
									<c:forEach items="${listFormatOfTournament }" var="item" varStatus="pos">
										<option value="${pos.index}">${item.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="maxPlayerTournament">Max
								players:</label>
							<div class="col-sm-5">
								<input class="form-control" type="number" min="3" max="1000"
									id="maxPlayerTournament" name="maxPlayerTournament"
									placeholder="Max player">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="startDateTournament">Start
								date: </label>
							<div class="col-sm-5">
								<input class="datetimepicker form-control" type="text"
									id="startDateTournament" name="startDateTournament"
									placeholder="Start date">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="endDateTournament">End
								date: </label>
							<div class="col-sm-5">
								<input class="datetimepicker form-control" type="text"
									id="endDateTournament" name="endDateTournament"
									placeholder="End date">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="priceTournament">Price
							</label>
							<div class="col-sm-5">
								<input class="form-control" type="number" min="0"
									id="priceTournament" name="priceTournament"
									placeholder="Price">
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div id="location">
						<div class="form-group">
							<label class="col-sm-2 control-label" for="street">Street:
							</label>
							<div class="col-sm-5">
								<input class="form-control" type="text" id="street"
									name="street" placeholder="Street">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="town">Town:
							</label>
							<div class="col-sm-5">
								<input class="form-control" type="text" id="town"
									name="town" placeholder="Town">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="zipcode">Zip
								code: </label>
							<div class="col-sm-5">
								<input class="form-control" type="text" id="zipcode"
									name="zipcode" placeholder="Zip code">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="country">Country:
							</label>
							<div class="col-sm-5">
								<input class="form-control" type="text" id="country"
									name="country" placeholder="Country">
							</div>
						</div>

					</div>

				</div>
				<div class="form-group">
					<div class="col-sm-offset-1 col-sm-6">
						<button style="margin-left:60px;" id="submitTournament" type="submit" class="btn btn-info">Create</button>
					</div>
				</div>
			</div>


		</form>


	</div>

	<c:import url="includes/footer.jsp" />
</body>
</html>