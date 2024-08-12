package datagram;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EchoClient {
	
	//UDP port 
	public static final int SERVICE_PORT = 8087; 
	
	//Max size of the packet 
	public static final int BUFSIZE = 256; 
	

	public static void main(String[] args) {
		if(args.length != 1) {
			System.err.println("Syntax = java EchoClient hostname");
			return;
		}
		
		String hostname = args[0]; 
		
		//Get an InetAddress for the specified hostname 
		InetAddress addr = null; 
		try {
			//resolve the hostname to an InetAddress 
			addr = InetAddress.getByName(hostname); 
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return; 
		}
		
		try {
			//bind to any free port 
			DatagramSocket socket = new DatagramSocket();
			
			//set a timeout value of 2 seconds 
			socket.setSoTimeout(2000);
			for (int i = 1; i <= 10; i++) {
				//copy some data to our packet 
				String message = "Packet number " + i; 
				char[] cArray = message.toCharArray(); 
				byte[] sendbuf = new byte[cArray.length];
				
				for (int offset = 0; offset < cArray.length; offset++) {
					sendbuf[offset] = (byte) cArray[offset]; 
				}
				
				//create a packet to send to the UDP Server 
				DatagramPacket sendPacket = new DatagramPacket(sendbuf, cArray.length, addr, SERVICE_PORT);
				System.out.println("Sending packet to " + hostname);
				
				//Send the packet 
				socket.send(sendPacket);
				System.out.println("Waiting for packet .... ");
				
				//Create a small packet for receiving UDP packets 
				byte[] recbuf = new byte[BUFSIZE]; 
				DatagramPacket receivePacket = new DatagramPacket(recbuf, BUFSIZE); 
				
				//declare a timeout flag 
				boolean timeout = false; 
				
				//catch any InterruptedIOException that is thrown while waiting to receive a UDP packet 
				try {
					socket.receive(receivePacket);
				} catch (Exception e) {
					System.err.println(e.getMessage());
					timeout = true; 
				}
				
				if(!timeout) {
					System.out.println("Packet received!");
					System.out.println("Details: " + receivePacket.getAddress());
					
					//obtain a byte input stream to read the UDP packet 
					ByteArrayInputStream bin = new ByteArrayInputStream(receivePacket.getData(), 0, receivePacket.getLength());
					
					//connect a reader for easier access
					BufferedReader reader = new BufferedReader(new InputStreamReader(bin)); 
					
					//loop indefinitely 
					for(;;) {
						String line = reader.readLine(); 
						//check for the end of data 
						if(line == null) {
							break; 
						}else {
							System.out.println(line);
						}						
					} 
				}
				else {
					System.out.println("Packet lost!");
				}
				
				//Sleepfor a second, to allow user to see the packet 
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

}
