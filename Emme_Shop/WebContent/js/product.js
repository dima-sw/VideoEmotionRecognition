function deleteProd(idP){
	var txt;
	  var r = alert("Sei sicuro di voler cancellare?");
	  if (r === true) {
		  $.post("../RemoveProd",
		       	     {
		       		  id:idP
		         	 } , function(result){
	   			       		   
		       	  });
		  
	  } else {
		  window.location.reload();
	  }
	  
	  window.open('./venditore/index-venditore-prodotti.jsp','_self');
	  
   			       	 
   				
}