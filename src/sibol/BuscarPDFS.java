package sibol;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;


public class BuscarPDFS {

	
	public static File[]  procurarPDF(String valor) throws IOException
	{
		Log.gravar("class: BuscarPDFS: method: procurarPDF: inicio");
		Log.gravar("****** A palavra usada para busca é: " + valor);
	    final Set<File> list = new HashSet<File>();
        File f = new File("C:" + File.separator + "Boletins");
		File array[] = f.listFiles();
		for (int i = 0; i < array.length; i++) {				
		     File array2[] = array[i].listFiles();
		     for (int j = 0; j < array2.length; j++) {
		    	 File array3[] = array2[j].listFiles();
		    	 for (int k = 0; k < array3.length; k++) 
		    	 {
				         String path = array3[k].getName();				         
				         PdfReader reader = null;
				         if(path.endsWith(".pdf"))
				         {
				        	 try
				        	 {
				        		 reader = new PdfReader(array3[k].getAbsolutePath());				        		 
				        	 }
				        	 catch(Exception e)
				        	 {
				        		 //System.out.println(path);
				        		 e.printStackTrace();
				        		 Log.gravar("****** bugou: " + path );

				        	 }
				        	
		    		        int w=1;
				            int n = reader.getNumberOfPages();
				            while( w <= n)
				            {				            	
				            	     String str= PdfTextExtractor.getTextFromPage(reader, w); 
				                     Pattern pattern = Pattern.compile(valor.toLowerCase());
						             Matcher matcher = pattern.matcher(str.toLowerCase());
						                 if(matcher.find())
						                 {		
							                  list.add(array3[k]);
							             }
						             w++;
				            	
				            }
				        	 
				         }
				 }
		    	
			 }	
	     }
		 ArrayList<File> lista = new ArrayList<File>(list);
		 Collections.sort(lista);
		 File []arrayFiles = new File[lista.size()];
		 int i=0;
		 Iterator<File> fileIterator = lista.iterator();
		 while(fileIterator.hasNext()){
			 arrayFiles[i]=fileIterator.next();
			 i++;
		 }
		 Log.gravar("class: BuscarPDFS: method: procurarPDF: fim");
		 return arrayFiles;
   }
	
}
