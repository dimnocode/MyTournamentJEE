$(document).ready(function(){
	 $('.datepicker').datepicker({
		    format: 'yyyy-mm-dd'
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
	$(document).on('click','#onlineTournament',function(){
		if($(this).is(":checked")){
			$('#location').hide()
		}else{
			$('#location').show()
		}
	})
	
});

/**/


