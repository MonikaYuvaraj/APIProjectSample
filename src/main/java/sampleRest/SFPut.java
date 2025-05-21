package sampleRest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SFPut {

	public static void main(String[] args) {
		// 1. Initialize the RestAssured Class

		RequestSpecification reqSpec;
		reqSpec = RestAssured.given();

		// Header, Req body, Auth

		// 2. Header

		reqSpec = reqSpec.header("Content-Type", "application/json");
		// 3. Req Body/ Payload

		reqSpec = reqSpec.body("{\r\n" + "    \"flightName\": \"AirIndia\",\r\n" + "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": 80,\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n" + "}");
		
		
		// 4. Pass the endpoint

		Response response = reqSpec.put("https://www.omrbranch.com/api/flight/43434");
		
		
		
		// Status Code

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		
		// Get the res body asString

		String asString = response.asString();
		System.out.println(asString);

		// Get the res body asPrettyString

		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);

	}

}
