function deleteVend(usernameV){
   					
   			       	 $.post("../RemoveVend",
   			       	     {
   			       		  id:usernameV
   			         	 } , function(result){
		   			       		   
   			       	  });
   		
   				}