package sibol;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessaoServlet implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent httpSession) {
		try {
			Log.gravar("Cria��o da Sess�o: "+ (new Date()).toString());
			Log.gravar("Id da Sess�o: "+ httpSession.getSession().getId());
			Log.gravar("�ltimo acesso: "+ httpSession.getSession().getLastAccessedTime());
			Log.gravar("M�ximo de Tempo Inativo: "+ httpSession.getSession().getMaxInactiveInterval());
			Log.gravar("Quantidade de usu�rios usuando: "+ ++InicioServletConfig.ct);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSession) {
		try {
			Log.gravar("Destrui��o da Sess�o: "+ (new Date()).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		
	}

}
