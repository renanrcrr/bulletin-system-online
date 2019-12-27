package sibol;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RetornaPDF 
{
	 byte[] arquivo;  
	 
	 public File retornaFile(String path)
	 {
		    //File f = new File("C://Boletins");
		    File f = new File("/home/renanrcrr/Boletins");
			File array[] = f.listFiles();
			for (int i = 0; i < array.length; i++) {				
			     File array2[] = array[i].listFiles();
			     for (int j = 0; j < array2.length; j++) {
			    	 File array3[] = array2[j].listFiles();
			    	 for (int k = 0; k < array3.length; k++) {
					     if(array3[k].getName().equals(path)){
					    	 return new File(array3[k].getAbsolutePath());
					     }
			    		 
					 }
				 }
			 }
		 
		 return null;
	 }
	 
	public void retornarPDF(File file,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		try {  
          arquivo = fileToByte(file);  
       }catch (Exception e) {  
          e.printStackTrace();  
       }  
	   
	   response.setContentType("application/pdf");  
       response.setContentLength(arquivo.length);  
       ServletOutputStream ouputStream = response.getOutputStream();  
       
       ouputStream.write(arquivo, 0, arquivo.length);  
       ouputStream.flush();  
       ouputStream.close();	
	}
	public static InputStream byteToInputStream(byte[] bytes) throws Exception {  
       ByteArrayInputStream bais = new ByteArrayInputStream(bytes);  
       return bais;  
   }  
 
   public static byte[] fileToByte(File imagem) throws Exception {  
       FileInputStream fis = new FileInputStream(imagem);  
       ByteArrayOutputStream baos = new ByteArrayOutputStream();  
       byte[] buffer = new byte[8192];  
       int bytesRead = 0;  
       while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {  
           baos.write(buffer, 0, bytesRead);  
       }  
       return baos.toByteArray();  
   }  
	
	

}
