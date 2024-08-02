package clientsocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.concurrent.TimeoutException;

public class DictClient {
	public static final String SERVER = "dict.org";
	public static final int PORT = 2628; 
	public static final int TIMEOUT = 10000; 
	
	static void define(String word, Writer writer, BufferedReader reader) 
		throws IOException, UnsupportedEncodingException{
		
			writer.write("DEFINE eng-lat " + word + "\r\n");
			writer.flush();
			
			for(String line = reader.readLine(); line != null; line = reader.readLine()) {
				if(line.startsWith("250 ")) { //ok
					return; 
				}
				else if(line.startsWith("252 ")) { //no match
					System.out.println("No definition found for " + word);
				}
				else if(line.matches("\\d\\d\\d .*")) {
					continue;
				}
				else if(line.trim().equals(".")) {
					continue;
				}
				else {
					System.out.println(line);
				}
			}
	}
	
	public static void main(String[] args) {
		Socket socket = null; 
		try {
			socket = new Socket(SERVER, PORT);
			socket.setSoTimeout(TIMEOUT);
			
			OutputStream out = socket.getOutputStream(); 
			Writer writer = new OutputStreamWriter(out, "UTF-8");
			writer = new BufferedWriter(writer); 
			
			InputStream in = socket.getInputStream(); 
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			
//			for(String word: args) {
//				define(word, writer, reader); 
//			}
			
			define("gold", writer, reader); 
			
			writer.write("quit\r\n");
			writer.flush();
			
		} 
		catch(SocketTimeoutException te) {
			System.err.println("Timeout exception: " + te.getMessage());
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			if(socket != null) {
				try {
					socket.close();
				} catch (Exception e2) {
					
				}
			}
		}
	}
	
	
}
