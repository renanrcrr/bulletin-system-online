package sibol;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessaoServlet implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent httpSession) {
		try {
			Log.gravar("Criação da Sessão: "+ (new Date()).toString());
			Log.gravar("Id da Sessão: "+ httpSession.getSession().getId());
			Log.gravar("último acesso: "+ httpSession.getSession().getLastAccessedTime());
			Log.gravar("Máximo de Tempo Inativo: "+ httpSession.getSession().getMaxInactiveInterval());
			Log.gravar("Quantidade de usuários usuando: "+ ++InicioServletConfig.ct);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSession) {
		try {
			Log.gravar("Destruição da Sessão: "+ (new Date()).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		
	}

}
