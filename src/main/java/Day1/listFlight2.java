package Day1;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class listFlight2 {

	public static void main(String[] args) throws IOException, ParseException {
		FileReader fi = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\listfl2.json");
		JSONParser jsonp = new JSONParser();
		Object ob = jsonp.parse(fi);

		JSONObject jobj = (JSONObject) ob;
		System.out.println(jobj);
		System.out.println();

		Object object = jobj.get("page");
		long i1 = (long) object;
		System.out.println(i1);
		Object object1 = jobj.get("per_page");
		long i2 = (long) object1;
		System.out.println(i2);
		Object object2 = jobj.get("total");
		long i3 = (long) object2;
		System.out.println(i3);
		Object object3 = jobj.get("total_pages");
		long i4 = (long) object3;
		System.out.println(i4);
		System.out.println();

		Object object4 = jobj.get("data");
		System.out.println(object4);
		System.out.println();

		JSONArray ar = (JSONArray) object4;
		for (int i = 0; i < ar.size(); i++) {
			Object ob1 = ar.get(i);
			JSONObject jobj1 = (JSONObject) ob1;

			Object objec5 = jobj1.get("id");
			long i11 = (long) objec5;
			System.out.println(i11);

			Object object5 = jobj1.get("flightName");
			String s1 = (String) object5;
			System.out.println(s1);

			Object object6 = jobj1.get("Country");
			String s2 = (String) object6;
			System.out.println(s2);

			Object object7 = jobj1.get("Destinations");
			String s3 = (String) object7;
			System.out.println(s3);

			Object object8 = jobj1.get("URL");
			String s4 = (String) object8;
			System.out.println(s4);
			
			System.out.println();

		}
		

		Object su = jobj.get("support");
		System.out.println(su);
		
		JSONObject jobj2 = (JSONObject) su;

		Object su1 = jobj2.get("url");
		String s1 = (String) su1;
		System.out.println(s1);

		Object su2 = jobj2.get("text");
		String s2 = (String) su2;
		System.out.println(s2);

	}

}
