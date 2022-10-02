package tr23_Ej1_a;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;



public class Cliente {
	private static final String HOST = "localhost";
	public static void main (String [] Args)
	{
		Socket socketServidor        = null;
		DataOutputStream flujoSalida = null;
		
		try
		{
			 int numero = 7;
			 socketServidor = new Socket(HOST, Servidor.PORT);
			 flujoSalida    = new DataOutputStream(socketServidor.getOutputStream());
			 flujoSalida.writeInt(numero);
			 
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
