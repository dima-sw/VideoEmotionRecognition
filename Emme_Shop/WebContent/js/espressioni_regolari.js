function isDisable(){
	$('.verifica').attr('disabled', 'disabled');
}
function isActive(){
	$('.verifica').removeAttr('disabled');
}

//verifica i nomi e cognomi solo lettere
function isName(uname) {
    var letters = /^[A-Za-z]+$/;
    if (uname.value.match(letters)) {
    	//alert("ok");
    	//uname.style.backgroundColor="rgba(0,255,0,0.3)";//Javascript
    	$(uname).css("background-color","rgba(0, 255, 0, 0.3)");
    	isActive();
        return flag;
    }
    else {
    	$(uname).css("background-color","rgba(255,0,0,0.2)");
    	//uname.style.backgroundColor="rgba(255,0,0,0.3)";
        //alert("sbagliat");
    	uname.focus();
    	isDisable();
        return flag=false;
    }
}  

//username lettere e numeri
function isUsername(uadd)
{
    var letters = /^[0-9a-zA-Z]{3,16}$/;
    if (uadd.value.match(letters)) {
    	$(uadd).css("background-color","rgba(0, 255, 0, 0.3)");
    	isActive();
    	return true;
    }
    else {
        //alert('User address must have alphanumeric characters only');
        uadd.focus();
        $(uadd).css("background-color","rgba(255,0,0,0.2)");
        isDisable();
        return false;
    }
} 
//username lettere e numeri  usata nei campi illimitati. permette spazio es input categoria
function isStreet(uadd)
{
    var letters = /^[0-9a-zA-Z ]+$/;
    if (uadd.value.match(letters)) {
    	$(uadd).css("background-color","rgba(0, 255, 0, 0.3)");
    	isActive();
    	return true;
    }
    else {
        //alert('User address must have alphanumeric characters only');
        uadd.focus();
        $(uadd).css("background-color","rgba(255,0,0,0.2)");
        isDisable();
        return false;
    }
} 

