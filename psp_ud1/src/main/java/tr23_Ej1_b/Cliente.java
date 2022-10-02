package tr23_Ej1_b;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	private static final String HOST = "localhost";
	public static void main (String [] Args)
	{
		Socket socketServidor        = null;
		DataInputStream flujoEntrada = null;
		DataOutputStream flujoSalida = null;
		
		try
		{
			 int numero = 7;
			 int resultado = 0;
			 socketServidor = new Socket(HOST, Servidor.PORT);
			 flujoEntrada   = new DataInputStream(socketServidor.getInputStream());
			
			 flujoSalida    = new DataOutputStream(socketServidor.getOutputStream());
			 flujoSalida.writeInt(numero);
			 resultado = flujoEntrada.readInt();
			 System.out.println("El cuadrado de "+numero+" es "+resultado);
			 
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
			try {
				flujoSalida.close();
			} catch (IOException c) {
				c.printStackTrace(); 
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
