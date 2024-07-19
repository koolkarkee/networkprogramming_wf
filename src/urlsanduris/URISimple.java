package urlsanduris;

import java.net.URI;

public class URISimple {
	public static void display(URI uri) { 
		try {
			System.out.println("Host: " + uri.getHost()); 
			System.out.println("Path: " + uri.getPath());
			System.out.println("Query String: " + uri.getQuery()); 
			System.out.println("User Info: " + uri.getUserInfo());
			System.out.println("Authority: " + uri.getAuthority());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		try {
			URI voice = new URI("tel:+9779849112233");
			display(voice);
			
			System.out.println("---------------------");
			
			URI web = new URI("http://www.xml.com/pub/a/2003/09/17/stax.html#id=_hbc");
			display(web);
			
			System.out.println("---------------------");

			//URI tutorial = new URI("urn:");
			//display(tutorial);
			
			System.out.println("---------------------");
			URI absolute = new URI("http", "//www.ibiblio.org", null); 
			display(absolute); 
			
			System.out.println("---------------------");
			URI relative = new URI(null, "/javafaq/index.shtml", "today"); 
			display(relative);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
