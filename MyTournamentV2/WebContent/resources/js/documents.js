$(document).ready(function(){
	 $('.datepicker').datepicker({
		    format: 'yyyy-mm-dd'
		 });
	/*$(document).on('keyup','#passUser',function(){
		if($(this).val() != ""){
			$(this).attr('name','passUser');
		}else{
			$(this).attr('name','passUserUpdate');
		}
	})*/
	
	$(document).on('click','a[href^="#"]',function () {
        var ou = $(this).attr("href").substr(1);
        var saut = $("a[name='" + ou + "']");
        $('html,body').animate({scrollTop: $(saut).offset().top}, 1000);
        return false;
    });
});

/**/


