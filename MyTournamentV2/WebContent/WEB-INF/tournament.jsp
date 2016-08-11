<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<c:import url="includes/head.jsp" />

<body>
	<c:import url="includes/header.jsp" />

	<div class="container">
		<h1>New tournament</h1>
		<br>
		<form action="tournament" method="POST" class="form-horizontal"
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
									<c:forEach items="${listGames }" var="item">
										<option value="${item.idGames}">${item.name}</option>
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
									<c:forEach items="${listTypeOfTournament }" var="item">
										<option value="${item.idTypeOfTournaments }">${item.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="formatTournament">Format:</label>
							<div class="col-sm-5">
								<select class="form-control" name="formatTournament"
									id="formatTournament">
									<c:forEach items="${listFormatOfTournament }" var="item">
										<option value="${item.idFormatTournaments }">${item.name}</option>
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
							<label class="col-sm-2 control-label" for="streetTournament">Street:
							</label>
							<div class="col-sm-5">
								<input class="form-control" type="text" id="streetTournament"
									name="nameTournament" placeholder="Street">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="cityTournament">Town:
							</label>
							<div class="col-sm-5">
								<input class="form-control" type="text" id="cityTournament"
									name="cityTournament" placeholder="City">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="zipCodeTournament">Zip
								code: </label>
							<div class="col-sm-5">
								<input class="form-control" type="text" id="zipCodeTournament"
									name="zipCodeTournament" placeholder="Zip code">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="countryTournament">Country:
							</label>
							<div class="col-sm-5">
								<input class="form-control" type="text" id="countryTournament"
									name="countryTournament" placeholder="Country">
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