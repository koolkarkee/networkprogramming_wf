package datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class EchoServer {
	
	//UDP port
	public static final int SERVICE_PORT = 8087; 
	
	//max size of packet 
	public static final int BUFSIZE = 4096;
	
	//socket used for reading and writing UDP packets 
	private DatagramSocket socket;
	
	public EchoServer() {
		try {
			//bind to the specified UDP port, to listen 
			socket = new DatagramSocket(SERVICE_PORT);
			System.out.println("Server active on port " + socket.getLocalPort());
			
		} catch (Exception e) {
			System.err.println("Unable to bind the port");
		}
	}
	
	public void serviceClients() {
		//create a buffer large enough for incoming packets 
		byte[] buffer = new byte[BUFSIZE]; 
		
		for(;;) {
			try {
				//create a datagram packet for reading 
				//UDP packets 
				DatagramPacket packet = new DatagramPacket(buffer, BUFSIZE);
				
				//receive incoming packets 
				this.socket.receive(packet);
				
				System.out.println("Packet received from " + packet.getAddress() + " " + packet.getPort() + " " + "of length " + packet.getLength());
				
				//echo the packet back 
				socket.send(packet);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		EchoServer server = new EchoServer();
		server.serviceClients();

	}

}
