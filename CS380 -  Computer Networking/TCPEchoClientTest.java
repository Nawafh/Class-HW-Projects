import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
public class TCPEchoClientTest{

	static Socket socket;
	static byte[] data = new byte[128];
	static int    dataLength = 0;
	
	public static void main (String[] args) throws IOException {
		
		if((args.length < 1) || (args.length > 2)) 	//test for correct number of args
			throw new IllegalArgumentException("Parmeter(s): <Server> <Word> [<Port>]");
		
		String server = args[0];					// Server name or IP address
		// Convert argument String to bytes using the default character encoding
		
		int servPort = (args.length == 2) ? Integer.parseInt(args[1]) : 7;
		
		// Create socket that is connected to server on specified port
		socket = new Socket(server, servPort);
		
		System.out.println("Connected to server...sending echo string");
		
		InputStream in = socket.getInputStream();
							// Send the encoded string to the server
		
		while(true)
		{
			String tmp = getInputFromUser();
			
			if(tmp.equals("end of session"))
			{
				data = tmp.getBytes();                      // tell server we're done
				dataLength = tmp.length();
				sendMessage();
				socket.close();								// Close the socket and its streams
				System.out.println("Socket Closed");
				break;
			}
			else if(isValidInput(tmp))
			{
				sendMessage();
				dataLength = in.read(data);
				StringBuilder returned = new StringBuilder();
		    
				for(int i = 0; i < dataLength; ++i)
				{
					returned.append((char)data[i]);
				}
				System.out.println("Translated value is: " + returned);
			}
			else
			{
				System.out.println("Invalid data input");
			}
		}
	}
	
	public static void sendMessage() throws IOException
	{
		OutputStream out = socket.getOutputStream();

		out.write(data, 0, dataLength);
	}
	
	public static String getInputFromUser()
	{
		Scanner keyBoard = new Scanner(System.in);
		System.out.println("Please decode ");
		
		return (keyBoard.nextLine()).toString(); 
	}
	
	public static boolean  isValidInput(String a)
	{
		boolean retVal = true; //False if invalid.
		
		//Checking for the correct length.
		if (a.length() > 16)
		{
			retVal = false;
		}
		else
		{
			if (a.length() % 4 == 0)
			{
				retVal = true;
			}
			else
				retVal = false;
		}
	
		//Checking for 0's and 1's.
		for(dataLength = 0; dataLength < a.length(); ++dataLength)
		{
			char c = a.charAt(dataLength);
			
			if((c != '0') && (c != '1'))
			{
				retVal = false;
				break;
			}
			data[dataLength] = (byte)c;
		}
		return retVal;
	}
}