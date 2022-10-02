package tr23_Ej3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Servidor {
	protected static final int PORT = 2000;
	public static void main (String [] Args)
	{
		ServerSocket socketServidor       = null;
		Socket socketCliente              = null;
		DataOutputStream dataOutputStream = null;
		DataInputStream dataInputStream   = null;
		DataInputStream dataInputStream_2 = null;
		
		try
		{
			 String fecha_1           = " ";
			 String fecha_2           = " ";
		
			 
				
			//arranca un servidor en local
			socketServidor = new ServerSocket(PORT);
			//pediente de aceptar una conexcion del cliente y almacena la conexion
			 socketCliente = socketServidor.accept();
			 dataInputStream = new DataInputStream(socketCliente.getInputStream());
			 dataInputStream_2 = new DataInputStream(socketCliente.getInputStream());
			//se le manda este mensaje en texto
			dataOutputStream = new DataOutputStream(socketCliente.getOutputStream());
			//leemos los datos me envia el cliente
			fecha_1 = dataInputStream.readUTF();
			fecha_2 = dataInputStream_2.readUTF();
			try {
			SimpleDateFormat format  = new SimpleDateFormat ("YYYY-MM-DD");
			 Date fecha_f1            = format.parse(fecha_1);
	         Date fecha_f2            = format.parse(fecha_2);
	         
	         if(fecha_f1.equals(fecha_f2)) {
	        	 
	        	 System.out.println("Las fechas son iguales");
	         }
	         
	         if(fecha_f1.after(fecha_f2))
	         {
	        	 
	        	
	        	 dataOutputStream.writeUTF(fecha_2);
	        	    
	          }else if(fecha_f1.before(fecha_f2))
	          {
	        	  
	        	  dataOutputStream.writeUTF(fecha_1);
	        	    
	          }
			}
			catch(java.text.ParseException e) {
				e.printStackTrace();
			}
			
			
			
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
