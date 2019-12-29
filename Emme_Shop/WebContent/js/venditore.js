function deleteVend(usernameV){
   					
   			       	 $.post("../RemoveVend",
   			       	     {
   			       		  id:usernameV
   			         	 } , function(result){
		   			       		   
   			       	  });
   		
   				}


//conferma cancellazione della categoria
function cancella(neg,cat) {
	  var domanda = confirm("Sei sicuro di voler cancellare?");
	  if (domanda === true) {
		  location.href='../RemoveCat?negozio='+neg+'&categoria='+cat;
			
	  }else{
	    alert('Operazione annullata');
	    
	  }
	}
// <a href='../RemoveCat?negozio=<%= bean.getNomeNegozio() %>&categoria=<%= bean.getNomeCategoria() %>'><img  style="cursor:pointer;" src='../images/delete.png'></a>

//<a href=''><img onclick="deleteCat('<%= bean.getNomeNegozio() %>','<%= bean.getNomeCategoria() %>')" style="cursor:pointer;" src='../images/delete.png'></a>


function myFunction(neg,cat) {
	  var txt;
	  var r = confirm("Sei sicuro di voler cancellare?");
	  if (r === true) {
		  window.location.href='../RemoveCat?negozio='+neg+'&categoria='+cat;
		  
	  } else {
		  window.locatio.reload();
	  }
	  
	}