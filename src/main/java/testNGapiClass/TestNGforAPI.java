package testNGapiClass;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestNGforAPI {

	RequestSpecification reqSpec;

	String flightID;

	@Test(priority = 1)
	public void postSingleFlight() throws ParseException {

		reqSpec = RestAssured.given();

		reqSpec = reqSpec.header("Content-Type", "application/json");

		// 3. Req Body/ Payload

		reqSpec = reqSpec.body("{\r\n" + "    \"flightName\": \"AirIndia\",\r\n" + "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": 80,\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n" + "}");

		Response response = reqSpec.post("https://omrbranch.com/api/flights");

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);

		JSONParser jsonp = new JSONParser();

		Object obje1 = jsonp.parse(asPrettyString);

		JSONObject jobj = (JSONObject) obje1;

		Object object = jobj.get("data");
		System.out.println(object);

		JSONObject jobj2 = (JSONObject) object;

		Object db = jobj2.get("id");
		long id = (long) db;
		System.out.println(id);
		flightID = String.valueOf(id);

		Assert.assertEquals(statusCode, 201, "Flight Created Successfully");

	}

	@Test(priority = 2)
	public void getSingleFlight() {

		reqSpec = RestAssured.given();

		// 2. Header

		reqSpec = reqSpec.header("Content-Type", "application/json");

		// 3. Req Body/ Payload

		Response response = reqSpec.get("https://www.omrbranch.com/api/flight/" + flightID);

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);

		Assert.assertEquals(statusCode, 200, "Status code should be 200");

		System.out.println("success");

	}

	@Test(priority = 3)
	public void update() throws ParseException {

		reqSpec = RestAssured.given();

		reqSpec = reqSpec.header("Content-Type", "application/json");

		// 3. Req Body/ Payload

		reqSpec = reqSpec.body("{\r\n" + "    \"flightName\": \"AirIndia\",\r\n" + "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": 48,\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n" + "}");

		Response response = reqSpec.put("https://www.omrbranch.com/api/flight/" + flightID);

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);

		JSONParser jsonp = new JSONParser();

		Object obje1 = jsonp.parse(asPrettyString);

		JSONObject jobj = (JSONObject) obje1;

		Object object = jobj.get("data");
		System.out.println(object);

		JSONObject jobj2 = (JSONObject) object;

		Object db = jobj2.get("id");
		long id = (long) db;
		System.out.println(id);
		flightID = String.valueOf(id);

		Assert.assertEquals(statusCode, 200, "Flight Updated Successfully");

	}

	@Test(priority = 4)
	public void patch() throws ParseException {

		reqSpec = RestAssured.given();

		reqSpec = reqSpec.header("Content-Type", "application/json");

		// 3. Req Body/ Payload

		reqSpec = reqSpec.body("{\r\n" + "    \"Destinations\": 41\r\n" + "}");

		Response response = reqSpec.patch("https://www.omrbranch.com/api/flight/" + flightID);

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);

		JSONParser jsonp = new JSONParser();

		Object obje1 = jsonp.parse(asPrettyString);

		JSONObject jobj = (JSONObject) obje1;

		Object object = jobj.get("data");
		System.out.println(object);

		JSONObject jobj2 = (JSONObject) object;

		Object db = jobj2.get("id");
		long id = (long) db;
		System.out.println(id);
		flightID = String.valueOf(id);

		Assert.assertEquals(statusCode, 200, "Flight Updated Successfully");

	}

	@Test(priority = 5)
	public void getListFlight() throws ParseException {
		reqSpec = RestAssured.given();

		// 2. Header

		reqSpec = reqSpec.header("Content-Type", "application/json");

		// 3. Req Body/ Payload

		Response response = reqSpec.get("https://www.omrbranch.com/api/flights?page=1");

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		String asPrettyString = response.asPrettyString();

		System.out.println(asPrettyString);

		JSONParser jsonp = new JSONParser();
		Object obje1 = jsonp.parse(asPrettyString);

		JSONObject jobj = (JSONObject) obje1;

		Object object = jobj.get("page");
		String page = (String) object;
		System.out.println(page);

		Assert.assertEquals(statusCode, 200, "Get List Flight");

	}

	@Test(priority = 6)
	public void delete() throws ParseException {
		reqSpec = RestAssured.given();

		// 2. Header

		reqSpec = reqSpec.header("Content-Type", "application/json");

		// 3. Req Body/ Payload

		Response response = reqSpec.delete("https://www.omrbranch.com/api/flights?page=1");

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);

	}

	@Test(priority = 7)
	public void getListFlightcheck() throws ParseException {
		reqSpec = RestAssured.given();

		// 2. Header

		reqSpec = reqSpec.header("Content-Type", "application/json");

		// 3. Req Body/ Payload

		Response response = reqSpec.get("https://www.omrbranch.com/api/flights?page=1");

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		System.out.println("Deleted");

	}

}
