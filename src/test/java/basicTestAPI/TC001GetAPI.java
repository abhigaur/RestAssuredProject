package basicTestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001GetAPI {

	@Test
	public void verifyGetAPI()
	{
		//baseURI>given>request
		
		RestAssured.baseURI="https://reqres.in/";
		
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/api/users?page=2");
		String body = response.getBody().asString();
		//System.out.println(body);
		
		int statusCode = response.getStatusCode();
		
		System.out.println(response.getStatusLine());
		System.out.println(statusCode);
		
		Assert.assertEquals(statusCode, 200);
		
		
	}
	
}
