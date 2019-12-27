package sibol;


import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RetornaFilesServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getParameter("cmd");
		if(path.endsWith(".pdf"))
		{	  	
		      RetornaPDF retornarPDF = new RetornaPDF();
	          retornarPDF.retornarPDF(new File(path),request, response);		
		}
		else
		{
			 File f= new File(path);
			 request.setAttribute("ARRAY_FILE", f.listFiles());
			 RequestDispatcher rd = request.getRequestDispatcher("index.jsp");  
			 rd.forward(request, response);
		}   	
	}
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  final String nome = request.getParameter("nome");
	      final String saram = request.getParameter("saram");
	      if(nome!=null)
	      {
	    	  request.setAttribute("ARRAY_FILE",BuscarPDFS.procurarPDF(nome));
	      }
	      else
	      {
	    	  request.setAttribute("ARRAY_FILE",BuscarPDFS.procurarPDF(saram));
	      }
	      	     
		 RequestDispatcher rd = request.getRequestDispatcher("index.jsp");  
		 rd.forward(request, response);     
	      
	}



	

}
