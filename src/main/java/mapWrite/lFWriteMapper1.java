package mapWrite;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class lFWriteMapper1 {

	public static void main(String[] args) throws IOException, ParseException {

		File fi = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\listflWrite1.json");

		ObjectMapper map = new ObjectMapper();

		ArrayList<DatumWrite> al = new ArrayList<DatumWrite>();

		DatumWrite dt = new DatumWrite(23, "greens", "India", "56", "https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
		DatumWrite dt1 = new DatumWrite(23, "greens", "India", "56", "https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
		DatumWrite dt2= new DatumWrite(23, "greens", "India", "56", "https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
		DatumWrite dt3= new DatumWrite(23, "greens", "India", "56", "https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
		DatumWrite dt4 = new DatumWrite(23, "greens", "India", "56", "https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");

		al.add(dt);
		al.add(dt1);
		al.add(dt2);
		al.add(dt3);
		al.add(dt4);

		LF1SupportWrite rsw = new LF1SupportWrite("https:\\/\\/www.omrbranch.com", "Automation");

		LF1RootPojoWrite rpw = new LF1RootPojoWrite(1, 6, 454, 6565, al, rsw);

		map.writeValue(fi, rpw);

		System.out.println("done");

	}

}
