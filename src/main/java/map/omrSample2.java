package map;

import java.io.File;
import java.io.IOException;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class omrSample2 {

	public static void main(String[] args) throws IOException, ParseException {

		File fi = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\sample.json");
		
		ObjectMapper map = new ObjectMapper();
		
		OmrPojo op = map.readValue(fi, OmrPojo.class);
		
		omrData data = op.getData();		
		
		int id = data.getId();
		System.out.println(id);
		
		String flightName = data.getFlightName();
		System.out.println(flightName);
		
		String country = data.getCountry();
		System.out.println(country);
		
		String destinations = data.getDestinations();
		System.out.println(destinations);
		
		String getuRL = data.getuRL();
		System.out.println(getuRL);
		
		String created_Date = data.getCreated_Date();
		System.out.println(created_Date);
		
		String updated_Date = data.getUpdated_Date();
		System.out.println(updated_Date);
		
		
		Support support = op.getSupport();
		
		String url = support.getUrl();
		System.out.println(url);
		
		String text = support.getText();
		System.out.println(text);
		
		
		
		
		
		
	}

}
