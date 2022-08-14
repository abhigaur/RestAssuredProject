package basicTestAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006PostAuthAddaSignIn {

	@Test
	public void verifyGetAPI() {
		// baseURI>given>request

		RestAssured.baseURI = "https://staginguserapi.adda247.com/";
		RequestSpecification httpRequest = RestAssured.given();

		// create json body and send json data to request

		JSONObject requestPara = new JSONObject();

		requestPara.put("email", "gpreen08@gmail.com");
		requestPara.put("providerName", "email");
		requestPara.put("sec", "12345678");
		

		//httpRequest.contentType(ContentType.JSON);
		
		httpRequest.header("Content-Type","application/json");

		httpRequest.header("x-auth-token","fpoa43edty5");
		
		httpRequest.body(requestPara.toJSONString());

		Response response = httpRequest.request(Method.POST, "/login?src=aweb");
		String body = response.getBody().asString();
		System.out.println(body);

		int statusCode = response.getStatusCode();

		System.out.println(response.getStatusLine());
		// System.out.println(statusCode);
		
		String jwtToken = response.getBody().jsonPath().get("jwtToken").toString();
		
		System.out.println("JWT Token is"+jwtToken);

		Assert.assertEquals(statusCode, 200);

	}

}
