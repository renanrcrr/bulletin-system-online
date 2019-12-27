package sibol;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sibol.util.Configuracoes;

public class Controlador extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	String action;

	String url;   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		@SuppressWarnings("unused")
		HttpSession session;
		session = request.getSession();
		action = request.getParameter("action");
		
		if (action.equals("index")) 
		{
			Configuracoes diretorio = new Configuracoes();
			url = diretorio.getConfig("index");
			response.sendRedirect(url);
		}
	}

}
