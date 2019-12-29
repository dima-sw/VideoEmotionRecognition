function deleteCat(neg,cat){
   					
   			       	 $.post("../RemoveCat",
   			       	     {
   			       		  negozio:neg,
   			       		  categoria:cat
   			       		  
   			         	 }  , function(result){
   			         		
   			         		alert("Categoria Eliminata");
   		  			       	 
   			  			      location.reload();
   			  			    	  
   			  			      
		   			       		   
   			       	  });

}


 	 

  			      
  			
   			       	 