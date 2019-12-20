function deleteCliente(usernameC){
	
   			       	 $.post("../RemoveCliente",
   			       	     {
   			       		  id:usernameC
   			         	 } , function(result){
   			         		
   		          	        
   			       	  });
   		
   				}