package gw;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 */
public class ClientSoap {

	private String ip = "127.0.0.1";	
	private int port = 8010; //TCP_EX01
	private String requestStr = "00025TCP02777777777788888";
	private int bufferSize = 35; 
	
	public ClientSoap(){}
	
	public ClientSoap(String ip, int port)
	{
		this.ip = ip;
		this.port = port;
	}
	
	public boolean isLive()
	{
		Socket socket = null;
		
		try
		{
			socket = new Socket(ip, port);
			
			System.out.println(socket);
			OutputStream out = socket.getOutputStream();
			DataInputStream in = new DataInputStream(socket.getInputStream());
			byte[] msg = requestStr.getBytes();
			out.write(msg);
			out.flush();
			
			
			System.out.println("[client] send request: " + requestStr);
			
			int len = -1;
			
			byte[] getData = new byte[bufferSize];
			String receviedStr ="";
			
			len = in.read(getData, 0, bufferSize);
			
			receviedStr = receviedStr + new String(getData);
			
			System.out.println("[client] len="+len);
			System.out.println("[client] receviedStr:" + receviedStr);
			
			socket.close();
			
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("=== server is not start!! start local server====");
			return false;
		}
		finally
		{ 
			if(socket != null)
			{
				try {	socket.close();	} catch (IOException e) {	e.printStackTrace();	}
			}
		}
	}
	
	public static void main(String[] args)
	{
		try 
		{
			boolean isLive = new ClientSoap().isLive();
			System.out.println("servier isLive=>"+isLive);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

