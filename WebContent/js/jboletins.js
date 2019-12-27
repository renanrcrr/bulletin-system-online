function checkR(radio)
{
	if(radio == 'nome')
	{
		document.getElementById("saram").disabled= 'disabled';
		document.getElementById("saram").value='';
		document.getElementById("nome").disabled='';
	}
	else
	{
		document.getElementById("nome").disabled= 'disabled';
		document.getElementById("nome").value='';
		document.getElementById("saram").disabled='';
	}
}
function checarInputs()
{
	if(document.getElementById("nome").disabled == false  && document.getElementById("nome").value.length == 0)
	{
		alert("Campo NOME inválido!");
		return false;
	}
	else if(document.getElementById("saram").disabled == false)
	{
		var valor = document.getElementById("saram").value;
		 var er = /\d{6,7}/;
		 var resul = er.test( valor );
		 if(!resul)
		 {
			 alert("Campo SARAM inválido!");
			 document.getElementById("saram").value=null;
			 return false;
		 }
    }
	else if(document.getElementById("nome").disabled == false  && document.getElementById("nome").value.length > 0)
	{    	
		var valor =  document.getElementById("nome").value;
   		 
   	    valor = replaceAll(valor,'(','');
   		valor = replaceAll(valor,')','');
   		valor = replaceAll(valor,'[','');
   		valor = replaceAll(valor,']','');
   		valor = replaceAll(valor,'{','');
   		valor = replaceAll(valor,'}','');
   		valor = replaceAll(valor,'.','');
   		valor = replaceAll(valor,'*','');
   		valor = replaceAll(valor,'+','');
   		valor = replaceAll(valor,'\\','');
   		valor = replaceAll(valor,'//','');
   		document.getElementById("nome").value=valor;
   		//alert(valor);
	  //document.getElementById("s").value=null;
	 // return false;
    }
}
function replaceAll(string, token, newtoken) 
{
	while (string.indexOf(token) != -1) 
	{
 		string = string.replace(token, newtoken);
	}
	return string;
}