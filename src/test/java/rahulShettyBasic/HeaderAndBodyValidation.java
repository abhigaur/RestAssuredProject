package rahulShettyBasic;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.text.IsEqualIgnoringCase;
import org.json.simple.JSONObject;
import org.testng.Assert;

import files.PayloadPostAPI;

public class HeaderAndBodyValidation {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		// Direct validation

		/*
		 * given().log().all().queryParams("key", "qaclick123").header("Content-Type",
		 * "application/json")
		 * .body(PayloadPostAPI.payload()).when().post("maps/api/place/add/json").then()
		 * .log().all().assertThat() .statusCode(200).body("scope",
		 * equalTo("APP")).header("Server", "Apache/2.4.41 (Ubuntu)");
		 */

		// store complete response in variable

		String response = given().log().all().queryParams("key", "qaclick123")
				.header("Content-Type", "application/json").body(PayloadPostAPI.payload()).when()
				.post("maps/api/place/add/json").then().extract().response().asString();

		System.out.println("response is " + response);

		// Print particular path from response

		JsonPath js = new JsonPath(response);

		String placeID = js.get("place_id");
		System.out.println("Place id is" + placeID);

		// Scenario is got plaace id from post api then ,use it in UPdate Put api .Then
		// validate.
		
		//Update address as well and validate updated address coming or not
		
		String homeAdd="Vpo Tajpur dist mohindergar";

		given().log().all().queryParams("key", "qaclick123").header("Content-Type", "application/json").

				body("{\r\n" + "\"place_id\":\"" + placeID + "\",\r\n" + "\"address\":\""+homeAdd+"\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}\r\n" + "")
				.when().put("/maps/api/place/update/json").then().assertThat().log().all().statusCode(200)
				.body("msg", equalTo("Address successfully updated"));
		
		
		//Get updated Place
		
	 String resp = given().log().all().queryParams("key", "qaclick123").queryParam("place_id", placeID)
		.when().get("/maps/api/place/get/json").
		then().extract().response().asString();
	
	JsonPath js1= new JsonPath(resp);
	
	String actualAddress = js1.get("address");
	
	System.out.println("Addrss updated is  "+actualAddress);
	
	Assert.assertEquals(actualAddress, homeAdd);
	
	
		

	}

}
