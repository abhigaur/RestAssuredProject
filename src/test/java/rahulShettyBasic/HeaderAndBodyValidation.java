package rahulShettyBasic;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.text.IsEqualIgnoringCase;

import files.PayloadPostAPI;

public class HeaderAndBodyValidation {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		given().log().all().queryParams("key", "qaclick123").header("Content-Type", "application/json")
				.body(PayloadPostAPI.payload()).when().post("maps/api/place/add/json").then().log().all().assertThat()
				.statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.41 (Ubuntu)");

	}

}
