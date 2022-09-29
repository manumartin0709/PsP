package es.mmm.psp_ud1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class tr21 
{
	protected static final int PORT = 2000;
	public static void main (String [] Args)
	{
		ServerSocket socketServidor = null;
		Socket socketCliente = null;
		DataOutputStream dataOutputStream = null;
		try
		{
			//arranca un servidor en local
			socketServidor = new ServerSocket(PORT);
			//pediente de aceptar una conexcion del cliente y almacena la conexion
			 socketCliente = socketServidor.accept();
			//se le manda este mensaje en texto
			dataOutputStream = new DataOutputStream(socketCliente.getOutputStream());
			
			dataOutputStream.writeUTF("Hola Oscar, ¡conexión recibida!");
			socketCliente.close();
			socketServidor.close();
			
		
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if(dataOutputStream != null)
			{
				try 
				{
					socketServidor.close();
					
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
				
			}
			if(socketServidor != null)
			{
				try 
				{
					socketCliente.close();
					
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
