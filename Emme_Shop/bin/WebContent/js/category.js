function deleteCat(neg,cat){
	var txt;
	  var r = confirm("Sei sicuro di voler cancellare?");
	  if (r === true) {
		  
		  $.post("../RemoveCat",
		       	     {
		       		  negozio:neg,
		       		  categoria:cat
		       		  
		         	 }  , function(result){
		         		 		   
		       	  });
		  
	  } else {
		  window.location.reload();
	  }
	  
	  window.open('./venditore/index-venditore.jsp','_self');
	  
	}
   			       	 




 	 

  			      
  			
   			       	 