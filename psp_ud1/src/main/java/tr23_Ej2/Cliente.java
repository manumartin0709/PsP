package tr23_Ej2;

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
		DataOutputStream flujoSalida_2 = null;
		DataOutputStream flujoSalida_3 = null;
		
		
		try
		{
			 double numero_1 = 7.0;
			 double numero_2 = 3.0;
			 char operacion = '*';
			 socketServidor = new Socket(HOST, Servidor.PORT);
			 flujoEntrada   = new DataInputStream(socketServidor.getInputStream());
			 flujoSalida    = new DataOutputStream(socketServidor.getOutputStream());
			 flujoSalida_2  = new DataOutputStream(socketServidor.getOutputStream());
			 flujoSalida_3  = new DataOutputStream(socketServidor.getOutputStream());
			 flujoSalida.writeDouble(numero_1);
			 flujoSalida_2.writeDouble(numero_2);
			 flujoSalida_3.writeChar(operacion);
			 double resultado   = flujoEntrada.readDouble();
			 System.out.println("El resuldato de la operacion es: "+resultado);
			 
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
			
			try {
				flujoSalida_3.close();
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
