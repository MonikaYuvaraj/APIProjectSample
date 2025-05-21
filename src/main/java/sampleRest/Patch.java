package sampleRest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Patch {
	public static void main(String[] args) {
		RequestSpecification reqSpec;
		reqSpec = RestAssured.given();

		
		reqSpec = reqSpec.header("Content-Type", "application/json");

		reqSpec = reqSpec.body("{\r\n"
				+ "    \"Destinations\": 41\r\n"
				+ "}");

		Response response = reqSpec.patch("https://www.omrbranch.com/api/flight/43238");

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		String asString = response.asString();
		System.out.println(asString);

		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);
		
	}
	

}
