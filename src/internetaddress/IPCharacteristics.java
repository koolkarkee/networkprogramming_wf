package internetaddress;

import java.net.InetAddress;

public class IPCharacteristics {
	
	public static void testAnyLocalAddress(String name) {
		try {
			InetAddress address = InetAddress.getByName(name);
			if(address.isAnyLocalAddress()) {
				System.out.println(address + " is a wildcard address.");
			}
			else {
				System.out.println(address + " is not a wildcard address.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void testLoopbackAddress(String name) {
		try {
			InetAddress address = InetAddress.getByName(name);
			if(address.isLoopbackAddress()) {
				System.out.println(address + " is a loop back address.");
			}
			else {
				System.out.println(address + " is not a loop back address.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void testIsLinkLocalAddress(String name) {
		try {
			InetAddress address = InetAddress.getByName(name);
			if(address.isLinkLocalAddress()) {
				System.out.println(address + " is a link local address.");
			}
			else {
				System.out.println(address + " is not a link local address.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void testIsSiteLocalAddress(String name) {
		try {
			InetAddress address = InetAddress.getByName(name);
			if(address.isSiteLocalAddress()) {
				System.out.println(address + " is a site local address.");
			}
			else {
				System.out.println(address + " is not a site local address.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void testIsMulticastAddress(String name) {
		try {
			InetAddress address = InetAddress.getByName(name);
			if(address.isMulticastAddress()) {
				System.out.println(address + " is a multi-cast address.");
				
				if(address.isMCGlobal()) {
					System.out.println(address + " is a global multi-cast address.");
				}
				
				if(address.isMCOrgLocal()) {
					System.out.println(address + " is an organization wide multi-cast address.");
				}
			}
			else {
				System.out.println(address + " is not a multi-cast address.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void testReacability(String name, int timeout) {
		try {
			InetAddress address = InetAddress.getByName(name);
			if(address.isReachable(timeout)) {
				System.out.println(address + " is reachable.");
			}
			else {
				System.out.println(address + " is not reachable.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public static void main(String[] args) {
		String first_address = "127.0.0.1";
		String second_address = "0.0.0.0";
		String third_address = "192.168.0.0";
		
		testAnyLocalAddress(first_address);
		testAnyLocalAddress(second_address);
		testAnyLocalAddress(third_address);
		
		System.out.println();
		
		testLoopbackAddress(first_address);
		testLoopbackAddress(second_address);
		testLoopbackAddress(third_address);

		System.out.println();
		
		testIsLinkLocalAddress(first_address);
		testIsLinkLocalAddress(second_address);
		testIsLinkLocalAddress(third_address);

		System.out.println();
		
		testIsSiteLocalAddress(first_address);
		testIsSiteLocalAddress(second_address);
		testIsSiteLocalAddress(third_address);
		
		System.out.println();
		
		testIsMulticastAddress(first_address);
		testIsMulticastAddress(second_address);
		testIsMulticastAddress("224.0.0.1");
		testIsMulticastAddress("224.0.2.1");
		testIsMulticastAddress("ff05:0:0:0:0:0:0:101");
		
		System.out.println();
		testReacability("facebook.com", 30);
		testReacability("facebook.com", 180);
		testReacability("hamropatro.com", 30);

	}

}
