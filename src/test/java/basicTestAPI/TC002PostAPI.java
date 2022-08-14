package basicTestAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002PostAPI {

	@Test
	public void verifyGetAPI() {
		// baseURI>given>request

		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httpRequest = RestAssured.given();

		// create json body and send json data to request

		JSONObject requestPara = new JSONObject();

		requestPara.put("name", "abhilash");
		requestPara.put("job", "teamLead01");

		//httpRequest.contentType(ContentType.JSON);
		
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(requestPara.toJSONString());

		Response response = httpRequest.request(Method.POST, "/api/users");
		String body = response.getBody().asString();
		System.out.println(body);

		int statusCode = response.getStatusCode();

		System.out.println(response.getStatusLine());
		// System.out.println(statusCode);

		Assert.assertEquals(statusCode, 201);

	}

}
