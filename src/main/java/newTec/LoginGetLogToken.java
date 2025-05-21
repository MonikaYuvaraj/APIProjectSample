package newTec;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jsonPath.BaseClassAPI;

public class LoginGetLogToken extends BaseClassAPI {
	int stateID;
	int CityID;
	String logtoken;
	String firstName;
	String lastName;
	String mobileNo;
	int addressId;
	int returnedAddressId;

	@Test(priority = 1)
	public void login() {
		addHeader("accept", "application/json");
		addHeader("Content-Type", "application/json");
		addBasicAuthuntication("monikayuvaraj145@gmail.com", "Monika112@");

		Response response = addRequest("POST", "https://www.omrbranch.com/api/postmanBasicAuthLogin");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		String AsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(AsPrettyString);

		JsonPath jsonPath = response.getBody().jsonPath();
		logtoken = jsonPath.getString("data.logtoken");
		System.out.println("LogToken");

		System.out.println(logtoken);

		Assert.assertEquals(statusCode, 200, "Flight Created Successfully");

	}

	@Test(priority = 2)
	public void getStateId() {
		addHeader("accept", "application/json");
		Response response = addRequest("GET", "https://www.omrbranch.com/api/stateList");

		int statusCode = getStatusCode(response);
		Assert.assertEquals(statusCode, 200, "Good");

		JsonPath jsonPath = response.getBody().jsonPath();
		List<String> stateName = jsonPath.get("data.name");
		for (int i = 0; i < stateName.size(); i++) {
			if (stateName.get(i).equals("Tamil Nadu")) {
				stateID = jsonPath.get("data[" + i + "].id");
			}
		}
		System.out.println(stateID);
	}

	@Test(priority = 3)
	public void getCityId() {
// add headers
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		List<Header> liHead = new ArrayList<Header>();
		liHead.add(h1);
		liHead.add(h2);
		Headers head = new Headers(liHead);
		addHeader(head);

		// add payload
		addPayload("{\r\n" + "  \"state_id\": \"" + stateID + "\"\r\n" + "}");

		Response res = addRequest("POST", "https://www.omrbranch.com/api/cityList");
		int statusCode = getStatusCode(res);
		String resBodyAsPrettyString = getResBodyAsPrettyString(res);
		System.out.println(resBodyAsPrettyString);
		Assert.assertEquals(statusCode, 200, "Good");

		JsonPath jsonPath = res.getBody().jsonPath();

		List<String> cityName = jsonPath.get("data.name");
		System.out.println(cityName);
		for (int i = 0; i < cityName.size(); i++) {
			if (cityName.get(i).equals("Chennai")) {
				CityID = jsonPath.get("data[" + i + "].id");
			}
		}
		System.out.println(CityID);
	}

	@Test(priority = 4)

	public void addAdd() {
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		Header h3 = new Header("Authorization", "Bearer " + logtoken);

		List<Header> liHead = new ArrayList<Header>();
		liHead.add(h1);
		liHead.add(h2);
		liHead.add(h3);

		Headers head = new Headers(liHead);
		addHeader(head);
		firstName = "Monika";
		lastName = "Yuvaraj";
		mobileNo = "8667847093";
		// add body
		addPayload("{\r\n" + "  \"first_name\": \"" + firstName + "\",\r\n" + "  \"last_name\": \"" + lastName
				+ "\",\r\n" + "  \"mobile\": \"" + mobileNo + "\",\r\n" + "  \"apartment\": \"apartment\",\r\n"
				+ "  \"state\": " + stateID + ",\r\n" + "  \"city\": " + CityID + ",\r\n" + "  \"country\": 101,\r\n"
				+ "  \"zipcode\": \"202020\",\r\n" + "  \"address\": \"64/63 partap nagar\",\r\n"
				+ "  \"address_type\": \"home\"\r\n" + "}");

		Response res = addRequest("POST", "https://www.omrbranch.com/api/addUserAddress");

		int statusCode = getStatusCode(res);
		System.out.println(statusCode);
		String resBodyAsPrettyString = getResBodyAsPrettyString(res);
		System.out.println(resBodyAsPrettyString);
		Assert.assertEquals(statusCode, 200, "verified");

		JsonPath jsonPath = res.getBody().jsonPath();
		String message = jsonPath.get("message");
		Assert.assertEquals(message, "Address added successfully", "Verfiy add Address");

		addressId = jsonPath.get("address_id");
		System.out.println(addressId);
	}

	@Test(priority = 5)
	public void getAddres() {
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		List<Header> liHead = new ArrayList<Header>();
		liHead.add(h1);
		liHead.add(h2);
		Headers head = new Headers(liHead);
		addHeader(head);

		Response res = addRequest("GET", "https://www.omrbranch.com/api/getUserAddress");
		int statusCode = getStatusCode(res);
		String resBodyAsPrettyString = getResBodyAsPrettyString(res);
		System.out.println(resBodyAsPrettyString);
		Assert.assertEquals(statusCode, 200, "Good");

		JsonPath jsonPath = res.getBody().jsonPath();

		List<String> allAddresses = jsonPath.getList("data");

		for (int i = 0; i < allAddresses.size(); i++) {

			returnedAddressId = jsonPath.getInt("data[" + i + "].id");

			if (returnedAddressId == addressId) {

				Object object = jsonPath.get("data[" + i + "].first_name");
				String fName = (String) object;

				Assert.assertEquals(fName, firstName);

				String lName = jsonPath.getString("data[" + i + "].last_name");

				Assert.assertEquals(lName, lastName);
				String mobile = jsonPath.getString("data[" + i + "].mobile");
				Assert.assertEquals(mobile, mobileNo);

				Object object2 = jsonPath.get("data[" + i + "].state_id");
				int state = (int) object2;

				Assert.assertEquals(state, stateID);

				int city = jsonPath.getInt("data[" + i + "].city_id");
				Assert.assertEquals(city, CityID);

			}
		}
		Assert.assertEquals(returnedAddressId, addressId, "Returned address ID should match the added one");
	}
	
	//@Test(priority = 6)
	public void deleteAddress() {

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		Header h3 = new Header("Authorization", "Bearer " + logtoken);

		List<Header> liHead = new ArrayList<Header>();
		liHead.add(h1);
		liHead.add(h2);
		liHead.add(h3);

		Headers head = new Headers(liHead);
		addHeader(head);
		
		addPayload("{\r\n"
				+ "  \"address_id\": \"3859\"\r\n"
				+ "}");

		Response res = addRequest("DELETE", "https://www.omrbranch.com/api/deleteAddress");

		int statusCode = getStatusCode(res);
		System.out.println(statusCode);
		String resBodyAsPrettyString = getResBodyAsPrettyString(res);
		System.out.println(resBodyAsPrettyString);
		Assert.assertEquals(statusCode, 200, "verified");
		
		
	}
	
	

}