/*password lettere e numeri
almeno un numero, alfanumerico minuscolo, maiuscolo, almeno un carattere speciale, lunghezza 6-25,
*/
function isPassword(uadd)
{
    var letters = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[_.,\-+*!#@?])([a-zA-Z0-9_.,\-+*!#@?]{6,25})$/;
    if (uadd.value.match(letters)) {
    	$(uadd).css("background-color","rgba(0, 255, 0, 0.3)");
    	isActive();
    	return true;
    }
    else {
        //alert('User address must have alphanumeric characters only');
        uadd.focus();
    	$(uadd).css("background-color","rgba(255,0,0,0.2)");
    	isDisable();
    	return false;
    }
} 

//valida l'email
function isEmail(uemail) {
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (uemail.value.match(mailformat)) {
    	$(uemail).css("background-color","rgba(0, 255, 0, 0.3)");
    	isActive();
    	return true;
    }
    else {
        //alert("You have entered an invalid email address!");
        uemail.focus();
    	$(uemail).css("background-color","rgba(255,0,0,0.2)");
    	isDisable();
    	return false;
    }
} 

//almeno 10 caratteri.
function isText(text){
	//var x=/^([a-zA-Zàèìòù' ]|[0-9 ]|[-_ ]|[? ]|[è ][, ]){10,500}$/;
	var x=/^([a-zA-Zàèìòù' ]$/;
	if (text.value.match(x))  
	  	    {
			//$(text).css("background-color","rgba(0, 255, 0, 0.3)");
			isActive();
			
			return true;
		}
		else {
			//alert("message");
			//$(text).css("background-color","rgba(0, 255, 0, 0.3)");
			isActive();
			
			return true;
		}
}

//P.iva italiana per classe Piva
function isPivaIT(input){
	var iva=/^[0-9]{11}$/;
	//var input=document.getElementsByClassName('Piva');
	if (input.value.match(iva))  
  	    {
		$(input).css("background-color","rgba(0, 255, 0, 0.3)");
		isActive();
		return true;
	}
	else {
		//alert("message");
		
		$(input).css("background-color","rgba(255,0,0,0.2)");
		isDisable();
		input.focus();
		return false;
	}
}  




//controllo cap
function isCap(inputtxt) {
    var phoneno = /^\d{5}$/;
    if (inputtxt.value.match(phoneno))  
        {
    	$(inputtxt).css("background-color","rgba(0, 255, 0, 0.3)");
    	isActive();
    	return true;
    }
    else {
        //alert("message");
    	inputtxt.focus();
    	$(inputtxt).css("background-color","rgba(255,0,0,0.2)");
    	isDisable();
    	return false;
    }
}  



//è un numero di telefono
function isPhoneNumber(inputtxt) {
    var phoneno = /^\d{10}$/;
    if (inputtxt.value.match(phoneno))  
        {
    	$(inputtxt).css("background-color","rgba(0, 255, 0, 0.3)");
    	isActive();
    	return true;
    }
    else {
        //alert("message");
    	inputtxt.focus();
    	$(inputtxt).css("background-color","rgba(255,0,0,0.2)");
    	isDisable();
    	return false;
    }
}  

//è un numero senza spazio con punto o -
function phonenumber(inputtxt) {
    var phoneno = /^\(([0-9]{3})\)?[-. ] ([0-9]{3})?[-. ]([0-9]{4})$/;
    if (inputtxt.value.match(phoneno))  
        {
    	$(inputtxt).css("background-color","rgba(0, 255, 0, 0.3)");
    	isActive();
    	return true;
    }
    else {
        //alert("message");
    	inputtxt.focus();
    	$(inputtxt).css("background-color","rgba(255,0,0,0.2)");
    	isDisable();
    	return false;
    }
} 

/*password
possibile formato di una password:
 alfanumerica, minimo 8, massimo 16 caratteri
 almeno una maiuscola una minuscola ed una cifra almeno una maiuscola, una minuscola ed una cifra
 funzione che restituisca true se la pwd è corretta,
false altrimenti
*/
function is_pwd_OK(p) {
    if(
        /^[a-zA-Z0-9]{ } 8,16 $/.test(p) &&
        /[A-Z]/.test(p) &&
        /[a-z]/.test(p) &&
        /[0-9]/.test(p))
    	{
    	$(p).css("background-color","rgba(0, 255, 0, 0.3)");
    	isActive();
    	return true;
    	}
    else{
    	$(p).css("background-color","rgba(255,0,0,0.2)");
    	isDisable();
    	p.focus();
    	return false;
    }
}


//inserisci categoria e prodotto espressioni

//prezzo
function isPrezzo(inputtxt) {
    var cash = /^([0-9]{1,9})\.([0-9]{0,2})$/;//verifica che solo numeri con . decimale e nessun o 2 decimali
    if (inputtxt.value.match(cash))  
        {
    	$(inputtxt).css("background-color","rgba(0, 255, 0, 0.3)");
    	isActive();
    	return true;
    }
    else {
        //alert("message");
    	inputtxt.focus();
    	$(inputtxt).css("background-color","rgba(255,0,0,0.2)");
    	isDisable();
    	return false;
    }
}

function isQuantità(input){
	var q=/^[0-9]+$/;
	if(input.value.match(q))
		{
    	$(input).css("background-color","rgba(0, 255, 0, 0.3)");
    	isActive();
    	return true;
    }
    else {
        //alert("message");
    	input.focus();
    	$(input).css("background-color","rgba(255,0,0,0.2)");
    	isDisable();
    	return false;
    }
	
}

//prende fino al massimo di tre valori, sia sconto che iva
function isSconto(input){
	var q=/^[0-9]{0,2}$/;
	if(input.value.match(q))
		{
    	$(input).css("background-color","rgba(0, 255, 0, 0.3)");
    	isActive();
    	return true;
    }
    else {
        //alert("message");
    	input.focus();
    	$(input).css("background-color","rgba(255,0,0,0.2)");
    	isDisable();
    	return false;
    }
	
}

