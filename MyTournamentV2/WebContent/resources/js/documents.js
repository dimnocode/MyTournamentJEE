$(document).ready(function(){
	 $('.datepicker').datepicker({
		    format: 'yyyy-mm-dd'
		 });
	$('.datetimepicker').datetimepicker({
		format: 'YYYY-MM-DD HH:mm:ss'
	});
	
	if($('table').children().children().length > 6){
		$('#nameGameAccount').attr('disabled',true);
		$('#namePlateform').attr('disabled',true);
		$('#nameGameAccount').attr('placeholder','You have 5 game account')
		$('#btnGameAccount').attr('disabled',true);
	}else{
		$('#nameGameAccount').attr('disabled',false);
		$('#namePlateform').attr('disabled',false);
		$('#btnGameAccount').attr('disabled',false);
		$('#nameGameAccount').attr('placeholder','Name');
	}
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
		if($(this).parent().parent().next().attr("class") == "userClan"){
			$(this).parent().parent().next().removeClass('userClan');
		}else{
			$(this).parent().parent().next().addClass('userClan');
		}
	})
});

/**/


