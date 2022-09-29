package es.mmm.psp_ud1;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class tr22 
{
	private static final String HOST = "localhost";
	public static void main (String [] Args)
	{
		Socket socketServidor        = null;
		DataInputStream flujoEntrada = null;
		try
		{
			 socketServidor = new Socket(HOST, tr21.PORT);
			 flujoEntrada   = new DataInputStream(socketServidor.getInputStream());
			 System.out.println(flujoEntrada.readUTF());
		}
		catch(UnknownHostException unknowHostException)
		{
			unknowHostException.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				flujoEntrada.close();
			} catch (IOException ioException) {
				// TODO Auto-generated catch block
				ioException.printStackTrace();
			}
			try 
			{
				socketServidor.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}
