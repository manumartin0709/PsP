package tr23_Ej2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	protected static final int PORT = 2000;
	public static void main (String [] Args)
	{
		ServerSocket socketServidor       = null;
		Socket socketCliente              = null;
		DataOutputStream dataOutputStream = null;
		DataInputStream dataInputStream   = null;
		DataInputStream dataInputStream_2 = null;
		DataInputStream dataInputStream_3 = null;
		try
		{
			double numero_entrada = 0;
			double numero_entrada_2 = 0;
			char operacion = ' ';
			double resultado=0.0;
			//arranca un servidor en local
			socketServidor = new ServerSocket(PORT);
			//pediente de aceptar una conexcion del cliente y almacena la conexion
			 socketCliente = socketServidor.accept();
			 dataInputStream = new DataInputStream(socketCliente.getInputStream());
			 dataInputStream_2 = new DataInputStream(socketCliente.getInputStream());
			 dataInputStream_3 = new DataInputStream(socketCliente.getInputStream());
			//se le manda este mensaje en texto
			dataOutputStream = new DataOutputStream(socketCliente.getOutputStream());
			//leemos los datos me envia el cliente
			numero_entrada = dataInputStream.readDouble();
			numero_entrada_2 = dataInputStream_2.readDouble();
			operacion = dataInputStream_3.readChar();
			
			if(operacion == '+') {
				resultado = (numero_entrada + numero_entrada_2);
			}else if(operacion == '-') {
				resultado = (numero_entrada - numero_entrada_2);
			}else if(operacion == '*') {
				resultado = (numero_entrada * numero_entrada_2);
			}else if(operacion == '/'){
				resultado = (numero_entrada / numero_entrada_2);
			}
			
			dataOutputStream.writeDouble(resultado);
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
