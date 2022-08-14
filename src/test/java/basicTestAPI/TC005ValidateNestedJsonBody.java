package basicTestAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TC005ValidateNestedJsonBody {

	@Test
	public void verifyGetAPI()
	{
		//baseURI>given>request
		
		RestAssured.baseURI="https://reqres.in/";
		
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/api/users?page=2");
		String body = response.getBody().asString();
		//System.out.println(body);
		
		// Print normal json value
		
		
		
		 String value = response.getBody().jsonPath().get("data.id[1]").toString();
		 
		 System.out.println("Total pages are "+value);
		 
		 
		 
		
		
		int statusCode = response.getStatusCode();
		
		System.out.println(response.getStatusLine());
		//System.out.println(statusCode);
		
		Assert.assertEquals(statusCode, 200);
		
		
	}
	
}
