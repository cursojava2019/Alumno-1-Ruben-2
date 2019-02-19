$( "#blog1" ).click(function(){
	
	
	$('p.excerpt').eq(0).css("display","block");
	$('p.excerpt').eq(0).slideDown(100).show();
	
	$('p.excerpt').eq(1).css("display","none");
	$('p.excerpt').eq(1).hide();
	
    $('p.excerpt').eq(2).css("display","none");
	$('p.excerpt').eq(2).hide();
	
	

	 
});

$( "#blog2" ).click(function(){
	
    $('p.excerpt').eq(0).css("display","none");
	$('p.excerpt').eq(0).hide(100);
	
	$('p.excerpt').eq(1).css("display","block");
	$('p.excerpt').eq(1).slideDown(100).show();
	
    $('p.excerpt').eq(2).css("display","none");
	$('p.excerpt').eq(2).hide(100);
	
	
	 
	 
});

$( "#blog3" ).click(function(){
	
    $('p.excerpt').eq(0).css("display","none");
	$('p.excerpt').eq(0).hide(100);
	
	$('p.excerpt').eq(1).css("display","none");;
	$('p.excerpt').eq(1).hide(100);
	
    $('p.excerpt').eq(2).css("display","block");
	$('p.excerpt').eq(2).slideDown(100).show();
	
	 
	 
});