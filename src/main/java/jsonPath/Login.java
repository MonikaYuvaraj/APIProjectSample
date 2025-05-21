package jsonPath;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

@Test


public class Login extends BaseClassAPI {

	public void login() {
		addHeader("accept", "application/json");
		addHeader("Content-Type", "application/json");
		addBasicAuthuntication("monikayuvaraj145@gmail.com", "Monika112@");
		addPayload("{\r\n"
				+ "  \"email\": \"dummy@gmail.com\",\r\n"
				+ "  \"pass\": \"dummy123\",\r\n"
				+ "  \"device_id\": \"Ab#13\",\r\n"
				+ "  \"device_type\": \"Android\",\r\n"
				+ "  \"device_token\": \"jytrtyteeeeeeeeeeeey\"\r\n"
				+ "}");
		
		Response response = addRequest("POST", "https://www.omrbranch.com/api/postmanBasicAuthLogin");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		String AsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(AsPrettyString);

	   Assert.assertEquals(statusCode, 200,"Flight Created Successfully");

	}

}
