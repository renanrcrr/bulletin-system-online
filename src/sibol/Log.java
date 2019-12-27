package sibol;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public final class Log {

	
	
static BufferedWriter br;  
	
	static
	{
		try 
		{
			br = new BufferedWriter (new FileWriter (new File(System.getProperty("user.home")+File.separator+"logSibol.txt"),true));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Problemas para gravar nesse caminho: "+System.getProperty("user.home")+File.separator+"logSibol.txt\n Descrição erro:"+e.getMessage());
			e.printStackTrace();
		}
	}  
	public final static void gravar(String log) throws IOException{
		
	      br.append("\r\n");		
	      br.append(log);
	  	  br.flush();
	}

}
