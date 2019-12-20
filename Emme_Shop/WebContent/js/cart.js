function addToCart(neg,cat,idProdotto, disp,id) {
    		 
    		$("#btnA").click(function() {
   	      	  $( "#back" ).hide( );
   	      	  $( "#alertBox" ).hide();
   	      	});

            $("#back").click(function() {
     	      	  $( "#back" ).hide( );
      	      	  $( "#alertBox" ).hide();
     	      	});
            
   	         idQuantita = "quantita" + id;
             idNote = "note" + id;
             quantita = parseInt(document.getElementById(idQuantita).value);
             note = document.getElementById(idNote).value;
             var prodotti="";
             if (quantita <= 0) {
            	 $( "#alertBox" ).show();
            	 $( "#msg" ).text("Impossibile aggiungere al carrello! Inserire un valore maggiore di 0");
                 $( "#back" ).show( );
          	        
             }
             else if(quantita>disp){
            	 $( "#alertBox" ).show()
            	 $( "#msg" ).text("Impossibile aggiungere al carrello! Inserire un valore minore di "+disp);
            	 $( "#back" ).show( );
             }
             else {
            	 $.getJSON("../AddToCart?prodotto="+idProdotto+"&quant="+quantita+"&descrizione="+note+"&neg="+neg+"&cat="+cat, function(result){
            		   
            		    $.each(result.listaProdotti, function(i, field){//scorrere lista prodotti per ognuno effettua inserimento nel carrello
            		    	
            		    	//$.each(field, function(i, k){
                		    //	alert( i+":"+k+""); 
                		    //});
            		    	
            		    	if(idProdotto==field.idProdotto  &&  neg==field.nomeNegozio  &&  cat==field.nomeCategoria){
            		    		$( "#"+idQuantita ).attr({ "max" : (field.quantita-field.qtaOrdinata),  "min" : 0 });// per settare min e max per aggiungere al carrello
            		    	}
            		    });
            		    
            		    $( ".number" ).text(result.listaProdotti.length);
            		    $( "#alertBox" ).show()
                   	 	$( "#msg" ).text("Prodotto aggiunto al carrello!");
                   		$( "#back" ).show( );  
            	  }).fail(function(data) { //se è fallito l'inserimento
            		    $( "#alertBox" ).show()
                 	 	$( "#msg" ).text("Impossibile aggiungere al carrello! Quantità ordinata non disponibile!");
                 		$( "#back" ).show( ); 
            	  });
             }

        	 $( "#"+idQuantita ).val("0");//setta il valore 
         }



function minusProduct(neg,cat,idProdotto, qtaOrdinata,id) {//nel carrello per aumentare la quantità
    classQuantita = ".cartQta" + id;
    classPrezzo = ".prodTotale" + id;
    note="";
    quantita = parseInt($(classQuantita).text())-1;
    
    if(quantita>=1){
       	 $.getJSON("../MinusProduct?prodotto="+idProdotto+"&quant="+quantita+"&descrizione="+note+"&neg="+neg+"&cat="+cat, function(result){
       		    $.each(result.listaProdotti, function(i, field){
       		    	//if(idProdotto==field.idProdotto  &&  neg==field.nomeNegozio  &&  cat==field.nomeCategoria){
       		    		// $( classQuantita ).text(field.qtaOrdinata);
       		    		//var prezzo=field.qtaOrdinata * field.prezzo;
       		    		//$( classPrezzo).text(prezzo.toFixed(2)+"€");
       		 	        
       		    	//}
       		    	$(".content").load(location.href + " .content");
       		    }); 
       		    
       	  }).fail(function(data) { 
       		    
       	  });
    }
}


function addProduct(neg,cat,idProdotto, qta,id) {//aggiungi quantità
	$("#btnA").click(function() {
	      	  $( "#back" ).hide( );
	      	  $( "#alertBox" ).hide();
	      	});

      $("#back").click(function() {
	      	  $( "#back" ).hide( );
	      	  $( "#alertBox" ).hide();
	      	});

      classQuantita = ".cartQta" + id;
      classPrezzo = ".prodTotale" + id;
    note="";
    quantita=0;
    quantita = parseInt($(classQuantita).text())+1;
    if(qta>=quantita){
       	 $.getJSON("../AddProduct?prodotto="+idProdotto+"&quant="+quantita+"&descrizione="+note+"&neg="+neg+"&cat="+cat, function(result){
       		    $.each(result.listaProdotti, function(i, field){
       		    	//if(idProdotto==field.idProdotto  &&  neg==field.nomeNegozio  &&  cat==field.nomeCategoria){
       		    		//$( classQuantita ).text(field.qtaOrdinata);
       		    		//var prezzo=field.qtaOrdinata * field.prezzo;
       		    		//$( classPrezzo).text(prezzo.toFixed(2)+"€");
       		    		
       		    	//}
       		    	$(".content").load(location.href + " .content");
       		    }); 
       		    
       	  }).fail(function(data) { 
       		    
       	  });
    }
    else{
    	$( "#alertBox" ).show()
   	 	$( "#msg" ).text("Quantità non disponibile!");
   		$( "#back" ).show( );  
    }
}


function removeCartProduct(neg,cat,idProdotto,id) {
	$("#btnA").click(function() {
	      	  $( "#back" ).hide( );
	      	  $( "#alertBox" ).hide();
	      	});

      $("#back").click(function() {
	      	  $( "#back" ).hide( );
	      	  $( "#alertBox" ).hide();
	      	});

      classProdotto = ".prod" + id;
   
       	 $.getJSON("../RemoveCartProduct?prodotto="+idProdotto+"&neg="+neg+"&cat="+cat, function(result){
       		$( "#alertBox" ).show()
       	 	$( "#msg" ).text("Prodotto rimosso dal carrello!");
       		$( "#back" ).show( ); 
       		//$( classProdotto ).remove();
       		$(".content").load(location.href + " .content");
       		    
       	  });
    
    	 
    
}

















function confirm(){
	$("#btnA").click(function() {
	      	 window.open('ordini.jsp','_self');
	      	});

      $("#back").click(function() {
    	  window.open('ordini.jsp','_self');
	      	});
      
       	 $.post("../ConfermaOrdine",
       	     {
       		 	
         	 } , function(result){
         		 
        		    $( "#alertBox" ).show()
               	 	$( "#msg" ).text("Ordine Confermato!");
               		$( "#back" ).show( ); 
               		$(".content").load(location.href + " .content");
	         		 
       	  });

	}


