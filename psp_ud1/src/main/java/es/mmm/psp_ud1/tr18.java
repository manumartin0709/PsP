package es.mmm.psp_ud1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class tr18 
{
	public static void main(String[] args) 
	{
		tr18 transparencia18 = new tr18();
		try
		{
			System.out.println(transparencia18.returnContentString(new URL("http://www.iesjandula.es/drupal")));
			transparencia18.returnContentFile(new URL("http://www.iesjandula.es/drupal"));
		}
		catch (MalformedURLException malformedUrlException)
		{
			malformedUrlException.printStackTrace();
		}
		URL url = null;
		URLConnection urlcon = null;
		InputStream stream = null;
		try
		{
			url = new URL ("htpps://www.marca.es");
			urlcon = url.openConnection();
			stream = urlcon.getInputStream();
			int i;
	        while ((i = stream.read()) != -1)
	        {
	        	System.out.print((char)i);
	        }
		} catch (Exception e)
		{
			System.out.println(e);
		}
		
		
	}
		
		
	
	public String returnContentString(URL url)
	{	
		
		String outcome = "";
		InputStreamReader inputStreamReader = null;
		BufferedReader in = null;
		try
		{
			inputStreamReader = new InputStreamReader(url.openStream());
			in = new BufferedReader(inputStreamReader);
			
			String inputLine = in.readLine();//para leer la primera linea de la pagina web
			while(inputLine != null)
			{
				outcome = outcome + inputLine;
				inputLine = in.readLine();
			}
		}
		catch(IOException ioException)
		{
			ioException.printStackTrace();
		}
		finally
		{
				if(in != null) 
				{
					try
					{
						in.close();
					}
					catch (IOException ioException)
					{
						ioException.printStackTrace();
					}
				}
				if( inputStreamReader != null )
				{
					try
					{
						inputStreamReader.close();
					}
					catch (IOException ioException)
					{
						ioException.printStackTrace();
					}
				}
		}
		
		return outcome;
		
	}
	
	public void returnContentFile(URL url) 
	{
		File file = new File ("index.html");
		PrintWriter printWriter = null;
		
		InputStreamReader inputStreamReader = null;
		BufferedReader in = null;
		try
		{
			printWriter = new PrintWriter(file);
			inputStreamReader = new InputStreamReader(url.openStream());
			in = new BufferedReader(inputStreamReader);
			
			String inputLine = in.readLine();//para leer la primera linea de la pagina web
			while(inputLine != null)
			{
				printWriter.println(inputLine);
				inputLine = in.readLine();
			}
		}
		catch(IOException ioException)
		{
			ioException.printStackTrace();
		}
		finally
		{
			if(in != null) 
			{
				try
				{
					in.close();
				}
				catch (IOException ioException)
				{
					ioException.printStackTrace();
				}
			}
			if( inputStreamReader != null )
			{
				try
				{
					inputStreamReader.close();
				}
				catch (IOException ioException)
				{
					ioException.printStackTrace();
				}
			}
			if(printWriter != null)
			{
				printWriter.close();
			}
		}
		
	}
	
	
	
}
