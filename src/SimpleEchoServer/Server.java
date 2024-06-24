package SimpleEchoServer;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try(ServerSocket serverSocket = new ServerSocket(5344)) {
			System.out.println(">>Waiting for connection ... ");
			
			//establish connection 
			Socket clientSocket = serverSocket.accept();
			System.out.println(">>Connected to client");
			
			DataInputStream d = new DataInputStream(clientSocket.getInputStream());
			String str = (String)d.readUTF();
			System.out.println(">>Message: "+str); 
			serverSocket.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
