package map2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class listFlightMapper {

	public static void main(String[] args) throws IOException, ParseException {

		File fi = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\listfl.json");

		ObjectMapper map = new ObjectMapper();
		LF1RootPojo rp = map.readValue(fi, LF1RootPojo.class);

		int page = rp.getPage();
		System.out.println(page);

		int per_page = rp.getPer_page();
		System.out.println(per_page);

		int total = rp.getTotal();
		System.out.println(total);

		int total_pages = rp.getTotal_pages();
		System.out.println(total_pages);

		System.out.println();
		ArrayList<Datum> data = rp.getData();

		for (Datum datum : data) {
			System.out.println(datum.id);
			System.out.println(datum.flightName);
			System.out.println(datum.country);
			System.out.println(datum.destinations);
			System.out.println(datum.uRL);
			System.out.println();

		}

	}

}
