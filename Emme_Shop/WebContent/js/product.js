function deleteProd(idP){
   					
   			       	 $.post("../RemoveProd",
   			       	     {
   			       		  id:idP
   			         	 } , function(result){
		   			       		   
   			       	  });
   		
   				}