import java.util.*;
import java.io.*;
import java.net.*;

class GetRequest {
	public static void main (String[] args) {
		System.setProperty("http.agent", "Chrome");
		try {
			URL url = new URL("https://api.coinbase.com/v2/currencies");
			try {
				URLConnection connection = url.openConnection();
				InputStream inputStream = connection.getInputStream();
				try{
					Scanner scanner = new Scanner(inputStream);
					String body = scanner.useDelimiter("$").next();
					System.out.println(body);
//					String data = body.split(":")[3];
//					String[] values = data.split(", ");
//					int result = 0;
//					for(int i = 1; i<values.length; i+=2){
//						String currentValue = values[i];
//						Integer age = Integer.parseInt(currentValue.split("=")[1]);
//						if(age >= 50){
//							result++;
//						}
//					}
//					System.out.println(result);
				} catch(Exception e){
				}
				System.out.println(inputStream);
			} catch (IOException ioEx) {
				System.out.println(ioEx);
			}
		} catch (MalformedURLException malEx) {
			System.out.println(malEx);
		}
	}
}