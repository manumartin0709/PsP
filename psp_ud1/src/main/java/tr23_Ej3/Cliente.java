package tr23_Ej3;

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Cliente
{
	private static final String HOST = "localhost";
	public static void main (String [] Args)
	{
		Socket socketServidor        = null;
		DataInputStream flujoEntrada = null;
		DataOutputStream flujoSalida = null;
		DataOutputStream flujoSalida_2 = null;
		
		
		
		try
		{
			 String fecha_1           = "2020-11-09";
			 String fecha_2           = "2019-03-17";
			 String fecha_3           = " ";
			 
			 socketServidor = new Socket(HOST, Servidor.PORT);
			 flujoEntrada   = new DataInputStream(socketServidor.getInputStream());
			 flujoSalida    = new DataOutputStream(socketServidor.getOutputStream());
			 flujoSalida_2  = new DataOutputStream(socketServidor.getOutputStream());
			 flujoSalida.writeUTF(fecha_1);
			 flujoSalida_2.writeUTF(fecha_2);
			 fecha_3        = flujoEntrada.readUTF();
			 System.out.println("La fecha mas antigua es "+fecha_3);
			 
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
				
				ioException.printStackTrace();
			}

			try {
				flujoSalida_2.close();
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
