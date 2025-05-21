package sampleRest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SingleFlightPost {

	public static void main(String[] args) {

		RequestSpecification reqSpec;
		reqSpec = RestAssured.given();

		
		reqSpec = reqSpec.header("Content-Type", "application/json");

		// 3. Req Body/ Payload

		reqSpec = reqSpec.body("{\r\n"
				+ "    \"flightName\": \"AirIndia\",\r\n"
				+ "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": 80,\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"
				+ "}");

		Response response = reqSpec.post("https://omrbranch.com/api/flights");

		
		
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		String asString = response.asString();
		System.out.println(asString);

		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);
		
		

		
	}

}
