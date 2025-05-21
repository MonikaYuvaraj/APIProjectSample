package Day1;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class omrSample {

	public static void main(String[] args) throws IOException, ParseException {

		FileReader fi = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\sample.json");
		JSONParser jsonp = new JSONParser();
		Object ob = jsonp.parse(fi);

		JSONObject jobj = (JSONObject) ob;
		
		Object object = jobj.get("data");
		System.out.println(object);

		JSONObject jobj2 = (JSONObject) object;
		
		Object db = jobj2.get("id");
		long i = (long) db;
		System.out.println(i);
		
		Object ob2 = jobj2.get("flightName");
		String j1 = (String) ob2;
		System.out.println(j1);

		// JSONObject jobj3 = (JSONObject) object;
		Object ob3 = jobj2.get("Country");
		String j2 = (String) ob3;
		System.out.println(j2);

		Object ob4 = jobj2.get("Destinations");
		String j3 = (String) ob4;
		System.out.println(j3);

		Object ob5 = jobj2.get("URL");
		String j4 = (String) ob5;
		System.out.println(j4);
		
		Object ob7 = jobj2.get("Created_Date");
		String j6 = (String) ob7;
		System.out.println(j6);
		
		Object ob8 = jobj2.get("Updated_Date");
		String j7 = (String) ob8;
		System.out.println(j7);
		
		
		// JSONObject jobj3 = (JSONObject) object2;
		Object object2 = jobj.get("support");
		System.out.println(object2);

		JSONObject jobj3 = (JSONObject) object2;

		Object ob9 = jobj3.get("url");
		String j8 = (String) ob9;
		System.out.println(j8);

		Object ob10 = jobj3.get("text");
		String j9 = (String) ob10;
		System.out.println(j9);
		
	}

}
