package es.mmm.psp_ud1;

import java.io.IOException;
import java.net.ServerSocket;

public class tr20 
{
	public static void main (String [] args) 
	{
		ServerSocket server = null;
		try
		{
			server = new ServerSocket (0);
			System.out.println("Server started" +server);
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(server != null)
			{
				try 
				{
				server.close();
				}
				catch (IOException ioException)
				{
					ioException.printStackTrace();
				}

			}
		}
	}

}
