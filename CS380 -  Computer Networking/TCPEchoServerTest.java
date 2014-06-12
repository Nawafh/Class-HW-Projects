import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;									// for Socket, ServerSocket, and InetAddress
public class TCPEchoServerTest {

	private static final int BUFSIZE = 32;			// Size of receive buffer
	private static Decoder deCrypt;
	public static void main(String[] args) throws IOException {
	
		deCrypt = new Decoder();
		if (args.length != 1)						// Test for correct number of args
			throw new IllegalArgumentException("Parameter(s): <Port>");
			
		int servPort = Integer.parseInt(args[0]);
		
		//create a server socket to accept client connection requests
		ServerSocket servSock = new ServerSocket(servPort);
		
		int recvMsgSize;							//  Size of received message
		byte[] receiveBuf = new byte[BUFSIZE];		// Receive buffer
		
		while(true){								// Run forever, accepting and servicing connections
			Socket clntSock = servSock.accept();	// Get client connection
			
			SocketAddress clientAddress = clntSock.getRemoteSocketAddress();
			System.out.println("handling client at " + clientAddress);
			
			InputStream in = clntSock.getInputStream();
			OutputStream out = clntSock.getOutputStream();

			// Receive until client closes connection, indicated by -1 return
			while ((recvMsgSize = in.read(receiveBuf)) != -1)
			{
				String translated;
				
				try {
					translated = deCrypt.convert4Bto5B(receiveBuf, recvMsgSize);
				}
				catch(InvalidException ie)
				{
					if(ie.badString().equals("end of session"))
					{
						break;
					}
					System.out.println("Invalid buffer received: " + ie.badString());
					System.out.println("                         " + ie.pointToBadChar());
					translated = "Invalid submission - rejected";
				}
				out.write(translated.getBytes(), 0, translated.length());
			}
			clntSock.close();						// close the socket. We are done with this client!
		}
		/* NOT REACHED */
	}
}