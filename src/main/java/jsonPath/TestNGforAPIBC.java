package jsonPath;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGforAPIBC extends BaseClassAPI {

	@Test
	public void postSingleFlight() throws ParseException {


		addHeader("Content-Type", "application/json");

		addPayload("{\r\n" + "    \"flightName\": \"AirIndia\",\r\n" + "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": \"87\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n" + "}");

		addRequest("POST", "https://www.omrbranch.com/api/flights");

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);
		
		Assert.assertEquals(statusCode, 201,"Flight Created Successfully");
	}

}
