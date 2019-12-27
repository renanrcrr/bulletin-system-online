<%@page import="java.io.File"%>
<%@page language="java" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/index.css" rel="stylesheet" type="text/css" />
	<script type='text/javascript' src='js/jboletins.js'></script>
	<title>SIBOL</title>
</head>
<body style="font-size: 85.5%;">
	
	<div id="tudo">
		
		<div id="topo">
			<img src="img/topo_sibol_sdab.jpg" width="700" height="200" />
		</div><!-- finaliza o topo -->
	
	<div id="principal">	
	<br>
	<form action="/sibol/files" method="POST" onsubmit="return checarInputs()">
		<label>Defina sua pesquisa por:</label>
		<INPUT TYPE="radio" NAME="OPCAO" VALUE="op1" CHECKED onchange="checkR('saram')">
		<h>Saram </h>
		<INPUT TYPE="radio" NAME="OPCAO" VALUE="op2" onchange="checkR('nome')">
		<h>Nome </h> 
		<br><br/>
		<label>Informe o Saram:</label> 
		<input type="text" name="saram" id="saram" size="40"/>
		<br/><br/>
		<label>Informe o Nome:</label> 
		<input type="text" disabled='disabled' name="nome" id="nome" size="40"/>
		<br/><br/>
		<!-- <a href="Controlador?action=index"><img src="img/voltar.gif" border = "0"/></a>  -->
		<input type="submit" value="" class="bt-pesquisar"/> 
		<br/><br/>
	</form>
		
	<table id="mytable"><!-- div id="listaBoletins" -->			
		<%
			File array[] = null;
			if (request.getAttribute("ARRAY_FILE") != null) 
			{
				array = (File[]) request.getAttribute("ARRAY_FILE");
			} 
			else 
			{
				//File f = new File("C:" + File.separator + "Boletins");
				File f = new File("/home" + File.separator + "renanrcrr" + File.separator + "Boletins");
				array = f.listFiles();
			}
		%>
		<%
			for (int i = 0; i < array.length && !array[i].getName().equals("Thumbs.db"); i++) 
			{
				out.print("<tr><td><a href='/sibol/files?cmd="
						+ array[i].getAbsolutePath() + "'>"
						+ array[i].getName() + "</a></td></tr>");
			}
		%>
	</table>
	
	</div>
	<br /><br/><br/>
	<div id="rodape">	
		Subdiretoria de Abastecimento (ABTI - 2012)
	</div>
	
	</div>
</body>
</html>
