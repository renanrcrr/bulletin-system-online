package sibol;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



public class InicioServletConfig implements ServletContextListener{

	static int ct=0;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		 try {
				Log.gravar("Fim da Aplicação "+ new Date().toString());
			} catch (IOException e) {
				
			    e.printStackTrace();
			}
		
	}

	@Override
	public void contextInitialized(ServletContextEvent  ct) {
	    try {
			Log.gravar("Inicio da Aplicação "+ new Date().toString());
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	
}