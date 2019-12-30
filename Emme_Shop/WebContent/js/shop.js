function deleteShop(nomeN){
   					
   			       	 $.post("../RemoveShop",
   			       	     {
   			       		  nome:nomeN
   			         	 } , function(result){
		   			       		   
   			       	  });
   		
   				}

function abilita_submit ()
{
	document.forms.regForm1.btn_submit.disabled = false;
}