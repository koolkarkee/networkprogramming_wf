package urlsanduris;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;

public class URLencode {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(URLEncoder.encode("This string has spaces", "UTF-8"));
			System.out.println(URLEncoder.encode("This *string*has*asterisks", "UTF-8"));
			System.out.println(URLEncoder.encode("This%string%has%percent%signs", "UTF-8"));
			System.out.println(URLEncoder.encode("This+string+has+pluses", "UTF-8"));
			System.out.println(URLEncoder.encode("This+/tring/has/slashes", "UTF-8"));
			System.out.println(URLEncoder.encode("This\"string\"has\"quote\"marks", "UTF-8"));
			System.out.println(URLEncoder.encode("This:string:has:colons", "UTF-8"));
			System.out.println(URLEncoder.encode("This~string~has~tildes", "UTF-8"));
			System.out.println(URLEncoder.encode("This(string)has(parentheses)", "UTF-8"));
			System.out.println(URLEncoder.encode("This.string.has.periods", "UTF-8"));
			System.out.println(URLEncoder.encode("This=string=has=equals=sign", "UTF-8"));
			System.out.println(URLEncoder.encode("This&string&has&ampersands", "UTF-8"));
//			
			System.out.println(URLEncoder.encode("This आफ्नो मान्छे spaces", "UTF-32"));

		}
		catch(UnsupportedEncodingException ex){
			throw new RuntimeException("Broken VM does not support UTF-8");
		}
	}

}
