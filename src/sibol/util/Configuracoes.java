package sibol.util;

import java.io.FileInputStream;
import java.util.Properties;


public class Configuracoes 
{
	String chave;
	String diretorio="config.xml";
	
	public String getConfig(String chave)
	{
	   this.chave = chave;
	   Properties sites = new Properties();
	   try 
	   {
		   sites.loadFromXML(new FileInputStream(diretorio));
	   } 
	   catch (Exception e)
	   {
		   e.printStackTrace();
	   }
	   return (String)sites.getProperty(this.chave);
	}
}
