package internetaddress;
import java.net.*;

public class InternetAddressByName {
	
	public static void printIp(String hostname) {
		try {
			InetAddress address = InetAddress.getByName(hostname);
			System.out.println(address);
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public static void printHostName(){
		try {
			InetAddress machine = InetAddress.getLocalHost();
			System.out.println(machine);
			System.out.println(machine.getLocalHost());
			System.out.println(machine.getCanonicalHostName());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static int findVersion(InetAddress ia) {
		try {
			byte[] address = ia.getAddress();
			if(address.length == 4) {
				return 4;
			}else if(address.length == 16) {
				return 6;
			}else {
				return -1;
			}
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return -1;
	}
	
	public static void printVersion(String hostname) {
		try {
			InetAddress ia = InetAddress.getByName(hostname);
			System.out.println(findVersion(ia));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		//main program
		System.out.println("------------------- IP --------------------");
		printIp("www.github.com");
		printIp("localhost");
		printIp("www.bibekkarki.com");
		
		System.out.println("\n----------------- HostName -----------------");
		printHostName();
		
		System.out.println("\n----------------- IP version ---------------");
		printVersion("localhost");
		printVersion("2001:0000:130F:0000:0000:09C0:876A:130B");
		
	}

}
