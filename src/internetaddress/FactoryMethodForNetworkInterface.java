package internetaddress;

import java.net.NetworkInterface;

public class FactoryMethodForNetworkInterface {
	
	public static void testNetworkInterface(String name) {
		try {
			NetworkInterface ni = NetworkInterface.getByName(name);
			
			if(ni == null) {
				System.out.println("No such interface");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		testNetworkInterface("eth0");
	}

}
