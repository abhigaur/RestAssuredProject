package rahulShettyBasic;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.hamcrest.text.IsEqualIgnoringCase;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PayloadReadFromExternalFile {

	@Test()
	public void addaLogin() throws IOException {

		RestAssured.baseURI = "https://userapi.adda247.com";
		
		// Content of file can conver into byte> byte can be converted to string 

		given().log().all().queryParam("src", "aweb").header("x-auth-token", "fpoa43edty5").header("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36")
				.header("content-type", "application/json")
				.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\adda247\\eclipse-workspace\\RestAssuredProject\\src\\test\\java\\files\\jsonFile.json")))).when()
				.post("login").then().log().all().assertThat().statusCode(200);

	}
	/*
	 * @org.testng.annotations.DataProvider(name="logingdata") public Object[][]
	 * dataforLogin() {
	 * 
	 * Object[][] data = {
	 * {"gpreen08@gmail.com","12345678"},{"abhilash.gaur@adda247.com","123456"},{
	 * "abhilash.gaur@adda24sdfsd7.com","123456"} };
	 * 
	 * return data;
	 * 
	 * }
	 */

}
