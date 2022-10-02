package tr23_Ej1_a;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	protected static final int PORT = 2000;
	public static void main (String [] Args)
	{
		ServerSocket socketServidor = null;
		Socket socketCliente = null;
		DataOutputStream dataOutputStream = null;
		DataInputStream dataInputStream = null;
		try
		{
			int numero_entrada = 0;
			int cuadrado = 0;
			//arranca un servidor en local
			socketServidor = new ServerSocket(PORT);
			//pediente de aceptar una conexcion del cliente y almacena la conexion
			 socketCliente = socketServidor.accept();
			 dataInputStream = new DataInputStream(socketCliente.getInputStream());
			//se le manda este mensaje en texto
			dataOutputStream = new DataOutputStream(socketCliente.getOutputStream());
			//leemos el numero que me envia el cliente
			numero_entrada = dataInputStream.readInt();
			cuadrado = (numero_entrada * numero_entrada);
			
			dataOutputStream.writeInt(cuadrado);
			System.out.println("El cuadrado de " +numero_entrada+" es "+cuadrado);
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
