package Day1;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class listFlight {

	public static void main(String[] args) throws IOException, ParseException {

		FileReader fi = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\listfl.json");
		JSONParser jsonp = new JSONParser();
		Object ob = jsonp.parse(fi);

		JSONObject jobj = (JSONObject) ob;
		System.out.println(jobj);

		Object object = jobj.get("page");
		System.out.println(object);
		Object object1 = jobj.get("per_page");
		System.out.println(object1);
		Object object2 = jobj.get("total");
		System.out.println(object2);
		Object object3 = jobj.get("total_pages");
		System.out.println(object3);

		Object object4 = jobj.get("data");
		System.out.println(object4);

		JSONArray ar = (JSONArray) object4;
		for (int i = 0; i < ar.size(); i++) {
			Object ob1 = ar.get(i);
			JSONObject jobj1 = (JSONObject) ob1;
			
			Object objec5 = jobj1.get("id");
			System.out.println(objec5);
			
			Object object5 = jobj1.get("flightName");
			System.out.println(object5);
			
			Object object6 = jobj1.get("Country");
			System.out.println(object6);

			Object object7 = jobj1.get("Destinations");
			System.out.println(object7);
			
			Object object8 = jobj1.get("URL");
			System.out.println(object8);

		}



	}

}
