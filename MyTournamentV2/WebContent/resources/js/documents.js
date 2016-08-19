$(document).ready(function(){
	
	 $('.datepicker').datepicker({
		    format: 'yyyy-mm-dd'
		 });
	$('.datetimepicker').datetimepicker({
		format: 'YYYY-MM-DD HH:mm:ss'
	});
	$('#myTabs a').click(function (e) {
		  e.preventDefault()
		  $(this).tab('show')
		})
	
	if($('#gameByGameAccount').children().children().length == 0){
		$('#gameByGameAccount').hide();
		$('#gameByGameAccount').prev().prev().hide();
	}else{
		$('#gameByGameAccount').show();
		$('#gameByGameAccount').prev().prev().show();
	}
	$(document).on('click', '#changePassword',function(){
		if($(this).attr("class") == "btn btn-primary"){
			$(this).removeClass("btn-primary").addClass("btn-success");
			$('#formUserPasswordEdit').find('.form-control').attr("disabled",false);
			$('#divPassword').show();
		}else{
			$(this).removeClass("btn-success").addClass("btn-primary");
			$('#formUserPasswordEdit').find('.form-control').attr("disabled",true);
			$('#divPassword').hide();
		}
	})
	$(document).on('click', '#btnGameAccountRemoved',function(){
		if($(this).attr("class") == "btn btn-primary"){
			$(this).removeClass("btn-primary").addClass("btn-success")
			$('#formUserPasswordEdit').find('.form-control').attr("disabled",false);
			$('#gameAccountNotActive').show();
			$('#gameAccountActive').hide();
			$(this).text('Game accounts not active');
			$('#action').text('Added');
		}else{
			$(this).removeClass("btn-success").addClass("btn-primary");
			$('#gameAccountActive').show();
			$('#gameAccountNotActive').hide();
			$(this).text('Game accounts active');
			$('#action').text('Remove');
		}
	})
	$(document).on('click', '#btnPlatformsRemoved',function(){
		if($(this).attr("class") == "btn btn-primary"){
			$(this).removeClass("btn-primary").addClass("btn-success")
			$('.platformsNotActive').show();
			$('.platformsActive').hide();
			$(this).text('Platforms not active');
			$('.action').text('Added');
		}else{
			$(this).removeClass("btn-success").addClass("btn-primary");
			$('.platformsActive').show();
			$('.platformsNotActive').hide();
			$(this).text('Platforms active');
			$('.action').text('Delete');
		}
	})
	$(document).on('click', '#btnTypeoftournamentRemoved',function(){
		if($(this).attr("class") == "btn btn-primary"){
			$(this).removeClass("btn-primary").addClass("btn-success")
			$('.typeoftourmanetNotActive').show();
			$('.typeoftourmanetActive').hide();
			$(this).text('Type of tournament not active');
			$('.action').text('Added');
		}else{
			$(this).removeClass("btn-success").addClass("btn-primary");
			$('.typeoftourmanetActive').show();
			$('.typeoftourmanetNotActive').hide();
			$(this).text('Type of tournament active');
			$('.action').text('Delete');
		}
	})
	$(document).on('click', '#btnFormatoftournamentRemoved',function(){
		if($(this).attr("class") == "btn btn-primary"){
			$(this).removeClass("btn-primary").addClass("btn-success")
			$('.formatoftourmanetNotActive').show();
			$('.formatoftourmanetActive').hide();
			$(this).text('Format of tournament not active');
			$('.action').text('Added');
		}else{
			$(this).removeClass("btn-success").addClass("btn-primary");
			$('.formatoftourmanetActive').show();
			$('.formatoftourmanetNotActive').hide();
			$(this).text('Format of tournament active');
			$('.action').text('Delete');
		}
	})
	$(document).on('click', '#playersActive',function(){
		if($(this).attr("class") == "btn btn-primary playerActive"){
			$(this).removeClass("btn btn-primary playerActive").addClass("btn btn-success playerActive")
			$(this).parent().parent().next().children().last().find('.userNotActive').show();
			$(this).parent().parent().next().children().last().find('.userActive').hide();
			$(this).text('Players not active');
			$(this).parent().parent().next().children().last().find('#action').text('Added');
		}else{
			$(this).removeClass("btn btn-success playerActive").addClass("btn btn-primary playerActive");
			$(this).parent().parent().next().children().last().find('.userNotActive').hide();
			$(this).parent().parent().next().children().last().find('.userActive').show();
			$(this).text('Players active');
			$(this).parent().parent().next().children().last().find('#action').text('Remove');
		}
	})
	$(document).on('click','#btnYourClan',function(){
		if($(this).attr("class") == "btn btn-primary"){
			$(this).removeClass("btn-primary").addClass("btn-success")
			$(this).children().removeClass("glyphicon-plus").addClass("glyphicon-minus")
			$('#yourClan').show();
		}else{
			$(this).removeClass("btn-success").addClass("btn-primary");
			$(this).children().removeClass("glyphicon-minus").addClass("glyphicon-plus")
			$('#yourClan').hide();
		}
	})
	$(document).on('click','#btnClanRegister',function(){
		if($(this).attr("class") == "btn btn-primary"){
			$(this).removeClass("btn-primary").addClass("btn-success")
			$(this).children().removeClass("glyphicon-plus").addClass("glyphicon-minus")
			$('#clanRegister').show();
		}else{
			$(this).removeClass("btn-success").addClass("btn-primary");
			$(this).children().removeClass("glyphicon-minus").addClass("glyphicon-plus")
			$('#clanRegister').hide();
		}
	})
	$(document).on('click','#onlineTournament',function(){
		if($(this).is(":checked")){
			$('#location').hide()
		}else{
			$('#location').show()
		}
	})
	$(document).on('click','.nameClan',function(){
		
		if($(this).parent().parent().parent().parent().next().attr("class") == "userClan"){
			$(this).parent().parent().parent().parent().parent().find('.playerActive').show();
			
			$(this).parent().parent().parent().parent().next().removeClass('userClan');
		}else{
			$(this).parent().parent().parent().parent().parent().find('.playerActive').hide();
			$(this).parent().parent().parent().parent().next().addClass('userClan');
		}
	})
	$(document).on('click','.clanRegister',function(){
		
		if($(this).parent().parent().next().attr("class") == "userClan"){
			$(this).parent().parent().next().removeClass('userClan');
		}else{
			$(this).parent().parent().next().addClass('userClan');
		}
	})
	
});

/**/


