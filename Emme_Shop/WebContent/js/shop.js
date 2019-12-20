function deleteShop(nomeN){
   					
   			       	 $.post("../RemoveShop",
   			       	     {
   			       		  nome:nomeN
   			         	 } , function(result){
		   			       		   
   			       	  });
   		
   				}