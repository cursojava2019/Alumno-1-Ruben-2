	
   $(document).ready(function(){
            $("#boton1").click(function(){
            	
            	 $('body').prepend( "<ul id='slideshow2'>" );
            	 $('#slideshow').appendTo('#slideshow2');
            });
        });
      
   $(document).ready(function(){
          $("#boton2").click(function(){
        	  
        	      var $p=$("#slideshow > li");
        	      var tamano=$p.length;
        	      
        	      $p.hide();
        	      $p.first();
        	      var cont=0;
                  var myVar=setInterval(function(){
                      $p.eq(cont).fadeIn(1000);
                	  $p.eq(cont).fadeOut(1000);
                	  cont++;
                	  if(cont>=tamano){
                		  cont=0;
                	  }
					  
					 $(document).ready(function(){ 
					  $("#boton3").click(function(){
                       
                            clearInterval(myVar);
                       });
					});
						   
                  }, 2000);
                  
          	
          	
          });
      });
      
	  
	  var contador=0; 
      $(document).ready(function(){
          $("#boton3").click(function(){
        	  
        	      var $p=$("#slideshow > li");
        	      var tamano=$p.length;
        	      
				      $p.hide();
					  //$p.first();
				      
                       $p.eq(contador).fadeIn(1000);
                	   //$p.eq(contador).fadeOut(1000);
					  
                	  contador++;
                	  if(contador>=tamano){
                		  contador=0;
                	  }
                 
                  
          	
          	
          });
      });

  