package sampleRest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get {
	
	public static void main(String[] args) {
		// 1. Initialize the RestAssured Class
		RequestSpecification reqSpec;
		reqSpec = RestAssured.given();

		// 2. Header

		reqSpec = reqSpec.header("Content-Type", "application/json");
		
		// 3. Req Body/ Payload

		Response response = reqSpec.get("https://www.omrbranch.com/api/flight/43569");

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		String asString = response.asString();
		System.out.println(asString);

		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);
		
	}

}
