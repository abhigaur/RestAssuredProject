package basicTestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003ValidateReceiverHeader {

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
		//System.out.println(statusCode);
		
		
		//getting single Header value
		
		/*
		 * String server = response.header("Server"); System.out.println(server);
		 */
		
		//Getting all headers
		
		Headers allHeader = response.getHeaders();
		
		for(Header header:allHeader)
		{
			System.out.println(header.getName()+  " "+ header.getValue());
		}
		
		Assert.assertEquals(statusCode, 200);
		
		
	}
	
}
