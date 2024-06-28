package urlsanduris;

import java.net.URL;

public class URLDemo {
	
	public static void demoURL(String myURL) {
		try {
			URL url = new URL(myURL);
			System.out.println("Protocol: " + url.getProtocol());
			System.out.println("Host: " + url.getHost());
			System.out.println("Default Port: " + url.getDefaultPort());
			System.out.println("Path: " + url.getPath());
			System.out.println("Query String: " + url.getQuery());
			System.out.println("Ref: " + url.getRef());
			System.out.println("User Info: " + url.getUserInfo());
			System.out.println("Content: " + url.getContent());
			System.out.println("Authority: " + url.getAuthority());
			System.out.println("File: " + url.getFile());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String googleUrl = "https://www.google.com/search?client=firefox-b-d&q=hello+world";
		demoURL(googleUrl);
	}

}
